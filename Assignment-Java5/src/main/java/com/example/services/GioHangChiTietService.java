package com.example.services;

import com.example.entities.GioHangChiTiet;
import com.example.infrastructure.response.GioHangResponse;
import com.example.models.KhachHangViewModel;

import java.util.List;
import java.util.UUID;

public interface GioHangChiTietService {
    public List<GioHangResponse> findGioHangByKhachHang(UUID id);
    public void add(UUID idSP, int soLuong, KhachHangViewModel khachHangViewModel);
    public void update(UUID idSP, int soLuong, KhachHangViewModel khachHangViewModel);
    public void delete(UUID idSP, KhachHangViewModel khachHangViewModel);
    public void deleteGioHangChiTietByGioHang(UUID id);
    public List<GioHangChiTiet> findGioHangChiTietByKhachHang(UUID id);
    public int index(UUID id);
}
