package com.example.controllers;

import com.example.entities.KhachHang;
import com.example.repositories.HangKhachHangRepository;
import com.example.repositories.KhachHangRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("khach-hang")
public class KhachHangController {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Autowired
    private HangKhachHangRepository hangKhachHangRepository;

    @Autowired
    private HttpSession session;

    @Autowired
    private KhachHang khachHang;

    @GetMapping("hien-thi")
    public String hienThi(Model model, @RequestParam(defaultValue = "0", name = "page") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        model.addAttribute("list", khachHangRepository.findAll(pageable));
        model.addAttribute("listHangKhachHang", hangKhachHangRepository.findAll());
        model.addAttribute("khachHang", khachHang);
        return "hien-thi";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        khachHangRepository.deleteById(id);
        session.setAttribute("thongBao", "Xóa thành công!");
        return "redirect:/khach-hang/hien-thi";
    }

    @PostMapping("add")
    public String add(@Valid @ModelAttribute("khachHang") KhachHang khachHang, BindingResult result, Model model, @RequestParam(defaultValue = "0", name = "page") int page) {
        if (result.hasErrors()) {
            Pageable pageable = PageRequest.of(page, 5);
            model.addAttribute("list", khachHangRepository.findAll(pageable));
            model.addAttribute("listHangKhachHang", hangKhachHangRepository.findAll());
            return "hien-thi";
        }
        khachHangRepository.save(khachHang);
        session.setAttribute("thongBao", "Thêm thành công!");
        return "redirect:/khach-hang/hien-thi";
    }

    @PostMapping("search")
    public String search(@RequestParam("search") String search, @RequestParam("maHang") Integer maHang, Model model, @RequestParam(defaultValue = "0", name = "page") int page) {
        Pageable pageable = PageRequest.of(page, 5);
//        model.addAttribute("list", khachHangRepository.findByTenContaining(search, pageable));
        model.addAttribute("listHangKhachHang", hangKhachHangRepository.findAll());
        model.addAttribute("khachHang", khachHang);
        return "hien-thi";
    }
}
