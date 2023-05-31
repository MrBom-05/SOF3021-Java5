package com.example.services.implement;

import com.example.entities.CuaHang;
import com.example.infrastructure.converter.CuaHangConvert;
import com.example.models.CuaHangViewModel;
import com.example.repositories.CuaHangRepository;
import com.example.services.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CuaHangServiceImplement implements CuaHangService {

    @Autowired
    private CuaHangRepository cuaHangRepository;

    @Autowired
    private CuaHangConvert cuaHangConvert;

    private SerialNumberGenerator serialNumberGenerator = new SerialNumberGenerator();

    @Override
    public List<CuaHangViewModel> findAll() {
        return cuaHangConvert.mapEntityListToViewModelList(cuaHangRepository.findAll());
    }

    @Override
    public void saveOrUpdate(CuaHangViewModel cuaHangViewModel) {
        CuaHang cuaHang = cuaHangConvert.mapToEntity(cuaHangViewModel);
        if (cuaHangViewModel.getId() != null && cuaHangRepository.existsById(cuaHangViewModel.getId())) {
            cuaHangRepository.save(cuaHang);
        } else {
            cuaHang.setMa(serialNumberGenerator.generateSerialNumber());
            cuaHangRepository.save(cuaHang);
        }
    }

    @Override
    public void deleteById(UUID id) {
        cuaHangRepository.deleteById(id);
    }

    @Override
    public CuaHangViewModel findById(UUID id) {
        Optional<CuaHang> optional = cuaHangRepository.findById(id);
        if (optional.isPresent()) {
            return cuaHangConvert.mapToViewModel(optional.get());
        } else {
            return null;
        }
    }
}
