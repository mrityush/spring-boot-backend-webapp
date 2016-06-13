package com.src.main.classconverters.cotodomain;

import com.src.main.command.AbstractDomainCO;
import com.src.main.domains.entity.CommonDataEntity;

import java.util.Date;

/**
 * Created by mj on 12/6/16.
 */
public class AbstractCOToDomainConverter<U extends CommonDataEntity, T extends AbstractDomainCO<U>> {

    protected U updateStatus(T t, U u) {
        if (t.getStatus() == null) {
            u.setStatus(1);
        } else {
            u.setStatus(t.getStatus());
        }
        return u;
    }

    protected U initialiseCommonFields(T t, U u, Long userId, boolean isCreated) {
        u = updateStatus(t, u);
        u = (isCreated) ? addCreationDetails(u, userId) : u;
        u = addModificationDetails(u, userId);
        return u;
    }

    protected U addCreationDetails(U u, Long userId) {
        u.setCreatedBy(userId);
        u.setCreationTime(new Date());
        return u;
    }

    protected U addModificationDetails(U u, Long userId) {
        u.setLastModifiedBy(userId);
        u.setLastModificationTime(new Date());
        return u;
    }
}
