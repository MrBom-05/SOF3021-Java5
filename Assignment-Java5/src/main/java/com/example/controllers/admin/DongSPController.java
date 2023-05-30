package com.example.controllers.admin;

import com.example.models.DongSPViewModel;
import com.example.services.DongSPService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("admin/dong-sp")
public class DongSPController {
    @Autowired
    private DongSPService dongSPService;
    @Autowired
    private DongSPViewModel dongSPViewModel;
    @Autowired
    private HttpServletRequest request;

    private static final String redirect = "redirect:/admin/dong-sp/index";

    @GetMapping("index")
    public String index(Model model){
        model.addAttribute("list", dongSPService.findAll());
        request.setAttribute("view", "/views/admin/dong-sp/index.jsp");
        return "admin/layout";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("dongSP", dongSPViewModel);
        request.setAttribute("view", "/views/admin/dong-sp/create.jsp");
        return "admin/layout";
    }

    @GetMapping("update/{id}")
    public String updateGet(Model model, @PathVariable("id") UUID id){
        model.addAttribute("dongSP", dongSPService.findById(id));
        request.setAttribute("view", "/views/admin/dong-sp/update.jsp");
        return "admin/layout";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") UUID id){
        dongSPService.deleteById(id);
        return redirect;
    }

    @PostMapping("create")
    public String createPost(@Valid @ModelAttribute("dongSP") DongSPViewModel dongSP, BindingResult result){
        if(result.hasErrors()){
            request.setAttribute("view", "/views/admin/dong-sp/create.jsp");
            return "admin/layout";
        }else{
            dongSPService.saveOrUpdate(dongSP);
            return redirect;
        }
    }

    @PostMapping("update/{id}")
    public String updatePost(@Valid @ModelAttribute("dongSP") DongSPViewModel dongSP, BindingResult result, @PathVariable("id") UUID id){
        if(result.hasErrors()){
            request.setAttribute("view", "/views/admin/dong-sp/update.jsp");
            return "admin/layout";
        }else{
            dongSP.setId(id);
            dongSPService.saveOrUpdate(dongSP);
            return redirect;
        }
    }
}
