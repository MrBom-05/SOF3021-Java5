package com.example.infrastructure.converter;

import com.example.entities.GioHangChiTiet;
import com.example.models.GioHangChiTietViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GioHangChiTietConvert {
    @Autowired
    private ModelMapper modelMapper;

    public GioHangChiTiet mapToEntity(GioHangChiTietViewModel viewModel) {
        return modelMapper.map(viewModel, GioHangChiTiet.class);
    }
    public GioHangChiTietViewModel mapToViewModel(GioHangChiTiet entity) {
        return modelMapper.map(entity, GioHangChiTietViewModel.class);
    }
}
