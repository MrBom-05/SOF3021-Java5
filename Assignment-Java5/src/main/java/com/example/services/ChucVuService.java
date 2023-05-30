package com.example.services;

import com.example.models.ChucVuViewModel;

import java.util.List;
import java.util.UUID;

public interface ChucVuService {
    public List<ChucVuViewModel> findAll();
    public void saveOrUpdate(ChucVuViewModel chucVuViewModel);
    public void deleteById(UUID id);
    public ChucVuViewModel findById(UUID id);
}
