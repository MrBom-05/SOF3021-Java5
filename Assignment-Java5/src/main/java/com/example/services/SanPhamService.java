package com.example.services;

import com.example.infrastructure.request.SanPhamRequest;
import com.example.models.SanPhamViewModel;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

public interface SanPhamService {
    public List<SanPhamViewModel> findAll();
    public void saveOrUpdate(SanPhamRequest sanPhamRequest, MultipartFile path);
    public void deleteById(UUID id);
    public SanPhamViewModel findById(UUID id);
}
