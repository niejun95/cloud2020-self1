package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
	//将id重新注入到uri中 去eureka中找CLOUD-PAYMENT-SERVICE接口 调用/payment/get/{id}uri对应的方法
	@GetMapping(value = "/payment/get/{id}")
	CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

	@GetMapping(value = "/payment/feign/timeout")
	String paymentFeignTimeOut();
}
