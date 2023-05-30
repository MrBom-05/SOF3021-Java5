package com.example.controllers.admin;

import com.example.entities.ChiTietSP;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin/chi-tiet-sp")
public class ChiTietSPController {

    @Autowired
    private HttpServletRequest request;

    @GetMapping("index")
    public String index(Model model){
//        model.addAttribute("list", );
        request.setAttribute("view", "/views/admin/chi-tiet-sp/index.jsp");
        return "admin/layout";
    }
}
