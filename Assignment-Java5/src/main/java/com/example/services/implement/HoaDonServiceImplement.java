package com.example.services.implement;

import com.example.entities.HoaDon;
import com.example.infrastructure.converter.HoaDonConvert;
import com.example.infrastructure.converter.KhachHangConvert;
import com.example.models.HoaDonViewModel;
import com.example.models.KhachHangViewModel;
import com.example.repositories.HoaDonRepository;
import com.example.services.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

import java.sql.Date;
@Service
public class HoaDonServiceImplement implements HoaDonService {
    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Autowired
    private HoaDonConvert hoaDonConvert;

    @Autowired
    private KhachHangConvert khachHangConvert;

    @Autowired
    private HoaDonViewModel hoaDonViewModel;

    private SerialNumberGenerator serialNumberGenerator = new SerialNumberGenerator();

    private Date getDateNow() {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        return date;
    }

    @Override
    public HoaDon save(KhachHangViewModel khachHangViewModel) {
        hoaDonViewModel.setMa(serialNumberGenerator.generateSerialNumber());
        hoaDonViewModel.setKhachHang(khachHangConvert.mapToEntity(khachHangViewModel));
        hoaDonViewModel.setNgayTao(getDateNow());

        HoaDon hoaDon = hoaDonRepository.save(hoaDonConvert.mapToEntity(hoaDonViewModel));
        System.out.println(hoaDon.getId());
        return hoaDon;
    }

    @Override
    public HoaDon findHoaDonByKhachHang(UUID id) {
        return hoaDonRepository.findHoaDonByKhachHang(id);
    }

    @Override
    public void update(UUID id, int trangThai) {
        if (trangThai == 4){
            hoaDonRepository.updateHuy(id, 4);
        } else if (trangThai == 3){
            hoaDonRepository.updateNgayThanhToan(id, 3, getDateNow());
        } else if (trangThai == 2){
            hoaDonRepository.updateNgayNhan(id, 2, getDateNow());
        } else {
            hoaDonRepository.updateNgayShip(id, 1, getDateNow());
        }
    }
}
