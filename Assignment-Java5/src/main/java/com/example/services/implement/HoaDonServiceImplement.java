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
import java.sql.Time;
import java.sql.Timestamp;

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
}
