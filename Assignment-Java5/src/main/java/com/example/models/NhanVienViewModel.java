package com.example.models;

import com.example.entities.ChucVu;
import com.example.entities.CuaHang;
import com.example.entities.NhanVien;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class NhanVienViewModel {
    private UUID id;
    private String ma;
    private String ten;
    private String tenDem;
    private String ho;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String sdt;
    private String matKhau;
    private String email;
    private CuaHang cuaHang;
    private ChucVu chucVu;
    private int trangThai;
}
