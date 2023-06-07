package com.example.models;

import com.example.entities.KhachHang;
import com.example.entities.NhanVien;
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
public class HoaDonViewModel {
    private UUID id;
    private KhachHang khachHang;
    private NhanVien nhanVien;
    private String ma;
    private Date ngayTao;
    private Date ngayThanhToan;
    private Date ngayShip;
    private Date ngayNhan;
    private int trangThai;
    private String tenNguoiNhan;
    private String diaChi;
    private String sdt;
}
