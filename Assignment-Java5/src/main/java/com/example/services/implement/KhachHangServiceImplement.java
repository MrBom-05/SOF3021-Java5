package com.example.services.implement;

import com.example.entities.KhachHang;
import com.example.infrastructure.converter.GioHangConvert;
import com.example.infrastructure.converter.KhachHangConvert;
import com.example.infrastructure.request.UserAccountRequest;
import com.example.models.GioHangViewModel;
import com.example.models.KhachHangViewModel;
import com.example.repositories.GioHangRepository;
import com.example.repositories.KhachHangRepository;
import com.example.services.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class KhachHangServiceImplement implements KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;

    @Autowired
    private GioHangRepository gioHangRepository;

    @Autowired
    private KhachHangConvert khachHangConvert;

    @Autowired
    private GioHangConvert gioHangConvert;

    @Autowired
    private GioHangViewModel gioHangViewModel;

    private SerialNumberGenerator serialNumberGenerator = new SerialNumberGenerator();

    @Override
    public List<KhachHangViewModel> findAll() {
        return khachHangConvert.mapEntityListToViewModelList(khachHangRepository.findAll());
    }

    @Override
    public void saveOrUpdate(KhachHangViewModel khachHangViewModel) {
        KhachHang khachHang = khachHangConvert.mapToEntity(khachHangViewModel);
        if (khachHangViewModel.getId() != null && khachHangRepository.existsById(khachHangViewModel.getId())) {
            khachHangRepository.save(khachHang);
        } else {
            khachHang.setMa(serialNumberGenerator.generateSerialNumber());
            khachHangRepository.save(khachHang);
        }
    }

    @Override
    public void deleteById(UUID id) {
        khachHangRepository.deleteById(id);
    }

    @Override
    public KhachHangViewModel findById(UUID id) {
        Optional<KhachHang> optional = khachHangRepository.findById(id);
        if (optional.isPresent()) {
            return khachHangConvert.mapToViewModel(optional.get());
        } else {
            return null;
        }
    }

    @Override
    public KhachHangViewModel login(UserAccountRequest userAccountRequest) {
        KhachHang khachHang = khachHangRepository.login(userAccountRequest.getEmail(), userAccountRequest.getMatKhau());
        if (khachHang != null) {
            if (!gioHangRepository.existsByKhachHang(khachHang.getId())) {
                gioHangViewModel.setKhachHang(khachHang);
                gioHangViewModel.setMa(serialNumberGenerator.generateSerialNumber());
                gioHangViewModel.setTrangThai(1);
                gioHangRepository.save(gioHangConvert.mapToEntity(gioHangViewModel));
            }
            return khachHangConvert.mapToViewModel(khachHang);
        } else {
            return null;
        }
    }
}
