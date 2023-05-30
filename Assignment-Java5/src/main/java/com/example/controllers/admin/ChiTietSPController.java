package com.example.controllers.admin;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("admin/chi-tiet-sp")
public class ChiTietSPController {

    @Autowired
    private HttpServletRequest request;

    @GetMapping("index")
    public String index(Model model){
        request.setAttribute("view", "/views/admin/chi-tiet-sp/index.jsp");
        return "admin/layout";
    }

    @GetMapping("create")
    public String createGet(Model model){
        request.setAttribute("view", "/views/admin/chi-tiet-sp/create.jsp");
        return "admin/layout";
    }

    @GetMapping("update/{id}")
    public String updateGet(Model model, @PathVariable("id") UUID id){
        request.setAttribute("view", "/views/admin/chi-tiet-sp/update.jsp");
        return "admin/layout";
    }
}
