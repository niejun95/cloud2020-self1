package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashDoardMain9001 {
	public static void main(String[] args) {
		SpringApplication.run(HystrixDashDoardMain9001.class, args);
	}
}
