package com.atguigu.springcloud.impl;

import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImplSec extends PaymentServiceImpl{

//    @Transactional(rollbackFor = Exception.class)
    public int create(Payment payment) {
        System.out.println("当前处理类为PaymentServiceImplSec");
        int x = 0;
        try{
             x = createImpl(payment);
        }catch (Exception e){
            throw  e;
        }
        return x;
    }

}
