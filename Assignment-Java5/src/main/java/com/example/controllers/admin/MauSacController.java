package com.example.controllers.admin;

import com.example.models.MauSacViewModel;
import com.example.services.MauSacService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("admin/mau-sac")
public class MauSacController {
    @Autowired
    private MauSacService mauSacService;

    @Autowired
    private MauSacViewModel mauSacViewModel;

    @Autowired
    private HttpSession session;

    private static final String redirect = "redirect:/admin/mau-sac/index";

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("list", mauSacService.findAll());
        model.addAttribute("view", "/views/admin/mau-sac/index.jsp");
        return "admin/layout";
    }

    @GetMapping("create")
    public String createGet(Model model) {
        model.addAttribute("mauSac", mauSacViewModel);
        model.addAttribute("name", "Add");
        model.addAttribute("action", "/admin/mau-sac/create");
        model.addAttribute("view", "/views/admin/mau-sac/create.jsp");
        return "admin/layout";
    }

    @GetMapping("update/{id}")
    public String updateGet(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("mauSac", mauSacService.findById(id));
        model.addAttribute("name", "Update");
        model.addAttribute("action", "/admin/mau-sac/update/" + id);
        model.addAttribute("view", "/views/admin/mau-sac/create.jsp");
        return "admin/layout";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") UUID id) {
        try {
            mauSacService.deleteById(id);

        } catch (DataIntegrityViolationException e) {
            session.setAttribute("thongBao", "Không thể xóa sản phẩm do có bản ghi liên quan");
        }
        return redirect;
    }

    @PostMapping("create")
    public String createPost(@Valid @ModelAttribute("mauSac") MauSacViewModel mauSacViewModel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("name", "Add");
            model.addAttribute("action", "/admin/mau-sac/create");
            model.addAttribute("view", "/views/admin/mau-sac/create.jsp");
            return "admin/layout";
        } else {
            mauSacService.saveOrUpdate(mauSacViewModel);
            model.addAttribute("thongBao", "Thêm Thành Công");
            return redirect;
        }

    }

    @PostMapping("update/{id}")
    public String updatePost(@Valid @ModelAttribute("mauSac") MauSacViewModel mauSacViewModel, BindingResult result, @PathVariable("id") UUID id, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("name", "Update");
            model.addAttribute("action", "/admin/mau-sac/update/" + id);
            model.addAttribute("view", "/views/admin/mau-sac/create.jsp");
            return "admin/layout";
        } else {
            mauSacViewModel.setId(id);
            mauSacService.saveOrUpdate(mauSacViewModel);
            return redirect;
        }
    }

}
