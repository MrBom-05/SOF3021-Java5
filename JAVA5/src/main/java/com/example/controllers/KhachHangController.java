package com.example.controllers;

import com.example.entities.KhachHang;
import com.example.repository.KhachHangRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("khach-hang")
public class KhachHangController {

    @Autowired
    private KhachHang khachHang;

    private KhachHangRepository khachHangRepository = new KhachHangRepository();

    @GetMapping("index")
    public String index(Model model){
        model.addAttribute("list", khachHangRepository.findAll());
        return "khach-hang/index";
    }

    @GetMapping("create")
    public String createGet(Model model){
        model.addAttribute("khachHang", khachHang);
        return "khach-hang/create";
    }

    @GetMapping("update")
    public String updateGet(Model model, @RequestParam("ma") String ma){
        model.addAttribute("khachHang", khachHangRepository.findByMa(ma));
        return "khach-hang/edit";
    }

    @GetMapping("delete")
    public String delete(@RequestParam("ma") String ma){
        khachHangRepository.delete(ma);
        return "redirect:/khach-hang/index";
    }

    @PostMapping("create")
    public String createPost(@Valid @ModelAttribute("khachHang") KhachHang khachHang, BindingResult result){
        if (result.hasErrors()){
            return "khach-hang/create";
        } else {
            khachHangRepository.insert(khachHang);
            return "redirect:/khach-hang/index";
        }
    }

    @PostMapping("update")
    public String updatePost(@Valid @ModelAttribute("khachHang") KhachHang khachHang, BindingResult result){
        if (result.hasErrors()){
            return "khach-hang/edit";
        } else {
            khachHangRepository.update(khachHang);
            return "redirect:/khach-hang/index";
        }
    }


}
