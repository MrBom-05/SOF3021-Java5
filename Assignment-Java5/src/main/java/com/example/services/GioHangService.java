package com.example.services;

import com.example.entities.GioHang;

import java.util.UUID;

public interface GioHangService {
    public boolean existsByKhachHang(UUID id);
    public GioHang findByKhachHang(UUID id);
}
