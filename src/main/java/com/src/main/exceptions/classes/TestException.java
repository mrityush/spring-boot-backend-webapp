package com.src.main.exceptions.classes;

import com.src.main.enums.exceptions.CustomExceptionEnum;

/**
 * Created by intelligrape on 15/2/16.
 */
public class TestException extends GenericException {

    {
        this.key= CustomExceptionEnum.TEST_EXCEPTION.getKey();
    }

    public TestException(){
    }

    public TestException(String message){
        super(message);
    }
}
