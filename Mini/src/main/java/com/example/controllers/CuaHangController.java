package com.example.controllers;

import com.example.entities.CuaHang;
import com.example.services.CuaHangService;
import com.example.services.implement.CuaHangServiceImplement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("cua-hang")
public class CuaHangController {

    @Autowired
    private CuaHangService cuaHangService = new CuaHangServiceImplement();

    @Autowired
    private HttpServletRequest request;

    private static final String redirect = "redirect:/cua-hang/index";
//    private static final String forward = "forward:/cua-hang/index";

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("list", cuaHangService.findAll());
        request.setAttribute("view", "/views/admin/cua-hang/index.jsp");
        return "admin/layout";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("cuaHang", new CuaHang(null, "PH", "", "", "", "Việt Nam"));
        request.setAttribute("view", "/views/admin/cua-hang/create.jsp");
        return "admin/layout";
    }

    @GetMapping("update")
    public String edit(Model model, @RequestParam("id") UUID id) {
        model.addAttribute("cuaHang", cuaHangService.findById(id));
        request.setAttribute("view", "/views/admin/cua-hang/create.jsp");
        return "admin/layout";
    }

    @GetMapping("delete")
    public String delete(@RequestParam("id") UUID id) {
        cuaHangService.deleteById(id);
        return redirect;
    }

    @PostMapping("create")
    public String store(@Valid @ModelAttribute("cuaHang") CuaHang cuaHang, BindingResult result) {
        if (result.hasErrors()) {
            request.setAttribute("view", "/views/admin/cua-hang/create.jsp");
            return "admin/layout";
        } else {
            cuaHangService.saveOrUpdate(cuaHang);
            return redirect;
        }
    }

    @PostMapping("update")
    public String update( @Valid @ModelAttribute("cuaHang") CuaHang cuaHang, BindingResult result) {
        if (result.hasErrors()) {
            request.setAttribute("view", "/views/admin/cua-hang/edit.jsp");
            return "admin/layout";
        } else {
            cuaHangService.saveOrUpdate(cuaHang);
            return redirect;
        }
    }
}
