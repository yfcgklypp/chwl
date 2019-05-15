package com.chwl.cn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.chwl.cn.ribbon.CustomRibbon;

@SpringBootApplication
@MapperScan(basePackages="com.chwl.cn.mapper")
@EnableEurekaClient
@EnableCircuitBreaker//开启hystrix服务熔断回调
@EnableCaching//开启本地缓存
@RibbonClient(name="CHWL-PROVIDER-ORDER",configuration=CustomRibbon.class)
@EnableFeignClients//feign声明式API调用(RestTemplate+Ribbon负载均衡)
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
}
