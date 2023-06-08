package com.example.controllers;

import com.example.models.KhachHangViewModel;
import com.example.services.GioHangChiTietService;
import com.example.services.HoaDonChiTietService;
import com.example.services.HoaDonService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping("bill")
public class HoaDonController {
    @Autowired
    private HoaDonChiTietService hoaDonChiTietService;

    @Autowired
    private GioHangChiTietService gioHangChiTietService;

    @Autowired
    private HoaDonService hoaDonService;

    @Autowired
    private HttpSession session;

    @GetMapping("")
    public String index(Model model) {
        KhachHangViewModel khachHang = (KhachHangViewModel) session.getAttribute("khachHang");
        if (khachHang != null) {
            model.addAttribute("index", gioHangChiTietService.index(khachHang.getId()));
            model.addAttribute("nameUser", "Xin chào " + khachHang.getTen());
        } else {
            model.addAttribute("index", 0);
            model.addAttribute("nameUser", "Đăng nhập");
        }
        model.addAttribute("list", hoaDonChiTietService.findByKhachHang(khachHang.getId()));
        model.addAttribute("view", "/views/bill.jsp");
        return "home";
    }

    @GetMapping("detail/{id}")
    public String detail(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("hoaDon", hoaDonChiTietService.getByID(id));
        model.addAttribute("list", hoaDonChiTietService.getListByID(id));
        model.addAttribute("view", "/views/bill-detail.jsp");
        return "home";
    }

    @GetMapping("add/{id}/{soLuong}")
    public String add(@PathVariable("id") UUID id, @PathVariable("soLuong") int soLuong) {
        KhachHangViewModel khachHang = (KhachHangViewModel) session.getAttribute("khachHang");
        hoaDonChiTietService.add(id, soLuong, khachHang);
        return "redirect:/bill";
    }

    @GetMapping("addAll")
    public String addAll() {
        KhachHangViewModel khachHang = (KhachHangViewModel) session.getAttribute("khachHang");
        hoaDonChiTietService.addAll(khachHang);
        return "redirect:/bill";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable("id") UUID id, @RequestParam("trangThai") int trangThai) {
        hoaDonService.update(id, trangThai);
        return "redirect:/bill";
    }

}
