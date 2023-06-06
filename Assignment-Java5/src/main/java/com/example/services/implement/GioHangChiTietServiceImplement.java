package com.example.services.implement;

import com.example.infrastructure.response.GioHangResponse;
import com.example.repositories.GioHangChiTietRepository;
import com.example.services.GioHangChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GioHangChiTietServiceImplement implements GioHangChiTietService {
    @Autowired
    private GioHangChiTietRepository gioHangChiTietRepository;

    @Override
    public List<GioHangResponse> findGiaHangByKhachHang(UUID id) {
        return gioHangChiTietRepository.findGiaHangByKhachHang(id);
    }
}
