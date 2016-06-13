package com.src.main.dao.interfaces;

import com.src.main.searchfilter.BaseItemFilter;
import com.src.main.domains.entity.BaseEntity;

import java.util.List;

/**
 * Created by mj on 25/5/16.
 */
public interface BaseDao<T extends BaseEntity, U extends BaseItemFilter<T>> {
    List<T> findItems(U u);

    T save(T t);

    T update(T t);

    T get(Long id);

    List<T> findAll();

    long count();
}
