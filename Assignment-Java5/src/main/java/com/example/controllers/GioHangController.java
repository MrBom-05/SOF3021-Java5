package com.example.controllers;

import com.example.models.KhachHangViewModel;
import com.example.services.GioHangChiTietService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("cart")
public class GioHangController {
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

    @PostMapping("add/{id}")
    public String add(@PathVariable("id") UUID id, @RequestParam("soLuong") int soLuong) {
        KhachHangViewModel khachHang = (KhachHangViewModel) session.getAttribute("khachHang");
        gioHangChiTietService.add(id, soLuong, khachHang);
        return "redirect:/cart";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") UUID id) {
        KhachHangViewModel khachHang = (KhachHangViewModel) session.getAttribute("khachHang");
        gioHangChiTietService.delete(id, khachHang);
        return "redirect:/cart";
    }
}
