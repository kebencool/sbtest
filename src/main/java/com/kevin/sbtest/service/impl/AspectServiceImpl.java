package com.kevin.sbtest.service.impl;

import com.kevin.sbtest.service.AspectService;
import org.springframework.stereotype.Service;

@Service
public class AspectServiceImpl implements AspectService {
    @Override
    public void aspectTest(Boolean exception) {
        System.out.println("service process!");
        if (exception){
            throw new RuntimeException("throw aspectReturnException!");
        }
    }
}
