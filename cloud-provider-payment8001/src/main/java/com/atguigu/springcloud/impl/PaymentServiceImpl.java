package com.atguigu.springcloud.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Transactional(rollbackFor = Exception.class)
    public int create(Payment payment) {
        return createImpl(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Transactional(rollbackFor = ArithmeticException.class)
    public int createImpl(Payment payment){
        System.out.println("当前处理类为PaymentServiceImpl");
        System.out.println("先添加一个用户,名称为" + payment.getSerial());
        paymentDao.create(payment);
        try{
            int count = 10/0;
        } catch(Exception e){
            throw e;
        }
        Payment newPayment = new Payment();
        newPayment.setSerial("新的一个");
        return paymentDao.create(newPayment);
    }


}
