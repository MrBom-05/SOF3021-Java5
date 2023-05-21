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
    public void saveOrUpdate(CuaHang cuaHang) {
        cuaHangRepository.save(cuaHang);
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
