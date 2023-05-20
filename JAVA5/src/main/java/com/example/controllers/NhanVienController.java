package com.example.controllers;

import com.example.entities.NhanVien;
import com.example.repository.NhanVienRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("nhan-vien")
public class NhanVienController {

    private NhanVienRepository nhanVienRepository = new NhanVienRepository();

    private static final String redirect = "redirect:/nhan-vien/index";

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("list", nhanVienRepository.findAll());
        return "nhan-vien/index";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("nhanVien", new NhanVien());
        return "nhan-vien/create";
    }

    @GetMapping("update")
    public String edit(Model model, @RequestParam("ma") String ma) {
        model.addAttribute("nhanVien", nhanVienRepository.findByMa(ma));
        return "nhan-vien/edit";
    }

    @GetMapping("delete")
    public String delete(@RequestParam("ma") String ma) {
        nhanVienRepository.delete(nhanVienRepository.findByMa(ma));
        return redirect;
    }

    @PostMapping("create")
    public String store(@Valid @ModelAttribute("nhanVien") NhanVien nhanVien, BindingResult result) {
        if (result.hasErrors()) {
            return "nhan-vien/create";
        } else {
            nhanVienRepository.insert(nhanVien);
            return redirect;
        }
    }

    @PostMapping("update")
    public String update(@Valid @ModelAttribute("nhanVien") NhanVien nhanVien, BindingResult result) {
        if (result.hasErrors()) {
            return "nhan-vien/update";
        } else {
            nhanVienRepository.update(nhanVien);
            return redirect;
        }
    }
}
