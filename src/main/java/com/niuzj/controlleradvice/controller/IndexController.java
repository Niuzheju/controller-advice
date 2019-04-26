package com.niuzj.controlleradvice.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author niuzj
 * @date 2019/4/26 14:48
 */
@RestController
public class IndexController {

    @RequestMapping("/getResult")
    public int getResult(){
        return 10 / 0;
    }

    @RequestMapping("/getResult1")
    public int getResult1(){
        int[] arr = new int[1];
        arr[1] = 2;
        return 2;
    }

    @GetMapping("/param")
    public String param(Model model){
        return (String) model.asMap().get("param");
    }
}
