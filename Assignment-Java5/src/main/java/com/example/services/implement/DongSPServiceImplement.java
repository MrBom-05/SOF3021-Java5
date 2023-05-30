package com.example.services.implement;

import com.example.entities.DongSP;
import com.example.infrastructure.converter.DongSPConvert;
import com.example.models.DongSPViewModel;
import com.example.repositories.DongSPRepository;
import com.example.services.DongSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DongSPServiceImplement implements DongSPService {
    @Autowired
    private DongSPRepository dongSPRepository;

    @Autowired
    private DongSPConvert dongSPConvert;

    private SerialNumberGenerator serialNumberGenerator = new SerialNumberGenerator();

    @Override
    public List<DongSPViewModel> findAll() {
        return dongSPConvert.mapEntityListToViewModelList(dongSPRepository.findAll());
    }

    @Override
    public void saveOrUpdate(DongSPViewModel dongSPViewModel) {
        DongSP dongSP = dongSPConvert.mapToDomain(dongSPViewModel);
        if (dongSPViewModel.getId() != null && dongSPRepository.existsById(dongSPViewModel.getId())){
            dongSPRepository.save(dongSP);
        } else {
            dongSP.setMa(serialNumberGenerator.generateSerialNumber());
            dongSPRepository.save(dongSP);
        }
    }

    @Override
    public void deleteById(UUID id) {
        dongSPRepository.deleteById(id);
    }

    @Override
    public DongSPViewModel findById(UUID id) {
        Optional<DongSP> optional = dongSPRepository.findById(id);
        if (optional.isPresent()) {
            return dongSPConvert.mapToViewModel(optional.get());
        } else {
            return null;
        }
    }
}
