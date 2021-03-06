package com.fantasy.xxbase.service;

import com.fantasy.xxbase.dao.BaseDao;
import com.fantasy.xxbase.entity.XXBaseEntity;
import com.fantasy.xxbase.vo.Page;
import com.fantasy.xxbase.vo.Pageable;
import com.fantasy.xxbase.vo.QueryParam;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

/**
 * Created by lifang on 2015/1/22.
 */
public interface BaseService<T extends XXBaseEntity> {


    Page<T> find(List<QueryParam> queryParams);

    Page<T> find(List<QueryParam> queryParams, Pageable pageable);

    T findById(@NotNull String id);

    T findOneByName(String name);

    Page<T> findAll();

    Page<T> page(int pageNo, int pageSize);

    void persist(@NotNull T t);

    void persist(@NotNull Collection<T> t);

    T merge(@NotNull T t);

    void remove(@NotNull T t);

    void remove(@NotNull String id);

    long clean();

    Page<T> findByName(String name);

}
