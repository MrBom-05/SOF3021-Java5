package com.example.entities;

import com.example.infrastructure.primary.GioHangChiTietPrimary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@IdClass(GioHangChiTietPrimary.class)
public class GioHangChiTiet {

    @Id
    @ManyToOne
    @JoinColumn(name = "idGioHang")
    private GioHang gioHang;

    @Id
    @ManyToOne
    @JoinColumn(name = "idChiTietSP")
    private ChiTietSP chiTietSP;

    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "DonGia", columnDefinition = "Decimal(20,0)")
    private BigDecimal donGia;

    @Column(name = "DonGiaKhiGiam", columnDefinition = "Decimal(20,0)")
    private BigDecimal donGiaKhiGiam;
}
