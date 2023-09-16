package com.hongik.kiosk.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AiKioskException extends RuntimeException {
    private final HttpStatus status;
    private final String type;

    public AiKioskException(MessageType message) {
        super(message.getMessage());
        this.status = message.getStatus();
        this.type = message.name();
    }
}
