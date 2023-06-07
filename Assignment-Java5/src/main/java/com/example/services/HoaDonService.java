package com.example.services;

import com.example.entities.HoaDon;
import com.example.models.KhachHangViewModel;

import java.util.UUID;

public interface HoaDonService {
    public HoaDon save(KhachHangViewModel khachHangViewModel);
}
