package com.chwl.cn.service.common;

import com.chwl.cn.entity.member.BaseEntity;

public interface DeleteService<T extends BaseEntity> {

    /**
     * 通过ID删除
     * @param id
     * @return
     */
    public int deleteById(Long id);

    /**
     * 通过属性删除，实体属性如果存在值匹配删除
     * @param t
     * @return
     */
    public int delete(T t);

}
