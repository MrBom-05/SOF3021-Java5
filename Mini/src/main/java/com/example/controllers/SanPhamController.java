package com.example.controllers;

import com.example.services.SanPhamService;
import com.example.services.implement.SanPhamServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("san-pham")
public class SanPhamController {

    @Autowired
    private SanPhamService sanPhamService = new SanPhamServiceImplement();
}
