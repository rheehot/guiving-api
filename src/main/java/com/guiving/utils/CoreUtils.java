package com.guiving.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CoreUtils {

    public static String getRandomStr(){
        return UUID.randomUUID().toString().replaceAll("-","").substring(0,3);
    }
}
