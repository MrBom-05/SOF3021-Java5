package com.example.services;

import com.example.entities.CuaHang;

import java.util.List;
import java.util.UUID;

public interface CuaHangService {
    public List<CuaHang> findAll();
    public void save(CuaHang cuaHang);
    public void update(CuaHang cuaHang, UUID id);
    public void deleteById(UUID id);
    public CuaHang findById(UUID id);
}
