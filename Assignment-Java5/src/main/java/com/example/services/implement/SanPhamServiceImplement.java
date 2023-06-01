package com.example.services.implement;

import com.example.entities.SanPham;
import com.example.infrastructure.converter.SanPhamConvert;
import com.example.models.SanPhamViewModel;
import com.example.repositories.SanPhamRepository;
import com.example.services.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SanPhamServiceImplement implements SanPhamService {
    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private SanPhamConvert sanPhamConvert;

    private SerialNumberGenerator serialNumberGenerator = new SerialNumberGenerator();

    @Override
    public List<SanPhamViewModel> findAll() {
        return sanPhamConvert.mapEntityListToViewModelList(sanPhamRepository.findAll());
    }

    @Override
    public void saveOrUpdate(SanPhamViewModel sanPhamViewModel) {
        SanPham sanPham = sanPhamConvert.mapToEntity(sanPhamViewModel);
        if (sanPhamViewModel.getId() != null && sanPhamRepository.existsById(sanPhamViewModel.getId())) {
            sanPhamRepository.save(sanPham);
        } else {
            sanPham.setMa(serialNumberGenerator.generateSerialNumber());
            sanPhamRepository.save(sanPham);
        }
    }

    @Override
    public void deleteById(UUID id) {
        sanPhamRepository.deleteById(id);
    }

    @Override
    public SanPhamViewModel findById(UUID id) {
        Optional<SanPham> optional = sanPhamRepository.findById(id);
        if (optional.isPresent()) {
            return sanPhamConvert.mapToViewModel(optional.get());
        } else {
            return null;
        }
    }
}
