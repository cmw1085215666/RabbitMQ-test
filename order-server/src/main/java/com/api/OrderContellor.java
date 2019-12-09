package com.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderContellor {

    @RequestMapping(value = "/testApi")
    public String testApi(){
        return "holler word";
    }


}
