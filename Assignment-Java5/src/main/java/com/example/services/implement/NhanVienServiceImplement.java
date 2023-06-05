package com.example.services.implement;

import com.example.entities.NhanVien;
import com.example.infrastructure.converter.NhanVienConvert;
import com.example.infrastructure.request.AdminAccountRequest;
import com.example.models.NhanVienViewModel;
import com.example.repositories.NhanVienRepository;
import com.example.services.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NhanVienServiceImplement implements NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Autowired
    private NhanVienConvert nhanVienConvert;

    private SerialNumberGenerator serialNumberGenerator = new SerialNumberGenerator();

    @Override
    public List<NhanVienViewModel> findAll() {
        return nhanVienConvert.mapEntityListToViewModelList(nhanVienRepository.findAll());
    }

    @Override
    public void saveOrUpdate(NhanVienViewModel nhanVienViewModel) {
        NhanVien nhanVien = nhanVienConvert.mapToEntity(nhanVienViewModel);
        if(nhanVienViewModel.getId() != null && nhanVienRepository.existsById(nhanVienViewModel.getId())) {
            nhanVienRepository.save(nhanVien);
        } else {
            nhanVien.setMa(serialNumberGenerator.generateSerialNumber());
            nhanVienRepository.save(nhanVien);
        }
    }

    @Override
    public void deleteById(UUID id) {
        nhanVienRepository.deleteById(id);
    }

    @Override
    public NhanVienViewModel findById(UUID id) {
        Optional<NhanVien> optional = nhanVienRepository.findById(id);
        if (optional.isPresent()) {
            return nhanVienConvert.mapToViewModel(optional.get());
        } else {
            return null;
        }
    }

    @Override
    public NhanVienViewModel login(AdminAccountRequest adminAccountRequest) {
        NhanVien nhanVien = nhanVienRepository.login(adminAccountRequest.getEmail(), adminAccountRequest.getMatKhau());

        if (nhanVien != null) {
            return nhanVienConvert.mapToViewModel(nhanVien);
        } else {
            return null;
        }
    }
}
