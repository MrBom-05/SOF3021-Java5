package com.example.services.implement;

import com.example.entities.GioHang;
import com.example.repositories.GioHangRepository;
import com.example.services.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GioHangServiceImplement implements GioHangService {

    @Autowired
    private GioHangRepository gioHangRepository;

    @Override
    public boolean existsByKhachHang(UUID id) {
        return gioHangRepository.existsByKhachHang(id);
    }

    @Override
    public GioHang findByKhachHang(UUID id) {
        return gioHangRepository.findByKhachHang(id);
    }
}
