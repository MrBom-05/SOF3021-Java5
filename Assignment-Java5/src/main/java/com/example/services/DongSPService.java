package com.example.services;

import com.example.models.DongSPViewModel;

import java.util.List;
import java.util.UUID;

public interface DongSPService {
    public List<DongSPViewModel> findAll();
    public void saveOrUpdate(DongSPViewModel dongSPViewModel);
    public void deleteById(UUID id);
    public DongSPViewModel findById(UUID id);
}
