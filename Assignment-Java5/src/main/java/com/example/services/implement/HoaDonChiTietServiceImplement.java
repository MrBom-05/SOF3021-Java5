package com.example.services.implement;

import com.example.entities.GioHang;
import com.example.entities.GioHangChiTiet;
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
import com.example.services.*;
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
    private GioHangService gioHangService;

    @Autowired
    private GioHangChiTietService gioHangChiTietService;

    @Autowired
    private ChiTietSPViewModel chiTietSPViewModel;

    @Autowired
    private HoaDonChiTiet hoaDonChiTiet;

    @Autowired
    private ChiTietSPConvert chiTietSPConvert;

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

        gioHangChiTietService.delete(idSP, khachHangViewModel);
    }

    @Override
    public void addAll(KhachHangViewModel khachHangViewModel) {
        HoaDon hoaDon = hoaDonService.save(khachHangViewModel);

        List<GioHangChiTiet> list = gioHangChiTietService.findGioHangChiTietByKhachHang(khachHangViewModel.getId());
        for (GioHangChiTiet gioHangChiTiet : list) {
            chiTietSPViewModel.setId(gioHangChiTiet.getChiTietSP().getId());

            hoaDonChiTiet.setChiTietSP(chiTietSPConvert.mapToEntity(chiTietSPViewModel));
            hoaDonChiTiet.setHoaDon(hoaDon);
            hoaDonChiTiet.setSoLuong(gioHangChiTiet.getSoLuong());
            hoaDonChiTiet.setDonGia(gioHangChiTiet.getDonGia());

            hoaDonChiTietRepository.save(hoaDonChiTiet);
        }

        GioHang gioHang = gioHangService.findByKhachHang(khachHangViewModel.getId());
        gioHangChiTietService.deleteGioHangChiTietByGioHang(gioHang.getId());
    }


}
