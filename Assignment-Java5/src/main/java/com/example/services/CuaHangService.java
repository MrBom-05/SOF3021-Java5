package com.example.services;

import com.example.models.CuaHangViewModel;
import java.util.List;
import java.util.UUID;

public interface CuaHangService {
    public List<CuaHangViewModel> findAll();
    public void saveOrUpdate(CuaHangViewModel cuaHangViewModel);
    public void deleteById(UUID id);
    public CuaHangViewModel findById(UUID id);
}
