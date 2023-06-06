package com.example.services;

import com.example.infrastructure.response.GioHangResponse;

import java.util.List;
import java.util.UUID;

public interface GioHangChiTietService {
    public List<GioHangResponse> findGiaHangByKhachHang(UUID id);
}
