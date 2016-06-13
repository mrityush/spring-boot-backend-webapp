package com.src.main.services.implementations;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public abstract class AbstractService<DOMAIN, DTO> {

    @Autowired
    private Mapper mapper;

    public Object convert(Object source, Class clazz) {
        if (source != null) {
            return mapper.map(source, clazz);
        }
        return null;
    }

    public DOMAIN coToDomain(Object source, Class<DOMAIN> clazz) {
        if (source != null) {
            return mapper.map(source, clazz);
        }
        return null;
    }

    public DTO domainToDTO(Object source, Class<DTO> clazz) {
        if (source != null) {
            return mapper.map(source, clazz);
        }
        return null;
    }

    public DOMAIN dtoToDomain(Object source, Class<DOMAIN> clazz) {
        if (source != null) {
            return mapper.map(source, clazz);
        }
        return null;
    }

    public boolean isEmptyMap(Map map) {
        return (isEmptyObject(map) || map.isEmpty());
    }

    public boolean isNotEmptyMap(Map map) {
        return (!isEmptyMap(map));
    }

    public boolean isEmptyObject(Object object) {
        return (object == null);
    }

    public boolean isNotEmptyObject(Object object) {
        return (!isEmptyObject(object));
    }

    public boolean isEmptyList(List list) {
        return (isEmptyObject(list) || list.isEmpty());
    }

    public boolean isNotEmptyList(List list) {
        return !isEmptyList(list);
    }

}
