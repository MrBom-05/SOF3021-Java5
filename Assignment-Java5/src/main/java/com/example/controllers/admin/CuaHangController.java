package com.example.controllers.admin;

import com.example.models.CuaHangViewModel;
import com.example.services.CuaHangService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("admin/cua-hang")
public class CuaHangController {
    @Autowired
    private CuaHangService cuaHangService;
    @Autowired
    private CuaHangViewModel cuaHangViewModel;

    private static final String redirect = "redirect:/admin/cua-hang/index";

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("list", cuaHangService.findAll());
        model.addAttribute("view", "/views/admin/cua-hang/index.jsp");
        return "admin/layout";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("cuaHang", cuaHangViewModel);
        model.addAttribute("name", "Add");
        model.addAttribute("action", "/admin/cua-hang/create");
        model.addAttribute("view", "/views/admin/cua-hang/create.jsp");
        return "admin/layout";
    }

    @GetMapping("update/{id}")
    public String updateGet(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("cuaHang", cuaHangService.findById(id));
        model.addAttribute("name", "Update");
        model.addAttribute("action", "/admin/mau-sac/update/" + id);
        model.addAttribute("view", "/views/admin/cua-hang/create.jsp");
        return "admin/layout";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") UUID id) {
        cuaHangService.deleteById(id);
        return redirect;
    }

    @PostMapping("create")
    public String createPost(@Valid @ModelAttribute("cuaHang") CuaHangViewModel cuaHang, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("name", "Add");
            model.addAttribute("action", "/admin/cua-hang/create");
            model.addAttribute("view", "/views/admin/cua-hang/create.jsp");
            return "admin/layout";
        } else {
            cuaHangService.saveOrUpdate(cuaHang);
            return redirect;
        }
    }

    @PostMapping("update/{id}")
    public String updatePost(@Valid @ModelAttribute("cuaHang") CuaHangViewModel cuaHang, BindingResult result, @PathVariable("id") UUID id, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("name", "Update");
            model.addAttribute("action", "/admin/mau-sac/update/" + id);
            model.addAttribute("view", "/views/admin/cua-hang/create.jsp");
            return "admin/layout";
        } else {
            cuaHang.setId(id);
            cuaHangService.saveOrUpdate(cuaHang);
            return redirect;
        }
    }
}
