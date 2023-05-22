package com.example.controllers;

import com.example.services.NhanVienService;
import com.example.services.implement.NhanVienServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("nhan-vien")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService = new NhanVienServiceImplement();
}
