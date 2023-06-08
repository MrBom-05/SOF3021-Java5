package com.example.services.implement;

import com.example.entities.GioHang;
import com.example.entities.GioHangChiTiet;
import com.example.infrastructure.converter.ChiTietSPConvert;
import com.example.infrastructure.converter.GioHangChiTietConvert;
import com.example.infrastructure.response.GioHangResponse;
import com.example.models.ChiTietSPViewModel;
import com.example.models.GioHangChiTietViewModel;
import com.example.models.KhachHangViewModel;
import com.example.repositories.GioHangChiTietRepository;
import com.example.services.ChiTietSPService;
import com.example.services.GioHangChiTietService;
import com.example.services.GioHangService;
import jakarta.transaction.Transactional;
import org.springframework.aop.AopInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GioHangChiTietServiceImplement implements GioHangChiTietService {
    @Autowired
    private GioHangChiTietRepository gioHangChiTietRepository;
    @Autowired
    private GioHangService gioHangService;
    @Autowired
    private ChiTietSPService chiTietSPService;
    @Autowired
    private GioHangChiTietConvert gioHangChiTietConvert;
    @Autowired
    private ChiTietSPConvert chiTietSPConvert;
    @Autowired
    private GioHangChiTietViewModel gioHangChiTietViewModel;

    @Override
    public List<GioHangResponse> findGioHangByKhachHang(UUID id) {
        return gioHangChiTietRepository.findGiaHangByKhachHang(id);
    }

    @Override
    public void add(UUID idSP, int soLuong, KhachHangViewModel khachHangViewModel) {

        GioHang gioHang = gioHangService.findByKhachHang(khachHangViewModel.getId());
        ChiTietSPViewModel chiTietSPViewModel = chiTietSPService.findById(idSP);

        gioHangChiTietViewModel.setChiTietSP(chiTietSPConvert.mapToEntity(chiTietSPViewModel)); // ChiTietSP

        gioHangChiTietViewModel.setGioHang(gioHang); // GioHang

        gioHangChiTietViewModel.setSoLuong(soLuong); // SoLuong
        gioHangChiTietViewModel.setDonGia(chiTietSPService.findByGiaBan(idSP)); // DonGia

        int soLuongCu;
        try {
            soLuongCu = gioHangChiTietRepository.findSoLuongByChiTietSPAndGioHang(idSP, gioHang.getId());
        } catch (AopInvocationException e) {
            soLuongCu = 0;
        }

        if (!gioHangChiTietRepository.existsByChiTietSPAndGioHang(idSP, gioHang.getId())) {
            gioHangChiTietRepository.save(gioHangChiTietConvert.mapToEntity(gioHangChiTietViewModel)); // Save
        } else {
            gioHangChiTietViewModel.setSoLuong(soLuong + soLuongCu);
            gioHangChiTietRepository.save(gioHangChiTietConvert.mapToEntity(gioHangChiTietViewModel)); // Save
        }

        chiTietSPService.updateProductQuantity(idSP, soLuong + soLuongCu, soLuongCu);
    }

    @Override
    public void update(UUID idSP, int soLuong, KhachHangViewModel khachHangViewModel) {
        GioHang gioHang = gioHangService.findByKhachHang(khachHangViewModel.getId());
        int soLuongCu;
        try {
            soLuongCu = gioHangChiTietRepository.findSoLuongByChiTietSPAndGioHang(idSP, gioHang.getId());
        } catch (AopInvocationException e) {
            soLuongCu = 0;
        }

        gioHangChiTietRepository.updateGioHangChiTietByChiTietSPAndGioHang(idSP, gioHang.getId(), soLuong);

        chiTietSPService.updateProductQuantity(idSP, soLuong, soLuongCu);
    }

    @Transactional
    @Override
    public void delete(UUID idSP, KhachHangViewModel khachHangViewModel) {
        GioHang gioHang = gioHangService.findByKhachHang(khachHangViewModel.getId());
        int soLuongCu;
        try {
            soLuongCu = gioHangChiTietRepository.findSoLuongByChiTietSPAndGioHang(idSP, gioHang.getId());
        } catch (AopInvocationException e) {
            soLuongCu = 0;
        }
        chiTietSPService.updateProductQuantityByDeleteGioHang(idSP, soLuongCu);
        gioHangChiTietRepository.deleteGioHangChiTietByChiTietSPAndGioHang(idSP, gioHang.getId());
    }

    @Override
    public void deleteGioHangChiTietByGioHang(UUID id) {
        gioHangChiTietRepository.deleteGioHangChiTietByGioHang(id);
    }

    @Override
    public List<GioHangChiTiet> findGioHangChiTietByKhachHang(UUID id) {
        return gioHangChiTietRepository.findGioHangChiTietByKhachHang(id);
    }

    @Override
    public int index(UUID id) {
        return gioHangChiTietRepository.index(id);
    }
}
