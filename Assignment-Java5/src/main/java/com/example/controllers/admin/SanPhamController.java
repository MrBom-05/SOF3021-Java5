package com.example.controllers.admin;

import com.example.infrastructure.request.SanPhamRequest;
import com.example.models.SanPhamViewModel;
import com.example.services.SanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("admin/san-pham")
public class SanPhamController {
    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private SanPhamViewModel sanPhamViewModel;

    private static final String redidect = "redirect:/admin/san-pham/index";

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("list", sanPhamService.findAll());
        model.addAttribute("view", "/views/admin/san-pham/index.jsp");
        return "admin/layout";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("sanPham", sanPhamViewModel);
        model.addAttribute("name", "Add");
        model.addAttribute("action", "/admin/san-pham/create");
        model.addAttribute("view", "/views/admin/san-pham/create.jsp");
        return "admin/layout";
    }

    @GetMapping("update/{id}")
    public String update(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("sanPham", sanPhamService.findById(id));
        model.addAttribute("name", "Update");
        model.addAttribute("action", "/admin/san-pham/update/" + id);
        model.addAttribute("view", "/views/admin/san-pham/create.jsp");
        return "admin/layout";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") UUID id) {
        sanPhamService.deleteById(id);
        return redidect;
    }

    @PostMapping("create")
    public String createPost(@Valid @ModelAttribute("sanPham") SanPhamRequest sanPhamRequest, BindingResult result, Model model, @RequestParam("anh") MultipartFile file) {
        if (result.hasErrors()) {
            model.addAttribute("sanPham", sanPhamViewModel);
            model.addAttribute("name", "Add");
            model.addAttribute("action", "/admin/san-pham/create");
            model.addAttribute("view", "/views/admin/san-pham/create.jsp");
            return "admin/layout";
        } else {
            sanPhamService.saveOrUpdate(sanPhamRequest, file);
            return redidect;
        }
    }

    @PostMapping("update/{id}")
    public String updatePost(@Valid @ModelAttribute("sanPham") SanPhamRequest sanPhamRequest, BindingResult result, Model model, @PathVariable("id") UUID id, @RequestParam("anh") MultipartFile file) {
        if (result.hasErrors()) {
            model.addAttribute("sanPham", sanPhamService.findById(id));
            model.addAttribute("name", "Update");
            model.addAttribute("action", "/admin/san-pham/update/" + id);
            model.addAttribute("view", "/views/admin/san-pham/create.jsp");
            return "admin/layout";
        } else {
            sanPhamService.saveOrUpdate(sanPhamRequest, file);
            return redidect;
        }
    }
}
