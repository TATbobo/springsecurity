package com.tucker.securitycore.exception;

import org.springframework.security.core.AuthenticationException;

public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = -1520360252818141526L;

    public ValidateCodeException(String msg) {
        super(msg);
    }

}
