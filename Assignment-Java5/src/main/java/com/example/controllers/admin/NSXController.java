package com.example.controllers.admin;

import com.example.models.NSXViewModel;
import com.example.services.NSXService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("admin/nsx")
public class NSXController {
    @Autowired
    private NSXService nsxService;

    @Autowired
    private NSXViewModel nsxViewModel;

    private static final String redirect = "redirect:/admin/nsx/index";

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("list", nsxService.findAll());
        model.addAttribute("view", "/views/admin/nsx/index.jsp");
        return "admin/layout";
    }

    @GetMapping("create")
    public String createGet(Model model) {
        model.addAttribute("nsx", nsxViewModel);
        model.addAttribute("name", "Add");
        model.addAttribute("action", "/admin/nsx/create");
        model.addAttribute("view", "/views/admin/nsx/create.jsp");
        return "admin/layout";
    }

    @GetMapping("update/{id}")
    public String updateGet(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("nsx", nsxService.findById(id));
        model.addAttribute("name", "Update");
        model.addAttribute("action", "/admin/nsx/update/" + id);
        model.addAttribute("view", "/views/admin/nsx/create.jsp");
        return "admin/layout";
    }

    @GetMapping("delete/{id}")
    public String deleteGet(Model model, @PathVariable("id") UUID id) {
        nsxService.deleteById(id);
        return redirect;
    }

    @PostMapping("create")
    public String createPost(@Valid @ModelAttribute("nsx") NSXViewModel nsxViewModel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("name", "Add");
            model.addAttribute("action", "/admin/nsx/create");
            model.addAttribute("view", "/views/admin/nsx/create.jsp");
            return "admin/layout";
        } else {
            nsxService.saveOrUpdate(nsxViewModel);
            return redirect;
        }
    }

    @PostMapping("update/{id}")
    public String updatePost(@Valid @ModelAttribute("nsx") NSXViewModel nsxViewModel, BindingResult result, @PathVariable("id") UUID id, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("name", "Update");
            model.addAttribute("action", "/admin/nsx/update/" + id);
            model.addAttribute("view", "/views/admin/nsx/create.jsp");
            return "admin/layout";
        } else {
            nsxViewModel.setId(id);
            nsxService.saveOrUpdate(nsxViewModel);
            return redirect;
        }
    }

}
