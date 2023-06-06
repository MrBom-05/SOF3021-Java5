package com.example.controllers;

import com.example.models.KhachHangViewModel;
import com.example.services.GioHangChiTietService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cart")
public class CartController {
    @Autowired
    private GioHangChiTietService gioHangChiTietService;

    @Autowired
    private HttpSession session;

    @GetMapping("")
    public String index(Model model) {
        KhachHangViewModel khachHang = (KhachHangViewModel) session.getAttribute("khachHang");
        model.addAttribute("list", gioHangChiTietService.findGiaHangByKhachHang(khachHang.getId()));
        model.addAttribute("view", "/views/cart.jsp");
        return "home";
    }
}
