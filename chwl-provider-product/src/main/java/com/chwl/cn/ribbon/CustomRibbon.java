package com.chwl.cn.ribbon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.chwl.cn.ribbon.config.CustomRoundRobinRule;
import com.netflix.loadbalancer.IRule;

@Configuration
public class CustomRibbon {

	@Bean
	public IRule rule(){
		return new CustomRoundRobinRule();
	}
}
