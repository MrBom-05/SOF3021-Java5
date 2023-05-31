package com.example.services.implement;

import com.example.entities.MauSac;
import com.example.infrastructure.converter.MauSacConvert;
import com.example.models.MauSacViewModel;
import com.example.repositories.MauSacRepository;
import com.example.services.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MauSacServiceImplement implements MauSacService {
    @Autowired
    private MauSacRepository mauSacRepository;

    @Autowired
    private MauSacConvert mauSacConvert;

    private SerialNumberGenerator serialNumberGenerator = new SerialNumberGenerator();

    @Override
    public List<MauSacViewModel> findAll() {
        return mauSacConvert.mapEntityListToViewModelList(mauSacRepository.findAll());
    }

    @Override
    public void saveOrUpdate(MauSacViewModel mauSacViewModel) {
        MauSac mauSac = mauSacConvert.mapToEntity(mauSacViewModel);
        if (mauSacViewModel.getId() != null && mauSacRepository.existsById(mauSacViewModel.getId())) {
            mauSacRepository.save(mauSac);
        } else {
            mauSac.setMa(serialNumberGenerator.generateSerialNumber());
            mauSacRepository.save(mauSac);
        }

    }

    @Override
    public void deleteById(UUID id) {
        mauSacRepository.deleteById(id);
    }

    @Override
    public MauSacViewModel findById(UUID id) {
        Optional<MauSac> optional = mauSacRepository.findById(id);
        if (optional.isPresent()) {
            return mauSacConvert.mapToViewModel(optional.get());
        } else {
            return null;
        }
    }
}
