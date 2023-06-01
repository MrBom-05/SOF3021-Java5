package com.example.services.implement;

import com.example.entities.ChiTietSP;
import com.example.infrastructure.converter.ChiTietSPConvert;
import com.example.models.ChiTietSPViewModel;
import com.example.repositories.ChiTietSPRepository;
import com.example.services.ChiTietSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChiTietSPServiceImplement implements ChiTietSPService {
    @Autowired
    private ChiTietSPRepository chiTietSPRepository;
    @Autowired
    private ChiTietSPConvert chiTietSPConvert;

    @Override
    public List<ChiTietSPViewModel> findAll() {
        return chiTietSPConvert.mapEntityListToViewModelList(chiTietSPRepository.findAll());
    }

    @Override
    public void saveOrUpdate(ChiTietSPViewModel chiTietSPViewModel) {
        ChiTietSP chiTietSP = chiTietSPConvert.mapToEntity(chiTietSPViewModel);
        if (chiTietSPViewModel.getId() != null && chiTietSPRepository.existsById(chiTietSPViewModel.getId())) {
            chiTietSPRepository.save(chiTietSP);
        } else {
            chiTietSPRepository.save(chiTietSP);
        }
    }

    @Override
    public void deleteById(UUID id) {
        chiTietSPRepository.deleteById(id);
    }

    @Override
    public ChiTietSPViewModel findById(UUID id) {
        Optional<ChiTietSP> optional = chiTietSPRepository.findById(id);
        if (optional.isPresent()) {
            return chiTietSPConvert.mapToViewModel(optional.get());
        } else {
            return null;
        }
    }
}