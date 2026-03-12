package com.mediway.hos.srm.business.base.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public interface BaseService<T> extends IService<T> {
    int insert(T record);

    int deleteById(Serializable key);

    int deleteByIds(String ids);

    int delete(T record);

    int updateNotNullByPrimaryKey(T record);

    List<T> selectAll();

    T selectById(Serializable key);

    List<T> selectList(T record);

    T selectOne(T t);

    IPage<T> selectPage(Page<T> page, T t);

    IPage<Map<String, Object>> selectMapsPage(Page<Map<String, Object>> page, T t);
}

