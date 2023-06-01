package com.example.services;

import com.example.models.ChiTietSPViewModel;

import java.util.List;
import java.util.UUID;

public interface ChiTietSPService {
    public List<ChiTietSPViewModel> findAll();
    public void saveOrUpdate(ChiTietSPViewModel chiTietSPViewModel);
    public void deleteById(UUID id);
    public ChiTietSPViewModel findById(UUID id);
}
