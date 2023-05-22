package com.example.services.implement;

import com.example.repositories.SanPhamRepository;
import com.example.services.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SanPhamServiceImplement implements SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;
}
