package com.example.controllers;

import com.example.request.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("login")
    public String getLoginForm(){
        return "login";
    }

    @PostMapping("login")
    public String login(Account account){
        System.out.println(account.getEmail());
        System.out.println(account.getPassword());
        System.out.println(account.isRemenber());
        return "login";
    }
}
