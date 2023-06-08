package com.example.controllers;

import com.example.infrastructure.request.UserAccountRequest;
import com.example.infrastructure.response.ChiTietSPResponse;
import com.example.models.KhachHangViewModel;
import com.example.services.ChiTietSPService;
import com.example.services.GioHangChiTietService;
import com.example.services.KhachHangService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class HomeController {

    @Autowired
    private ChiTietSPService chiTietSPService;
    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private GioHangChiTietService gioHangChiTietService;

    @Autowired
    private UserAccountRequest userAccountRequest;
    @Autowired
    private HttpSession session;

    @GetMapping("/home")
    public String home(Model model, @RequestParam(defaultValue = "0" ,name = "page") int page) {
        KhachHangViewModel khachHang = (KhachHangViewModel) session.getAttribute("khachHang");
        if (khachHang != null) {
            model.addAttribute("index", gioHangChiTietService.index(khachHang.getId()));
            model.addAttribute("nameUser", "Xin chào " + khachHang.getTen());
        } else {
            model.addAttribute("index", 0);
            model.addAttribute("nameUser", "Đăng nhập");
        }
        Pageable pageable = PageRequest.of(page, 4);
        Page<ChiTietSPResponse> chiTietSPPage = chiTietSPService.findAllHomeByChiTietSP(pageable);
        model.addAttribute("list", chiTietSPPage);
        model.addAttribute("banner", "/views/banner.jsp");
        model.addAttribute("view", "/views/product.jsp");
        return "home";
    }

    @GetMapping("product-detail/{id}")
    public String productDetail(Model model, @PathVariable("id") UUID id) {
        KhachHangViewModel khachHang = (KhachHangViewModel) session.getAttribute("khachHang");
        if (khachHang != null) {
            model.addAttribute("index", gioHangChiTietService.index(khachHang.getId()));
            model.addAttribute("nameUser", "Xin chào " + khachHang.getTen());
        } else {
            model.addAttribute("index", 0);
            model.addAttribute("nameUser", "Đăng nhập");
        }
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
