package com.chwl.cn.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chwl.cn.api.fallBack.ProductClientServiceFallBack;
import com.chwl.cn.entity.product.ProductEntity;

@FeignClient(name="CHWL-PROVIDER-PRODUCT",fallback=ProductClientServiceFallBack.class)
public interface ProductClientService {

	@RequestMapping(value = "/product/get/{id}", method = RequestMethod.GET)
	public ProductEntity find(@PathVariable("id") Long id);
}
