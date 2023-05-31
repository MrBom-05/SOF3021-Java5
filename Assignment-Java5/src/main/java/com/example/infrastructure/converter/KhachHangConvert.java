package com.example.infrastructure.converter;

import com.example.entities.KhachHang;
import com.example.models.KhachHangViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class KhachHangConvert {
    @Autowired
    private ModelMapper modelMapper;

    public KhachHang mapToEntity(KhachHangViewModel viewModel) {
        return modelMapper.map(viewModel, KhachHang.class);
    }

    public KhachHangViewModel mapToViewModel(KhachHang domain) {
        return modelMapper.map(domain, KhachHangViewModel.class);
    }

    public List<KhachHangViewModel> mapEntityListToViewModelList(List<KhachHang> domains) {
        return domains.stream()
                .map(entity -> modelMapper.map(entity, KhachHangViewModel.class))
                .collect(Collectors.toList());
    }
}
