package com.chwl.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableEurekaServer // 告诉springcloud我是EurekaServer端,接受其他服务可以进来
public class EurekaServerApplication2001 {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication2001.class, args);
	}
	
	@EnableWebSecurity
	static class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
//	        // Spring Security 默认开启了所有 CSRF 攻击防御，需要禁用 /eureka 的防御
	    	http.csrf().ignoringAntMatchers("/eureka/**");//放行向注册中心进行注册服务的请求
	    	//访问eureka控制台和/actuator时能做安全控制
//	    	http.csrf().disable();//禁用CSRF
	        super.configure(http);
//            http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	    }
	}
}
