package com.example.services;

import com.example.infrastructure.response.ChiTietSPResponse;
import com.example.infrastructure.response.SanPhamResponse;
import com.example.models.ChiTietSPViewModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface ChiTietSPService {
    public List<ChiTietSPViewModel> findAll();
    public void saveOrUpdate(ChiTietSPViewModel chiTietSPViewModel);
    public void deleteById(UUID id);
    public ChiTietSPViewModel findById(UUID id);
    public Page<ChiTietSPResponse> findAllHomeByChiTietSP(Pageable pageable);
    public SanPhamResponse findBySanPhamResponse(UUID id);
    public void updateProductQuantity(UUID id, int newQuantity, int oldQuantity);
    public void updateProductQuantityByDeleteGioHang(UUID id, int oldQuantity);
    public BigDecimal findByGiaBan(UUID id);
}
