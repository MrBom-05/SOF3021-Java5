package com.example.services;

import com.example.models.KhachHangViewModel;

import java.util.List;
import java.util.UUID;

public interface KhachHangService {
    public List<KhachHangViewModel> findAll();
    public void saveOrUpdate(KhachHangViewModel khachHangViewModel);
    public void deleteById(UUID id);
    public KhachHangViewModel findById(UUID id);
}
