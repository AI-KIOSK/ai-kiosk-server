package com.hongik.kiosk.application.domain.customer;

import org.apache.commons.lang3.ObjectUtils;

public enum Gender {
    MALE, FEMALE, INVALID;

    static Gender find(String name) {
        if(ObjectUtils.isEmpty(name)) {
            return INVALID;
        }

        for(Gender type : Gender.values()) {
            if(type.name().equals(name.toUpperCase())) {
                return type;
            }
        }
        return Gender.INVALID;
    }
}
