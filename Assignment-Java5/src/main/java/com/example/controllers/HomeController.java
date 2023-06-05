package com.example.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("home")
    public String home(Model model) {
        model.addAttribute("banner", "/views/banner.jsp");
        model.addAttribute("view", "/views/product.jsp");
        return "home";
    }
}
