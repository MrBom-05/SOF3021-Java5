package com.example.controllers;

import com.example.model.CuaHang;
import com.example.repository.CuaHangRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cua-hang")
public class CuaHangController {

    private CuaHangRepository cuaHangRepository = new CuaHangRepository();
    

    @GetMapping("index")
    public String index(Model model){
        model.addAttribute("list", cuaHangRepository.findAll());
        return "cua-hang/index";
    }

    @GetMapping("create")
    public String create(){

        return "cua-hang/create";
    }

    @GetMapping("edit/{ma}")
    public String edit(Model model, CuaHang cuaHang){
        model.addAttribute("cuaHang", cuaHangRepository.findByMa(cuaHang.getMa()));
        return "cua-hang/edit";
    }

    @GetMapping("delete/{ma}")
    public String delete(CuaHang cuaHang){
        cuaHangRepository.delete(cuaHang);
        return "redirect:/cua-hang/index";
    }

    @PostMapping("store")
    public String store(CuaHang cuaHang){
        cuaHangRepository.insert(cuaHang);
        return "redirect:/cua-hang/index";
    }

    @PostMapping("update/{ma}")
    public String update(CuaHang cuaHang){
        cuaHangRepository.update(cuaHang);
        return "redirect:/cua-hang/index";
    }


}
