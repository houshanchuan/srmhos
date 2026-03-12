package com.mediway.hos.srm.business.base.service.impl;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.base.service.BaseService;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {
    private static final Logger log = LoggerFactory.getLogger(com.mediway.hos.database.service.impl.BaseServiceImpl.class);
    @Autowired
    private M myMapper;

    public BaseServiceImpl() {
    }

    @Transactional
    public int insert(T record) {
        return this.myMapper.insert(record);
    }

    @Transactional
    public int deleteById(Serializable key) {
        return this.myMapper.deleteById(key);
    }

    @Transactional
    public int deleteByIds(String ids) {
        String[] newIds = ids.split(",");
        List<String> idList = Arrays.asList(newIds);
        return this.myMapper.deleteBatchIds(idList);
    }

    @Transactional
    public int delete(T record) {
        QueryWrapper<T> wrapperEntity = new QueryWrapper();
        wrapperEntity.setEntity(record);
        return this.myMapper.delete(wrapperEntity);
    }

    public List<T> selectList(T record) {
        QueryWrapper<T> queryWrapper = new QueryWrapper();
        queryWrapper.setEntity(record);
        return this.myMapper.selectList(queryWrapper);
    }

    public T selectById(Serializable key) {
        return this.myMapper.selectById(key);
    }

    public List<T> selectAll() {
        QueryWrapper<T> queryWrapper = new QueryWrapper();
        return this.myMapper.selectList(queryWrapper);
    }

    @Transactional
    public int updateNotNullByPrimaryKey(T record) {
        return this.myMapper.updateById(record);
    }

    public Map<String, Object> entityToTableCloumn(Object obj) {
        Map<String, Object> map = new HashMap();
        new StringBuilder();
        Class c = obj.getClass();
        if (!c.isAnnotationPresent(TableName.class)) {
            return null;
        } else {
            TableName table = (TableName)c.getAnnotation(TableName.class);
            map.put("tableName", table.value());
            Field[] fields = c.getDeclaredFields();
            Field[] var7 = fields;
            int var8 = fields.length;

            for(int var9 = 0; var9 < var8; ++var9) {
                Field field = var7[var9];
                if (field.isAnnotationPresent(TableField.class) || field.isAnnotationPresent(TableId.class)) {
                    String columnName = null;
                    String fieldName = null;
                    if (field.isAnnotationPresent(TableId.class)) {
                        TableId id = (TableId)field.getAnnotation(TableId.class);
                        columnName = id.value();
                        fieldName = field.getName();
                    } else {
                        if (!field.isAnnotationPresent(TableField.class)) {
                            continue;
                        }

                        TableField column = (TableField)field.getAnnotation(TableField.class);
                        columnName = column.value();
                        fieldName = field.getName();
                    }

                    if (StringUtils.isNotBlank(columnName)) {
                        String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

                        try {
                            Method method = c.getDeclaredMethod(methodName);
                            Object o = method.invoke(obj);
                            map.put(columnName, o);
                        } catch (Exception var16) {
                            var16.printStackTrace();
                        }
                    }
                }
            }

            return map;
        }
    }

    public T selectOne(T record) {
        QueryWrapper<T> queryWrapper = new QueryWrapper();
        queryWrapper.setEntity(record);
        return this.myMapper.selectOne(queryWrapper);
    }

    public IPage<T> selectPage(Page<T> page, T t) {
        QueryWrapper<T> queryWrapper = new QueryWrapper();
        queryWrapper.setEntity(t);
        return this.myMapper.selectPage(page, queryWrapper);
    }

    public IPage<Map<String, Object>> selectMapsPage(Page<Map<String, Object>> page, T t) {
        QueryWrapper<T> queryWrapper = new QueryWrapper();
        queryWrapper.setEntity(t);
        return this.myMapper.selectMapsPage(page, queryWrapper);
    }
}

