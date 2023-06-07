package com.example.entities;

import com.example.infrastructure.primary.HoaDonChiTietPrimary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@IdClass(HoaDonChiTietPrimary.class)
@Component
public class HoaDonChiTiet {

    @Id
    @ManyToOne
    @JoinColumn(name = "idHoaDon")
    private HoaDon hoaDon;

    @Id
    @ManyToOne
    @JoinColumn(name = "idChiTietSP")
    private ChiTietSP chiTietSP;

    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "DonGia", columnDefinition = "Decimal(20,0)")
    private BigDecimal donGia;
}
