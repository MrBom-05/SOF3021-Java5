package com.example.infrastructure.converter;

import com.example.entities.HoaDon;
import com.example.models.HoaDonViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HoaDonConvert {
    @Autowired
    private ModelMapper modelMapper;

    public HoaDon mapToEntity(HoaDonViewModel viewModel) {
        return modelMapper.map(viewModel, HoaDon.class);
    }
}
