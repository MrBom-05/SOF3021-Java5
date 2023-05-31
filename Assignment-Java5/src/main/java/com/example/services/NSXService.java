package com.example.services;

import com.example.models.NSXViewModel;

import java.util.List;
import java.util.UUID;

public interface NSXService {
    public List<NSXViewModel> findAll();
    public void saveOrUpdate(NSXViewModel nsxViewModel);
    public void deleteById(UUID id);
    public NSXViewModel findById(UUID id);
}
