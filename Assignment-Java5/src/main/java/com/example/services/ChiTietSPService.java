package com.example.services;

import com.example.infrastructure.response.ChiTietSPResponse;
import com.example.infrastructure.response.SanPhamResponse;
import com.example.models.ChiTietSPViewModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface ChiTietSPService {
    public List<ChiTietSPViewModel> findAll();
    public void saveOrUpdate(ChiTietSPViewModel chiTietSPViewModel);
    public void deleteById(UUID id);
    public ChiTietSPViewModel findById(UUID id);
    public List<ChiTietSPResponse> findAllHomeByChiTietSP();
    public SanPhamResponse findBySanPhamResponse(UUID id);
    public void updateProductQuantity(UUID id, int newQuantity, int oldQuantity);
    public BigDecimal findByGiaBan(UUID id);
}
