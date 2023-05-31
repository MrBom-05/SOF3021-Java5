package com.example.services.implement;

import com.example.entities.NSX;
import com.example.infrastructure.converter.NSXConvert;
import com.example.models.NSXViewModel;
import com.example.repositories.NSXRepository;
import com.example.services.NSXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NSXServiceImplement implements NSXService {
    @Autowired
    private NSXRepository nsxRepository;
    @Autowired
    private NSXConvert nsxConvert;

    private SerialNumberGenerator serialNumberGenerator = new SerialNumberGenerator();


    @Override
    public List<NSXViewModel> findAll() {
        return nsxConvert.mapEntityListToViewModelList(nsxRepository.findAll());
    }

    @Override
    public void saveOrUpdate(NSXViewModel nsxViewModel) {
        NSX nsx = nsxConvert.mapToEntity(nsxViewModel);
        if (nsxViewModel.getId() != null && nsxRepository.existsById(nsxViewModel.getId())) {
            nsxRepository.save(nsx);
        } else {
            nsx.setMa(serialNumberGenerator.generateSerialNumber());
            nsxRepository.save(nsx);
        }
    }

    @Override
    public void deleteById(UUID id) {
        nsxRepository.deleteById(id);
    }

    @Override
    public NSXViewModel findById(UUID id) {
        Optional<NSX> optional = nsxRepository.findById(id);
        if (optional.isPresent()) {
            return nsxConvert.mapToViewModel(optional.get());
        } else {
            return null;
        }
    }
}
