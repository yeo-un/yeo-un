package com.yeoun.server.infra.exception;

import lombok.Getter;

public class InvalidRequestParameterException extends RuntimeException implements CustomRuntimeException {

    @Getter
    private final String NAME;

    public InvalidRequestParameterException(String message) {
        super(message);
        NAME = "InvalidRequestParameterException";
    }
}
