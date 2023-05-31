package com.example.controllers.admin;

import com.example.models.KhachHangViewModel;
import com.example.services.KhachHangService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("admin/khach-hang")
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private KhachHangViewModel khachHangViewModel;

    @Autowired
    private HttpServletRequest request;

    public static final String redirect = "redirect:/admin/khach-hang/index";

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("list", khachHangService.findAll());
        request.setAttribute("view", "/views/admin/khach-hang/index.jsp");
        return "admin/layout";
    }

    @GetMapping("create")
    public String createGet(Model model) {
        model.addAttribute("khachHang", khachHangViewModel);
        request.setAttribute("view", "/views/admin/khach-hang/create.jsp");
        return "admin/layout";
    }

    @GetMapping("update/{id}")
    public String updateGet(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("khachHang", khachHangService.findById(id));
        request.setAttribute("view", "/views/admin/khach-hang/update.jsp");
        return "admin/layout";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") UUID id) {
        khachHangService.deleteById(id);
        return redirect;
    }

    @PostMapping("create")
    public String createPost(@Valid @ModelAttribute("khachHang") KhachHangViewModel khachHangViewModel, BindingResult result) {
        if (result.hasErrors()) {
            request.setAttribute("view", "/views/admin/khach-hang/create.jsp");
            return "admin/layout";
        } else {
            khachHangService.saveOrUpdate(khachHangViewModel);
            return redirect;
        }
    }

    @PostMapping("update/{id}/{ma}")
    public String updatePost(@Valid @ModelAttribute("khachHang") KhachHangViewModel khachHangViewModel, BindingResult result, @PathVariable("id") UUID id, @PathVariable("ma") String ma) {
        if (result.hasErrors()) {
            request.setAttribute("view", "/views/admin/khach-hang/update.jsp");
            return "admin/layout";
        } else {
            khachHangViewModel.setId(id);
            khachHangViewModel.setMa(ma);
            khachHangService.saveOrUpdate(khachHangViewModel);
            return redirect;
        }
    }

}
