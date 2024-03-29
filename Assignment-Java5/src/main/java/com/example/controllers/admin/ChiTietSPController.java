package com.example.controllers.admin;

import com.example.models.ChiTietSPViewModel;
import com.example.services.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
    private HttpSession session;


    private static final String redirect = "redirect:/admin/chi-tiet-sp/index";

    @GetMapping("index")
    public String index(Model model) {
        session.setAttribute("thongBao", "");
        model.addAttribute("list", chiTietSPService.findAll());
        model.addAttribute("view", "/views/admin/chi-tiet-sp/index.jsp");
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
        model.addAttribute("view", "/views/admin/chi-tiet-sp/create.jsp");
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
        model.addAttribute("view", "/views/admin/chi-tiet-sp/create.jsp");
        return "admin/layout";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") UUID id) {
        try {
            chiTietSPService.deleteById(id);

        } catch (DataIntegrityViolationException e) {
            session.setAttribute("thongBao", "Không thể xóa sản phẩm do có bản ghi liên quan");
        }
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
            model.addAttribute("view", "/views/admin/chi-tiet-sp/create.jsp");
            return "admin/layout";
        } else {
            session.setAttribute("thongBao", "Add success");
            chiTietSPService.saveOrUpdate(chiTietSPViewModel);
            return redirect;
        }
    }

    @PostMapping("update/{id}")
    public String updatePost(@Valid @ModelAttribute("chiTietSP") ChiTietSPViewModel chiTietSPViewModel, BindingResult result, Model model, @PathVariable("id") UUID id) {
        if (result.hasErrors()) {
            model.addAttribute("name", "Update");
            model.addAttribute("action", "/admin/chi-tiet-sp/update/" + id);
            model.addAttribute("view", "/views/admin/chi-tiet-sp/create.jsp");
            return "admin/layout";
        } else {
            session.setAttribute("thongBao", "Update success");
            chiTietSPService.saveOrUpdate(chiTietSPViewModel);
            return redirect;
        }
    }
}
