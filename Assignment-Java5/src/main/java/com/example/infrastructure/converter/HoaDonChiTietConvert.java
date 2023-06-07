package com.example.infrastructure.converter;

import com.example.entities.HoaDon;
import com.example.models.HoaDonChiTietViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class HoaDonChiTietConvert {
    @Autowired
    private ModelMapper modelMapper;

    public HoaDon mapToEntity(HoaDonChiTietViewModel viewModel) {
        return modelMapper.map(viewModel, HoaDon.class);
    }
}
