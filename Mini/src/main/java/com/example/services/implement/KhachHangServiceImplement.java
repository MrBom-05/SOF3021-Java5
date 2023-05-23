package com.example.services.implement;

import com.example.entities.KhachHang;
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

    private SerialNumberGenerator serialNumberGenerator = new SerialNumberGenerator();

    @Override
    public List<KhachHang> findAll() {
        return khachHangRepository.findAll();
    }

    @Override
    public void save(KhachHang khachHang) {
        khachHang.setMa(serialNumberGenerator.generateSerialNumber());
        khachHangRepository.save(khachHang);
    }

    @Override
    public void update(KhachHang khachHang, UUID id) {
        Optional<KhachHang> khachHangOptional = khachHangRepository.findById(id);
        if (khachHangOptional.isPresent()) {
            KhachHang khachHangFindById = khachHangOptional.get();

            khachHangFindById.setHo(khachHang.getHo());
            khachHangFindById.setTenDem(khachHang.getTenDem());
            khachHangFindById.setTen(khachHang.getTen());
            khachHangFindById.setNgaySinh(khachHang.getNgaySinh());
            khachHangFindById.setDiaChi(khachHang.getDiaChi());
            khachHangFindById.setThanhPho(khachHang.getThanhPho());
            khachHangFindById.setQuocGia(khachHang.getQuocGia());
            khachHangFindById.setEmail(khachHang.getEmail());
            khachHangFindById.setSdt(khachHang.getSdt());
            khachHangFindById.setMatKhau(khachHang.getMatKhau());

            khachHangRepository.save(khachHangFindById);
        } else {

        }
    }

    @Override
    public void delete(UUID id) {
        khachHangRepository.deleteById(id);
    }

    @Override
    public KhachHang findById(UUID id) {
        Optional<KhachHang> khachHang = khachHangRepository.findById(id);
        if (khachHang.isPresent()) {
            return khachHang.get();
        }
        return null;
    }
}
