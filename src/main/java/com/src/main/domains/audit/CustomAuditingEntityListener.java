package com.src.main.domains.audit;

import com.src.main.domains.entity.CommonDataEntity;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

@Component
public class CustomAuditingEntityListener {

    @PrePersist
    public void touchForCreate(CommonDataEntity entity) {
        Date now = new Date();
        entity.setCreationTime(now);
        entity.setLastModificationTime(now);
    }

    @PreUpdate
    public void touchForUpdate(CommonDataEntity entity) {
        entity.setLastModificationTime(new Date());
    }
}
