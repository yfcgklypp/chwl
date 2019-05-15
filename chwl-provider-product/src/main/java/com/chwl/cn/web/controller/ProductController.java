package com.chwl.cn.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chwl.cn.api.OrderClientService;
import com.chwl.cn.entity.order.OrderEntity;
import com.chwl.cn.entity.product.ProductEntity;
import com.chwl.cn.service.product.IProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private OrderClientService orderClientService;
	@Autowired
	private IProductService productService;
	
	@RequestMapping(value = "/getOrder/{id}", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod="fallbackGetId")
	public OrderEntity find(@PathVariable("id") Long id) {
		OrderEntity orderEntity = orderClientService.find(id);
		if(orderEntity==null){
			throw new NullPointerException();
		}
		return orderEntity;
	}
	
	public OrderEntity fallbackGetId(Long id){
		System.out.println("从产品去获取订单异常了");
		return new OrderEntity();
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ProductEntity get(@PathVariable("id") long id) {
		return productService.selectById(id);
	}
	
}
