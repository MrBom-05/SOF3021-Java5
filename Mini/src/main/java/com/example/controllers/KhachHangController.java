package com.example.controllers;

import com.example.services.KhachHangService;
import com.example.services.implement.KhachHangServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("khach-hang")
public class KhachHangController {

    @Autowired
    private KhachHangService khachHangService = new KhachHangServiceImplement();
}
