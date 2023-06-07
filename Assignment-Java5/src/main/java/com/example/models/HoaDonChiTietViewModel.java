package com.example.models;

import com.example.entities.ChiTietSP;
import com.example.entities.HoaDon;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@Component
public class HoaDonChiTietViewModel {
    private HoaDon hoaDon;
    private ChiTietSP chiTietSP;
    private int soLuong;
    private BigDecimal donGia;
}
