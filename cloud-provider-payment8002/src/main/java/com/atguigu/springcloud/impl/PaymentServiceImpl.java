package com.atguigu.springcloud.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment) {
        return createImpl(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Transactional
    public int createImpl(Payment payment){
        System.out.println("先添加一个用户,名称为" + payment.getSerial());
        paymentDao.create(payment);
        int count = 10/0;
        Payment newPayment = new Payment();
        newPayment.setSerial("新的一个");
        return paymentDao.create(newPayment);
    }


}
