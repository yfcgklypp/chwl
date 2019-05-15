package com.chwl.cn.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chwl.cn.api.fallBack.OrderClientServiceFallBack;
import com.chwl.cn.entity.order.OrderEntity;

@FeignClient(name="CHWL-PROVIDER-ORDER",fallback=OrderClientServiceFallBack.class)
public interface OrderClientService {

	@RequestMapping(value = "/order/get/{id}", method = RequestMethod.GET)
	public OrderEntity find(@PathVariable("id") Long id);
}
