package com.chwl.cn.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chwl.cn.api.ProductClientService;
import com.chwl.cn.entity.order.OrderEntity;
import com.chwl.cn.entity.product.ProductEntity;
import com.chwl.cn.service.order.IOrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private ProductClientService productClientService;
	@Autowired
	private IOrderService orderService;
	
	@RequestMapping(value = "/getProduct/{id}", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod="fallbackGetId")
	public ProductEntity find(@PathVariable("id") long id) {
		ProductEntity productEntity = productClientService.find(id);
		if(productEntity==null){
			throw new NullPointerException();
		}
		return productEntity;
	}
	
	public ProductEntity fallbackGetId(long id){
		System.out.println("从订单去获取产品异常了");
		return new ProductEntity();
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public OrderEntity get(@PathVariable("id") long id) {
		return orderService.selectById(id);
	}
}
