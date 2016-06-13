package com.src.main.command;

import com.src.main.domains.entity.CommonDataEntity;

import java.util.Date;

/**
 * Created by mj on 12/6/16.
 */
public class AbstractDomainCO<T extends CommonDataEntity> implements BaseCO<T> {
    private Date creationTime;
    private Long createdBy;
    private Long lastModifiedBy;
    private Integer status;
    private Date lastModificationTime;

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(Long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getLastModificationTime() {
        return lastModificationTime;
    }

    public void setLastModificationTime(Date lastModificationTime) {
        this.lastModificationTime = lastModificationTime;
    }
}
