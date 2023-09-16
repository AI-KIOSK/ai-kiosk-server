package com.hongik.kiosk.ui.controller;

import com.hongik.kiosk.application.service.customer.CustomerOperationUseCase;
import com.hongik.kiosk.application.service.customer.CustomerReadUseCase;
import com.hongik.kiosk.exception.AiKioskException;
import com.hongik.kiosk.ui.requestBody.CustomerCreateRequest;
import com.hongik.kiosk.ui.view.ApiResponseView;
import com.hongik.kiosk.ui.view.CustomerView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.hongik.kiosk.application.service.customer.CustomerOperationUseCase.*;
import static com.hongik.kiosk.application.service.customer.CustomerReadUseCase.*;
import static com.hongik.kiosk.exception.MessageType.*;

@Slf4j
@Tag(name = "customer", description = "고객 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class CustomerController {

    private final CustomerOperationUseCase customerOperationUseCase;
    private final CustomerReadUseCase customerReadUseCase;

    @Operation(summary = "signup customer", description = "전화번호와 성별을 받아 회원가입")
    @PostMapping("")
    public ResponseEntity<ApiResponseView<CustomerView>> save(@RequestBody CustomerCreateRequest request) {
        CustomerCreateCommand command = CustomerCreateCommand.builder()
                .phoneNumber(request.getPhoneNumber())
                .gender(request.getGender())
                .build();

        if (!checkDuplicate(command)) throw new AiKioskException(DUPLICATED);

        FindCustomerResult result = customerOperationUseCase.createCustomer(command);

        return ResponseEntity.ok(new ApiResponseView<>(new CustomerView(result)));
    }

    private boolean checkDuplicate(CustomerCreateCommand command) {
        String checkPhoneNumber = command.getPhoneNumber();

        CustomerFindQuery validationQuery = new CustomerFindQuery(checkPhoneNumber);

        try {
            customerReadUseCase.getUser(validationQuery);
            return false;
        } catch (AiKioskException ignored) {
            return true;
        }

    }

    @Operation(summary = "get customer info", description = "전화번호를 통해 유저 정보 받아오기")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = CustomerView.class))),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND")
    })
    @GetMapping("")
    public ResponseEntity<ApiResponseView<CustomerView>> getUser(@RequestParam(value = "phone") String phoneNumber) {

        CustomerFindQuery query = new CustomerFindQuery(phoneNumber);
        FindCustomerResult result = customerReadUseCase.getUser(query);

        return ResponseEntity.ok(new ApiResponseView<>(new CustomerView(result)));
    }
}
