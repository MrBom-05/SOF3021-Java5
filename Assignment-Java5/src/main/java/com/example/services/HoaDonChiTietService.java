package com.example.services;

import com.example.infrastructure.response.HoaDonChiTietResponse;
import com.example.infrastructure.response.HoaDonResponse;
import com.example.infrastructure.response.HoaDonUserResponse;
import com.example.models.KhachHangViewModel;

import java.util.List;
import java.util.UUID;

public interface HoaDonChiTietService {
    public List<HoaDonResponse> findByKhachHang(UUID id);
    public HoaDonUserResponse getByID(UUID id);
    List<HoaDonChiTietResponse> getListByID(UUID id);
    public void add(UUID idSP, int soLuong, KhachHangViewModel khachHangViewModel);
    public void addAll(KhachHangViewModel khachHangViewModel);
}
