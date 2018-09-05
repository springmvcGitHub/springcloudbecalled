package com.example.test.controller;

import com.example.test.feignInterface.FeignInterface;
import org.springframework.stereotype.Component;

/**
 * @Author: 东星耀阳
 * @Description:
 * @Date: 2018-08-30
 */
@Component
public class FeignFailure implements FeignInterface {
    @Override
    public String getStr(String code) {
        return "我断路了~~~~~"+code;
    }
}
