package com.src.main.exceptions.classes;

import com.src.main.enums.exceptions.CustomExceptionEnum;

/**
 * Created by mj on 11/6/16.
 */
public class InvalidUserException extends Exception {
    public String key = CustomExceptionEnum.INVALID_USER_EXCEPTION.getKey();
    public InvalidUserException(String s) {
        super(s);
    }

    public InvalidUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidUserException(Throwable cause) {
        super(cause);
    }

    public InvalidUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public InvalidUserException() {
    }
}