package com.chwl.cn.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data//getter、setter
@AllArgsConstructor//全参构造方法
@NoArgsConstructor//无参构造方法
@Accessors(chain=true)//链式编程写法
public class IdEntity implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = -2384621493671696643L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

}
