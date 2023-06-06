package com.example.infrastructure.response;

import com.example.entities.MauSac;
import com.example.entities.SanPham;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@Component
public class GioHangResponse {
    private UUID id;
    private SanPham sanPham;
    private MauSac mauSac;
    private int soLuong;
    private BigDecimal giaBan;
}
