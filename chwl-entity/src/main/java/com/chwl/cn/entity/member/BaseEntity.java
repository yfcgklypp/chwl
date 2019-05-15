package com.chwl.cn.entity.member;

import com.chwl.cn.entity.IdEntity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data // getter、setter
//@AllArgsConstructor // 全参构造方法
//@NoArgsConstructor // 无参构造方法
@Accessors(chain = true) // 链式编程写法
public class BaseEntity extends IdEntity {
	/**
	* 
	*/
	private static final long serialVersionUID = 3290099743149579363L;

//	protected Date createDate;
//
//	protected Date updateDate;
}
