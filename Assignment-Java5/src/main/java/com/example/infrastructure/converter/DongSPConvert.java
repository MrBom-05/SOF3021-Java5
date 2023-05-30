package com.example.infrastructure.converter;

import com.example.entities.DongSP;
import com.example.models.DongSPViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DongSPConvert {
    @Autowired
    private ModelMapper modelMapper;

    public DongSP mapToDomain(DongSPViewModel viewModel) {
        return modelMapper.map(viewModel, DongSP.class);
    }

    public DongSPViewModel mapToViewModel(DongSP domain) {
        return modelMapper.map(domain, DongSPViewModel.class);
    }

    public List<DongSPViewModel> mapEntityListToViewModelList(List<DongSP> entityList) {
        return entityList.stream()
                .map(entity -> modelMapper.map(entity, DongSPViewModel.class))
                .collect(Collectors.toList());
    }
}
