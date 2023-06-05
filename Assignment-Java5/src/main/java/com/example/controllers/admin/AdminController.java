package com.example.controllers.admin;

import com.example.infrastructure.request.AdminAccountRequest;
import com.example.models.NhanVienViewModel;
import com.example.services.NhanVienService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private AdminAccountRequest adminAccountRequest;

    @Autowired
    private HttpSession session;

    @GetMapping("login")
    public String login(Model model) {
        model.addAttribute("adminAccount", adminAccountRequest);
        return "admin/login";
    }

    @PostMapping("login")
    public String login(@Valid @ModelAttribute("adminAccount") AdminAccountRequest adminAccountRequest, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/login";
        }
        NhanVienViewModel nhanVien = nhanVienService.login(adminAccountRequest);
        if (nhanVien != null) {
            session.setAttribute("nhanVien", nhanVien);
            session.setAttribute("errorMessage", true);
            return "redirect:/admin";
        } else {
            session.setAttribute("errorMessage", false);
            return "redirect:/admin/login";
        }
    }

    @GetMapping("")
    public String index() {
        return "admin/layout";
    }
}
