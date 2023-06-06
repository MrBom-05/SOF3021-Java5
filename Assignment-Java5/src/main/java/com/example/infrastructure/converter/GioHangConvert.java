package com.example.infrastructure.converter;

import com.example.entities.GioHang;
import com.example.models.GioHangViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GioHangConvert {
    @Autowired
    private ModelMapper modelMapper;

    public GioHang mapToEntity(GioHangViewModel viewModel) {
        return modelMapper.map(viewModel, GioHang.class);
    }

    public GioHangViewModel mapToViewModel(GioHang domain) {
        return modelMapper.map(domain, GioHangViewModel.class);
    }
}
