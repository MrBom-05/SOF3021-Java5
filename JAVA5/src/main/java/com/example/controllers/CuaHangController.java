package com.example.controllers;

import com.example.entities.CuaHang;
import com.example.repository.CuaHangRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("cua-hang")
public class CuaHangController {

    private CuaHangRepository cuaHangRepository = new CuaHangRepository();

    private static final String redirect = "redirect:/cua-hang/index";
//    private static final String forward = "forward:/cua-hang/index";

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("list", cuaHangRepository.findAll());
        return "cua-hang/index";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("cuaHang", new CuaHang(null, "PH", "", "", "", "Việt Nam"));
        return "cua-hang/create";
    }

    @GetMapping("update")
    public String edit(Model model, @RequestParam("ma") String ma) {
        model.addAttribute("cuaHang", cuaHangRepository.findByMa(ma));
        return "cua-hang/edit";
    }

    @GetMapping("delete")
    public String delete(@RequestParam("ma") String ma) {
        cuaHangRepository.delete(cuaHangRepository.findByMa(ma));
        return redirect;
    }

    @PostMapping("create")
    public String store(@Valid @ModelAttribute("cuaHang") CuaHang cuaHang, BindingResult result) {
        if (result.hasErrors()) {
            return "cua-hang/create";
        } else {
            cuaHangRepository.insert(cuaHang);
            return redirect;
        }
    }

    @PostMapping("update")
    public String update( @Valid @ModelAttribute("cuaHang") CuaHang cuaHang, BindingResult result) {
        if (result.hasErrors()) {
            return "cua-hang/edit";
        } else {
            cuaHangRepository.update(cuaHang);
            return redirect;
        }
    }
}
