package com.chwl.cn.service.common;

import com.chwl.cn.entity.member.BaseEntity;

public interface InsertService<T extends BaseEntity> {

    /**
     * 保存实体，null属性也会保存，不适用数据库默认值
     * @param t
     * @return
     */
    public int insert(T t);

    /**
     * 保存实体，null的属性不会保存，使用数据库默认值
     * @param t
     * @return
     */
    public int insertSelective(T t);
}
