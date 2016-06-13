package com.src.main.classconverters;

import com.src.main.command.BaseCO;
import com.src.main.domains.entity.CommonDataEntity;

/**
 * Created by mj on 12/6/16.
 */
public interface COToDomain<U extends CommonDataEntity, T extends BaseCO<U>> extends BaseConverter {
    U convert(T t, Long userId, boolean isCreated) throws Exception;
}
