package com.example.infrastructure.converter;

import com.example.entities.ChucVu;
import com.example.models.ChucVuViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChucVuConvert {
    @Autowired
    private ModelMapper modelMapper;

    public ChucVu mapToEntity(ChucVuViewModel viewModel) {
        return modelMapper.map(viewModel, ChucVu.class);
    }

    public ChucVuViewModel mapToViewModel(ChucVu domain) {
        return modelMapper.map(domain, ChucVuViewModel.class);
    }

    public List<ChucVuViewModel> mapEntityListToViewModelList(List<ChucVu> domains) {
        return domains.stream()
                .map(domain -> mapToViewModel(domain))
                .collect(java.util.stream.Collectors.toList());
    }
}
