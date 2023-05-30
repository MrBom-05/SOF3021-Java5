package com.example.infrastructure.converter;

import com.example.entities.ChucVu;
import com.example.models.ChucVuViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChucVuConvert {
    @Autowired
    private ModelMapper modelMapper;

    public ChucVu mapToDomain(ChucVuViewModel viewModel) {
        return modelMapper.map(viewModel, ChucVu.class);
    }

    public ChucVuViewModel mapToViewModel(ChucVu domain) {
        return modelMapper.map(domain, ChucVuViewModel.class);
    }

    public List<ChucVuViewModel> mapEntityListToViewModelList(List<ChucVu> entityList) {
        return entityList.stream()
                .map(entity -> modelMapper.map(entity, ChucVuViewModel.class))
                .collect(Collectors.toList());
    }
}
