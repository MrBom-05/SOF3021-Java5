package com.example.infrastructure.converter;

import com.example.entities.CuaHang;
import com.example.models.CuaHangViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CuaHangConvert {
    @Autowired
    private ModelMapper modelMapper;

    public CuaHang mapToEntity(CuaHangViewModel viewModel) {
        return modelMapper.map(viewModel, CuaHang.class);
    }

    public CuaHangViewModel mapToViewModel(CuaHang domain) {
        return modelMapper.map(domain, CuaHangViewModel.class);
    }

    public List<CuaHangViewModel> mapEntityListToViewModelList(List<CuaHang> domains) {
        return domains.stream()
                .map(entity -> modelMapper.map(entity, CuaHangViewModel.class))
                .collect(Collectors.toList());
    }
}
