package com.chwl.cn.entity.member;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data // getter、setter
@AllArgsConstructor // 全参构造方法
@NoArgsConstructor // 无参构造方法
@Accessors(chain = true) // 链式编程写法
@Table(name="member")
public class MemberEntity extends BaseEntity {
	/**
	* 
	*/
	private static final long serialVersionUID = 2215159164084061217L;

	private String memberName;// 会员登录用户名
	private String nickName;// 昵称
	private String tel;// 电话
	private String pwd;// 密码
	private String headImg;// 头像图片
	private String signature;// 个性签名
	private Integer status;//状态 1禁用 2启用
}
