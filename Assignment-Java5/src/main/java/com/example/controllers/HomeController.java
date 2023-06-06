package com.example.controllers;

import com.example.services.ChiTietSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Controller
public class HomeController {

    @Autowired
    private ChiTietSPService chiTietSPService;

    @GetMapping("home")
    public String home(Model model) {
        model.addAttribute("list", chiTietSPService.findAllHomeByChiTietSP());
        model.addAttribute("banner", "/views/banner.jsp");
        model.addAttribute("view", "/views/product.jsp");
        return "home";
    }

    @GetMapping("product-detail/{id}")
    public String productDetail(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("chiTietSP", chiTietSPService.findBySanPhamResponse(id));
        model.addAttribute("view", "/views/product-detail.jsp");
        return "home";
    }

    @GetMapping("sign-in")
    public String signIn(Model model) {
        return "sign-in";
    }

    @GetMapping("sign-up")
    public String signUp(Model model) {
        return "sign-up";
    }
}
