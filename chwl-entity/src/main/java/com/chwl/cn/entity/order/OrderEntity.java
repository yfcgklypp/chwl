package com.chwl.cn.entity.order;

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
@Table(name="t_order")
public class OrderEntity extends BaseEntity{

	private String orderNumber;//数据库默认字段名order_number 驼峰命名，大写字母前以_表示
	
	private String serialNumber;
}
