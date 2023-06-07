package com.example.services.implement;

import com.example.entities.HoaDon;
import com.example.entities.HoaDonChiTiet;
import com.example.infrastructure.converter.ChiTietSPConvert;
import com.example.infrastructure.converter.HoaDonChiTietConvert;
import com.example.infrastructure.response.HoaDonChiTietResponse;
import com.example.infrastructure.response.HoaDonResponse;
import com.example.infrastructure.response.HoaDonUserResponse;
import com.example.models.ChiTietSPViewModel;
import com.example.models.HoaDonChiTietViewModel;
import com.example.models.KhachHangViewModel;
import com.example.repositories.HoaDonChiTietRepository;
import com.example.services.ChiTietSPService;
import com.example.services.HoaDonChiTietService;
import com.example.services.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HoaDonChiTietServiceImplement implements HoaDonChiTietService {
    @Autowired
    private HoaDonChiTietRepository hoaDonChiTietRepository;

    @Autowired
    private HoaDonService hoaDonService;

    @Autowired
    private ChiTietSPService chiTietSPService;

    @Autowired
    private ChiTietSPViewModel chiTietSPViewModel;

    @Autowired
    private HoaDonChiTiet hoaDonChiTiet;

    @Autowired
    private ChiTietSPConvert chiTietSPConvert;

    @Autowired
    private HoaDonChiTietConvert hoaDonChiTietConvert;

    @Override
    public List<HoaDonResponse> findByKhachHang(UUID id) {
        return hoaDonChiTietRepository.findByKhachHang(id);
    }

    @Override
    public HoaDonUserResponse getByID(UUID id) {
        return hoaDonChiTietRepository.getByID(id);
    }

    @Override
    public List<HoaDonChiTietResponse> getListByID(UUID id) {
        return hoaDonChiTietRepository.getListByID(id);
    }

    @Override
    public void add(UUID idSP, int soLuong, KhachHangViewModel khachHangViewModel) {
        HoaDon hoaDon = hoaDonService.save(khachHangViewModel);
        chiTietSPViewModel.setId(idSP);

        hoaDonChiTiet.setChiTietSP(chiTietSPConvert.mapToEntity(chiTietSPViewModel));
        hoaDonChiTiet.setHoaDon(hoaDon);
        hoaDonChiTiet.setSoLuong(soLuong);
        hoaDonChiTiet.setDonGia(chiTietSPService.findByGiaBan(idSP));

        hoaDonChiTietRepository.save(hoaDonChiTiet);
    }


}
