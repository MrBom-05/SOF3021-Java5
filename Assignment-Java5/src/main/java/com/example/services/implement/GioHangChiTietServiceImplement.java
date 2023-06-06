package com.example.services.implement;

import com.example.entities.GioHang;
import com.example.infrastructure.converter.ChiTietSPConvert;
import com.example.infrastructure.converter.GioHangChiTietConvert;
import com.example.infrastructure.response.GioHangResponse;
import com.example.models.ChiTietSPViewModel;
import com.example.models.GioHangChiTietViewModel;
import com.example.models.KhachHangViewModel;
import com.example.repositories.GioHangChiTietRepository;
import com.example.repositories.GioHangRepository;
import com.example.services.ChiTietSPService;
import com.example.services.GioHangChiTietService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GioHangChiTietServiceImplement implements GioHangChiTietService {
    @Autowired
    private GioHangChiTietRepository gioHangChiTietRepository;

    @Autowired
    private GioHangRepository gioHangRepository;

    @Autowired
    private ChiTietSPService chiTietSPService;
    @Autowired
    private GioHangChiTietConvert gioHangChiTietConvert;
    @Autowired
    private ChiTietSPConvert chiTietSPConvert;

    @Autowired
    private GioHangChiTietViewModel gioHangChiTietViewModel;

    @Override
    public List<GioHangResponse> findGiaHangByKhachHang(UUID id) {
        return gioHangChiTietRepository.findGiaHangByKhachHang(id);
    }

    @Override
    public void add(UUID id, int soLuong, KhachHangViewModel khachHangViewModel) {

        GioHang gioHang = gioHangRepository.findByKhachHang(khachHangViewModel.getId());
        ChiTietSPViewModel chiTietSPViewModel = chiTietSPService.findById(id);

        gioHangChiTietViewModel.setChiTietSP(chiTietSPConvert.mapToEntity(chiTietSPViewModel)); // ChiTietSP

        gioHangChiTietViewModel.setGioHang(gioHang); // GioHang

        gioHangChiTietViewModel.setSoLuong(soLuong); // SoLuong
        gioHangChiTietViewModel.setDonGia(chiTietSPService.findByGiaBan(id)); // DonGia

        int soLuongCu = gioHangChiTietRepository.findSoLuongByChiTietSPAndGioHang(id, gioHang.getId());

        if (!gioHangChiTietRepository.existsByChiTietSPAndGioHang(id, gioHang.getId())) {
            gioHangChiTietRepository.save(gioHangChiTietConvert.mapToEntity(gioHangChiTietViewModel)); // Save
        } else {
            gioHangChiTietRepository.save(gioHangChiTietConvert.mapToEntity(gioHangChiTietViewModel)); // Save
        }

        chiTietSPService.updateProductQuantity(id, soLuong, soLuongCu);
    }

    @Transactional
    @Override
    public void delete(UUID idSP, KhachHangViewModel khachHangViewModel) {
        GioHang gioHang = gioHangRepository.findByKhachHang(khachHangViewModel.getId());
        gioHangChiTietRepository.deleteGioHangChiTietByChiTietSPAndGioHang(idSP, gioHang.getId());
    }
}
