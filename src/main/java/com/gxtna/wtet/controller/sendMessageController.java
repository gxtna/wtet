package com.gxtna.wtet.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sendMsg")
public class sendMessageController {

    @GetMapping("/push")
    public void push() {

    }

}
