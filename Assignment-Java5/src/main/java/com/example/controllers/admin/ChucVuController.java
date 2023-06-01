package com.example.controllers.admin;

import com.example.models.ChucVuViewModel;
import com.example.services.ChucVuService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("admin/chuc-vu")
public class ChucVuController {

    @Autowired
    private ChucVuService chucVuService;

    @Autowired
    private ChucVuViewModel chucVuViewModel;

    @Autowired
    private HttpServletRequest request;

    private static final String redirect = "redirect:/admin/chuc-vu/index";


    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("list", chucVuService.findAll());
        request.setAttribute("view", "/views/admin/chuc-vu/index.jsp");
        return "admin/layout";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("chucVu", chucVuViewModel);
        model.addAttribute("name", "Add");
        model.addAttribute("action", "/admin/chuc-vu/create");
        request.setAttribute("view", "/views/admin/chuc-vu/create.jsp");
        return "admin/layout";
    }

    @GetMapping("update/{id}")
    public String updateGet(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("chucVu", chucVuService.findById(id));
        model.addAttribute("name", "Update");
        model.addAttribute("action", "/admin/chuc-vu/update/" + id);
        request.setAttribute("view", "/views/admin/chuc-vu/create.jsp");
        return "admin/layout";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") UUID id) {
        chucVuService.deleteById(id);
        return redirect;
    }

    @PostMapping("create")
    public String createPost(@Valid @ModelAttribute("chucVu") ChucVuViewModel chucVu, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("name", "Add");
            model.addAttribute("action", "/admin/chuc-vu/create");
            request.setAttribute("view", "/views/admin/chuc-vu/create.jsp");
            return "admin/layout";
        } else {
            chucVuService.saveOrUpdate(chucVu);
            return redirect;
        }
    }

    @PostMapping("update/{id}")
    public String updatePost(@Valid @ModelAttribute("chucVu") ChucVuViewModel chucVu, BindingResult result, @PathVariable("id") UUID id, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("name", "Update");
            model.addAttribute("action", "/admin/chuc-vu/update/" + id);
            request.setAttribute("view", "/views/admin/chuc-vu/create.jsp");
            return "admin/layout";
        } else {
            chucVu.setId(id);
            chucVuService.saveOrUpdate(chucVu);
            return redirect;
        }
    }
}
