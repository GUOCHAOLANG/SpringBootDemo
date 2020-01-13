package com.gcl.example.domebaseweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OneController {

    @RequestMapping("/one")
    public String one(){
        //localhost:8080/one
        return "ok";
    }
}
