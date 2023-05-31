package com.example.infrastructure.converter;

import com.example.entities.NhanVien;
import com.example.models.NhanVienViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NhanVienConvert {
    @Autowired
    private ModelMapper modelMapper;

    public NhanVien mapToEntity(NhanVienViewModel viewModel) {
        return modelMapper.map(viewModel, NhanVien.class);
    }

    public NhanVienViewModel mapToViewModel(NhanVien entity) {
        return modelMapper.map(entity, NhanVienViewModel.class);
    }

    public List<NhanVienViewModel> mapEntityListToViewModelList(List<NhanVien> domains) {
        return domains.stream()
                .map(entity -> modelMapper.map(entity, NhanVienViewModel.class))
                .collect(Collectors.toList());
    }
}
