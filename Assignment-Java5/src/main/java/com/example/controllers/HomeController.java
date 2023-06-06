package com.example.controllers;

import com.example.infrastructure.request.UserAccountRequest;
import com.example.models.KhachHangViewModel;
import com.example.services.ChiTietSPService;
import com.example.services.KhachHangService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class HomeController {

    @Autowired
    private ChiTietSPService chiTietSPService;
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private UserAccountRequest userAccountRequest;
    @Autowired
    private HttpSession session;

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
        model.addAttribute("userAccount", userAccountRequest);
        return "sign-in";
    }

    @PostMapping("sign-in")
    public String signIn(@Valid @ModelAttribute("userAccount") UserAccountRequest userAccountRequest, BindingResult result) {
        if (result.hasErrors()) {
            return "sign-in";
        }
        KhachHangViewModel khachHangViewModel = khachHangService.login(userAccountRequest);
        if (khachHangViewModel != null) {
            session.setAttribute("khachHang", khachHangViewModel);
            session.setAttribute("errorMessage", true);
            return "redirect:/home";
        } else {
            session.setAttribute("errorMessage", false);
            return "redirect:/sign-in";
        }
    }

    @GetMapping("sign-up")
    public String signUp(Model model) {
        return "sign-up";
    }
}
