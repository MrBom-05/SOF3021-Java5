package com.example.services.implement;

import com.example.repositories.KhachHangRepository;
import com.example.services.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhachHangServiceImplement implements KhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;
}
