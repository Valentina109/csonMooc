package com.cspiration.mooc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    @RequestMapping("helloworld")
    public String helloworld() {
        return "helloworldOfCSON";
    }
}
