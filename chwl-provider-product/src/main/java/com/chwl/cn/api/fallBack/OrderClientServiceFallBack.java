package com.chwl.cn.api.fallBack;

import org.springframework.stereotype.Component;

import com.chwl.cn.api.OrderClientService;
import com.chwl.cn.entity.order.OrderEntity;

@Component
public class OrderClientServiceFallBack implements OrderClientService{

	@Override
	public OrderEntity find(Long id) {
		return new OrderEntity().setOrderNumber("66666");
	}

}
