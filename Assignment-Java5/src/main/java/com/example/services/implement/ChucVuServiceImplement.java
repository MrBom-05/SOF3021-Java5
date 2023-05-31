package com.example.services.implement;

import com.example.entities.ChucVu;
import com.example.infrastructure.converter.ChucVuConvert;
import com.example.models.ChucVuViewModel;
import com.example.repositories.ChucVuRepository;
import com.example.services.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChucVuServiceImplement implements ChucVuService {

    @Autowired
    private ChucVuRepository chucVuRepository;

    @Autowired
    private ChucVuConvert chucVuConvert;

    private SerialNumberGenerator serialNumberGenerator = new SerialNumberGenerator();

    @Override
    public List<ChucVuViewModel> findAll() {
        return chucVuConvert.mapEntityListToViewModelList(chucVuRepository.findAll());
    }

    @Override
    public void saveOrUpdate(ChucVuViewModel chucVuViewModel) {
        ChucVu chucVu = chucVuConvert.mapToEntity(chucVuViewModel);
        if (chucVuViewModel.getId() != null && chucVuRepository.existsById(chucVuViewModel.getId())) {
            chucVuRepository.save(chucVu);
        } else {
            chucVu.setMa(serialNumberGenerator.generateSerialNumber());
            chucVuRepository.save(chucVu);
        }
    }

    @Override
    public void deleteById(UUID id) {
        chucVuRepository.deleteById(id);
    }

    @Override
    public ChucVuViewModel findById(UUID id) {
        Optional<ChucVu> optional = chucVuRepository.findById(id);
        if (optional.isPresent()) {
            return chucVuConvert.mapToViewModel(optional.get());
        } else {
            return null;
        }
    }
}
