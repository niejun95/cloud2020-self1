package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
	/**
	 * 正常访问，肯定ok
	 * @param id
	 * @return
	 */
	public String paymentInfo_OK(Integer id) {
		return "线程池： "+Thread.currentThread().getName() + " paymentInfo_OK,id: " + id +"\t";
	}

	@HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
		@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value="5000")
	})
	public String paymentInfo_TimeOut(Integer id) {
		int timeNumber = 3000;
		try {
			TimeUnit.MILLISECONDS.sleep(timeNumber);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "线程池： "+Thread.currentThread().getName() + " paymentInfo_OK,id: " + id +"\t" + " 耗时" + timeNumber +"钟";
	}

	public String paymentInfo_TimeoutHandler(Integer id) {
		return "线程池： "+Thread.currentThread().getName() + " paymentInfo_TimeoutHandler,id: " + id +"\t" + " 耗时" + "┭┮﹏┭┮";
	}
}
