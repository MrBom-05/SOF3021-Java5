package com.example.infrastructure.converter;

import com.example.entities.ChiTietSP;
import com.example.models.ChiTietSPViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChiTietSPConvert {
    @Autowired
    private ModelMapper modelMapper;

    public ChiTietSP mapToEntity(ChiTietSPViewModel viewModel){
        return modelMapper.map(viewModel, ChiTietSP.class);
    }

    public ChiTietSPViewModel mapToViewModel(ChiTietSP entity){
        return modelMapper.map(entity, ChiTietSPViewModel.class);
    }

    public List<ChiTietSPViewModel> mapEntityListToViewModelList(List<ChiTietSP> domains){
        return domains.stream()
                .map(domain -> mapToViewModel(domain))
                .collect(java.util.stream.Collectors.toList());
    }
}
