package com.example.models;

import com.example.entities.ChiTietSP;
import com.example.entities.GioHang;
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
public class GioHangChiTietViewModel {
    private GioHang gioHang;
    private ChiTietSP chiTietSP;
    private int soLuong;
    private BigDecimal donGia;
}
