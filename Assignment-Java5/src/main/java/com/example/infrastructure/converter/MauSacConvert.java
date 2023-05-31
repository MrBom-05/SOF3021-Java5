package com.example.infrastructure.converter;

import com.example.entities.MauSac;
import com.example.models.MauSacViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MauSacConvert {
    @Autowired
    private ModelMapper modelMapper;

    public MauSac mapToEntity(MauSacViewModel viewModel) {
        return modelMapper.map(viewModel, MauSac.class);
    }

    public MauSacViewModel mapToViewModel(MauSac domain) {
        return modelMapper.map(domain, MauSacViewModel.class);
    }

    public List<MauSacViewModel> mapEntityListToViewModelList(List<MauSac> domains) {
        return domains.stream()
                .map(domain -> mapToViewModel(domain))
                .collect(java.util.stream.Collectors.toList());
    }
}
