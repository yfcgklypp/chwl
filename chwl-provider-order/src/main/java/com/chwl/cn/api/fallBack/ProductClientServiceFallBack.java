package com.chwl.cn.api.fallBack;

import org.springframework.stereotype.Component;

import com.chwl.cn.api.ProductClientService;
import com.chwl.cn.entity.product.ProductEntity;

@Component
public class ProductClientServiceFallBack implements ProductClientService{

	@Override
	public ProductEntity find(Long id) {
		return new ProductEntity().setName("产品出错啦");
	}

}
