package com.src.main.classconverters;

import com.src.main.domains.entity.BaseEntity;
import com.src.main.dto.BaseDTO;

/**
 * Created by mj on 12/6/16.
 */
public interface DomainToDTO<U extends BaseEntity, T extends BaseDTO<U>> extends BaseConverter{
    T convert(U u);
}
