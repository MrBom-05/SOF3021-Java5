package com.example.services;

import com.example.models.SanPhamViewModel;

import java.util.List;
import java.util.UUID;

public interface SanPhamService {
    public List<SanPhamViewModel> findAll();
    public void saveOrUpdate(SanPhamViewModel sanPhamViewModel);
    public void deleteById(UUID id);
    public SanPhamViewModel findById(UUID id);
}
