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
        if (account.getEmail().equals("herogamings969@gmail.com") || account.getPassword().equals("123@123a")){
            return "redirect:/cua-hang/index";
        }
        return "login";
    }
}
