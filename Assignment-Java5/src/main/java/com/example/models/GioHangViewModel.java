package com.example.models;

import com.example.entities.KhachHang;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@Component
public class GioHangViewModel {
    private UUID id;
    private KhachHang khachHang;
    private String idNV;
    private String ma;
    private Date ngayTao;
    private Date ngayThanhToan;
    private String tenNguoiNhan;
    private String diaChi;
    private String sdt;
    private int trangThai;
}
