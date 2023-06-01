package com.example.infrastructure.converter;

import com.example.entities.SanPham;
import com.example.models.SanPhamViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SanPhamConvert {
    @Autowired
    private ModelMapper modelMapper;

    public SanPham mapToEntity(SanPhamViewModel viewModel) {
        return modelMapper.map(viewModel, SanPham.class);
    }

    public SanPhamViewModel mapToViewModel(SanPham domain) {
        return modelMapper.map(domain, SanPhamViewModel.class);
    }

    public List<SanPhamViewModel> mapEntityListToViewModelList(List<SanPham> domains) {
        return domains.stream()
                .map(entity -> modelMapper.map(entity, SanPhamViewModel.class))
                .collect(Collectors.toList());
    }
}
