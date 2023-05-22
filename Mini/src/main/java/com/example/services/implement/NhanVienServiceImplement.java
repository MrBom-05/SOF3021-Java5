package com.example.services.implement;

import com.example.repositories.NhanVienRepository;
import com.example.services.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NhanVienServiceImplement implements NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;
}
