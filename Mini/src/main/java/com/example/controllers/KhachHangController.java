package com.example.controllers;

import com.example.entities.KhachHang;
import com.example.services.KhachHangService;
import com.example.services.implement.KhachHangServiceImplement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("khach-hang")
public class KhachHangController {

    @Autowired
    private KhachHangService khachHangService = new KhachHangServiceImplement();

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private KhachHang khachHang;

    private static final String redirect = "redirect:/khach-hang/index";

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("list", khachHangService.findAll());
        request.setAttribute("view", "/views/admin/khach-hang/index.jsp");
        return "admin/layout";
    }

    @GetMapping("create")
    public String createGet(Model model) {
        model.addAttribute("khachHang", khachHang);
        request.setAttribute("view", "/views/admin/khach-hang/create.jsp");
        return "admin/layout";
    }

    @GetMapping("update")
    public String updateGet(Model model, @RequestParam("id") UUID id) {
        model.addAttribute("khachHang", khachHangService.findById(id));
        request.setAttribute("view", "/views/admin/khach-hang/edit.jsp");
        return "admin/layout";
    }

    @GetMapping("delete")
    public String delete(@RequestParam("id") UUID id) {
        khachHangService.delete(id);
        return redirect;
    }

    @PostMapping("create")
    public String creatPost(@Valid @ModelAttribute("khachHang") KhachHang khachHang, BindingResult result) {
        if (result.hasErrors()) {
            request.setAttribute("view", "/views/admin/khach-hang/create.jsp");
            return "admin/layout";
        } else {
            khachHangService.save(khachHang);
            return redirect;
        }
    }

    @PostMapping("update")
    public String updatePost(@RequestParam("id") UUID id, @Valid @ModelAttribute("khachHang") KhachHang khachHang, BindingResult result) {
        if (result.hasErrors()) {
            request.setAttribute("view", "/views/admin/khach-hang/update.jsp");
            return "admin/layout";
        } else {
            khachHangService.update(khachHang, id);
            return redirect;
        }
    }


}
