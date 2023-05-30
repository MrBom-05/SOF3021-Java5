package com.example.infrastructure.converter;

import com.example.entities.CuaHang;
import com.example.models.CuaHangViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CuaHangConvert {
    @Autowired
    private ModelMapper modelMapper;

    public CuaHang mapToDomain(CuaHangViewModel viewModel) {
        return modelMapper.map(viewModel, CuaHang.class);
    }

    public CuaHangViewModel mapToViewModel(CuaHang domain) {
        return modelMapper.map(domain, CuaHangViewModel.class);
    }
}
