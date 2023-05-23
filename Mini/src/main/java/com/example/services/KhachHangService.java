package com.example.services;

import com.example.entities.KhachHang;

import java.util.List;
import java.util.UUID;

public interface KhachHangService {
    public List<KhachHang> findAll();
    public void save(KhachHang khachHang);
    public void update(KhachHang khachHang, UUID id);
    public void delete(UUID id);
    public KhachHang findById(UUID id);
}
