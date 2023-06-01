package com.example.controllers.admin;

import com.example.models.ChiTietSPViewModel;
import com.example.services.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("admin/chi-tiet-sp")
public class ChiTietSPController {

    @Autowired
    private ChiTietSPService chiTietSPService;

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private MauSacService mauSacService;

    @Autowired
    private DongSPService dongSPService;

    @Autowired
    private NSXService nSXService;

    @Autowired
    private ChiTietSPViewModel chiTietSPViewModel;

    @Autowired
    private HttpServletRequest request;

    private static final String redirect = "redirect:/admin/chi-tiet-sp/index";

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("list", chiTietSPService.findAll());
        request.setAttribute("view", "/views/admin/chi-tiet-sp/index.jsp");
        return "admin/layout";
    }

    @GetMapping("create")
    public String createGet(Model model) {
        model.addAttribute("chiTietSP", chiTietSPViewModel);
        model.addAttribute("listSanPham", sanPhamService.findAll());
        model.addAttribute("listMauSac", mauSacService.findAll());
        model.addAttribute("listDongSP", dongSPService.findAll());
        model.addAttribute("listNSX", nSXService.findAll());
        model.addAttribute("name", "Add");
        model.addAttribute("action", "/admin/chi-tiet-sp/create");
        request.setAttribute("view", "/views/admin/chi-tiet-sp/create.jsp");
        return "admin/layout";
    }

    @GetMapping("update/{id}")
    public String updateGet(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("chiTietSP", chiTietSPService.findById(id));
        model.addAttribute("listSanPham", sanPhamService.findAll());
        model.addAttribute("listMauSac", mauSacService.findAll());
        model.addAttribute("listDongSP", dongSPService.findAll());
        model.addAttribute("listNSX", nSXService.findAll());
        model.addAttribute("name", "Update");
        model.addAttribute("action", "/admin/chi-tiet-sp/update/" + id);
        request.setAttribute("view", "/views/admin/chi-tiet-sp/create.jsp");
        return "admin/layout";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") UUID id) {
        chiTietSPService.deleteById(id);
        return redirect;
    }

    @PostMapping("create")
    public String createPost(@Valid @ModelAttribute("chiTietSP") ChiTietSPViewModel chiTietSPViewModel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listSanPham", sanPhamService.findAll());
            model.addAttribute("listMauSac", mauSacService.findAll());
            model.addAttribute("listDongSP", dongSPService.findAll());
            model.addAttribute("listNSX", nSXService.findAll());
            model.addAttribute("name", "Add");
            model.addAttribute("action", "/admin/chi-tiet-sp/create");
            request.setAttribute("view", "/views/admin/chi-tiet-sp/create.jsp");
            return "admin/layout";
        } else {
            chiTietSPService.saveOrUpdate(chiTietSPViewModel);
            return redirect;
        }
    }

    @PostMapping("update/{id}")
    public String updatePost(@Valid @ModelAttribute("chiTietSP") ChiTietSPViewModel chiTietSPViewModel, BindingResult result, Model model, @PathVariable("id") UUID id) {
        if (result.hasErrors()) {
            model.addAttribute("name", "Update");
            model.addAttribute("action", "/admin/chi-tiet-sp/update/" + id);
            request.setAttribute("view", "/views/admin/chi-tiet-sp/create.jsp");
            return "admin/layout";
        } else {
            chiTietSPService.saveOrUpdate(chiTietSPViewModel);
            return redirect;
        }
    }
}
