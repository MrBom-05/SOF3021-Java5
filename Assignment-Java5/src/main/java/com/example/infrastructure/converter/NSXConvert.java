package com.example.infrastructure.converter;

import com.example.entities.NSX;
import com.example.models.NSXViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NSXConvert {
    @Autowired
    private ModelMapper modelMapper;

    public NSX mapToEntity(NSXViewModel viewModel) {
        return modelMapper.map(viewModel, NSX.class);
    }

    public NSXViewModel mapToViewModel(NSX nsx) {
        return modelMapper.map(nsx, NSXViewModel.class);
    }

    public List<NSXViewModel> mapEntityListToViewModelList(List<NSX> domains) {
        return domains.stream()
                .map(entity -> modelMapper.map(entity, NSXViewModel.class))
                .collect(Collectors.toList());
    }
}
