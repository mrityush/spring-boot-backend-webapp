package com.src.main.exceptions.classes;

import com.src.main.enums.exceptions.CustomExceptionEnum;

public class GenericException extends RuntimeException {

    public String key = CustomExceptionEnum.GENERIC_EXCEPTION.getKey();

    public GenericException() {
    }

    public GenericException(CustomExceptionEnum customExceptionEnum) {
        super();
        key = customExceptionEnum.getKey();
    }

    public GenericException(String message) {
        super(message);
    }
}
