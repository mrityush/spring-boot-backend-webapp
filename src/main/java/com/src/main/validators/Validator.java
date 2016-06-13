package com.src.main.validators;

import com.src.main.command.BaseCO;

/**
 * Created by mj on 11/6/16.
 */
public interface Validator<T extends BaseCO> {
    boolean validate();
}

