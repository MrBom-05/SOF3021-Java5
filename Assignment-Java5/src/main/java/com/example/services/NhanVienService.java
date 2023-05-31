package com.example.services;

import com.example.models.NhanVienViewModel;

import java.util.List;
import java.util.UUID;

public interface NhanVienService {
    public List<NhanVienViewModel> findAll();
    public void saveOrUpdate(NhanVienViewModel nhanVienViewModel);
    public void deleteById(UUID id);
    public NhanVienViewModel findById(UUID id);
}
