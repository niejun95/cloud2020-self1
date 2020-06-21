package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class PaymentFallbackService implements PaymentHystrixService{

	@GetMapping("/payment/hystrix/ok/{id}")
	public String paymentInfo_OK (@PathVariable("id") Integer id) {
		return "-----paymentFallbackService fall back-paymentInfo_OK";
	}

	@GetMapping("/payment/hystrix/timeout/{id}")
	public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
		return "-----paymentFallbackService fall back-paymentInfo_TimeOut";
	}


}
