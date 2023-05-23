package com.example.services.implement;

import com.example.entities.CuaHang;
import com.example.repositories.CuaHangRepository;
import com.example.services.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CuaHangServiceImplement implements CuaHangService {

    @Autowired
    private CuaHangRepository cuaHangRepository;

    private SerialNumberGenerator serialNumberGenerator = new SerialNumberGenerator();

    @Override
    public List<CuaHang> findAll() {
        try {
            return cuaHangRepository.findAll();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(CuaHang cuaHang) {
        cuaHang.setMa(serialNumberGenerator.generateSerialNumber());
        cuaHangRepository.save(cuaHang);
    }

    @Override
    public void update(CuaHang cuaHang, UUID id) {
        Optional<CuaHang> cuaHangOptional = cuaHangRepository.findById(id);
        if (cuaHangOptional.isPresent()){
            CuaHang cuaHangFindById = cuaHangOptional.get();

            cuaHangFindById.setTen(cuaHang.getTen());
            cuaHangFindById.setDiaChi(cuaHang.getDiaChi());
            cuaHangFindById.setThanhPho(cuaHang.getThanhPho());
            cuaHangFindById.setQuocGia(cuaHang.getQuocGia());

            cuaHangRepository.save(cuaHangFindById);
        }
    }

    @Override
    public void deleteById(UUID id) {
        cuaHangRepository.deleteById(id);
    }

    @Override
    public CuaHang findById(UUID id) {
        Optional<CuaHang> cuaHang = cuaHangRepository.findById(id);
        if (cuaHang.isPresent()) {
            return cuaHang.get();
        }
        return null;
    }
}
