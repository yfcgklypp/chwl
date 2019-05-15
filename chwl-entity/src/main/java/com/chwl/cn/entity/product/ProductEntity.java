package com.chwl.cn.entity.product;

import javax.persistence.Table;

import com.chwl.cn.entity.member.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor // 全参构造方法
@NoArgsConstructor // 无参构造方法
@Accessors(chain = true) // 链式编程写法
@Table(name = "t_product")
public class ProductEntity extends BaseEntity {

	private String name;

//	@Transient
//	public Date getCreateDate() {
//		return super.createDate;
//	}
//
//	@Transient
//	public Date getUpdateDate() {
//		return super.updateDate;
//	}

}
