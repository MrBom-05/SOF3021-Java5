package com.example.controllers;

import com.example.services.ChucVuService;
import com.example.services.implement.ChucVuServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("chuc-vu")
public class ChucVuController {

    @Autowired
    private ChucVuService chucVuService = new ChucVuServiceImplement();
}
