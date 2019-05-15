package com.chwl.cn.service.base;

import com.chwl.cn.entity.member.BaseEntity;
import com.chwl.cn.service.common.DeleteService;
import com.chwl.cn.service.common.InsertService;
import com.chwl.cn.service.common.SelectService;
import com.chwl.cn.service.common.UpdateService;

public interface IBaseService<T extends BaseEntity>
        extends InsertService<T>,
        UpdateService<T>,
        DeleteService<T>,
        SelectService<T> {

//    @Override
//    public int deleteByExample(Object example) {
//        return 0;
//    }
//
//    @Override
//    public List selectByExample(Object example) {
//        return null;
//    }
//
//    @Override
//    public int selectCountByExample(Object example) {
//        return 0;
//    }
//
//    @Override
//    public Object selectOneByExample(Object example) {
//        return null;
//    }
//
//    @Override
//    public int updateByExample(Object record, Object example) {
//        return 0;
//    }
//
//    @Override
//    public int updateByExampleSelective(Object record, Object example) {
//        return 0;
//    }
//
//    @Override
//    public List selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
//        return null;
//    }
//
//    @Override
//    public List selectByRowBounds(Object record, RowBounds rowBounds) {
//        return null;
//    }
}
