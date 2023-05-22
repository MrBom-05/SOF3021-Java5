package com.example.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "nhan_vien")
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "ma", columnDefinition = "VARCHAR(20)", unique = true)
    private String ma;

    @Column(name = "ten", columnDefinition = "NVARCHAR(30)")
    private String ten;

    @Column(name = "ten_dem", columnDefinition = "NVARCHAR(30)")
    private String tenDem;

    @Column(name = "ho", columnDefinition = "NVARCHAR(30)")
    private String ho;

    @Column(name = "gioi_tinh", columnDefinition = "NVARCHAR(10)")
    private String gioiTinh;

    @Column(name = "ngay_sinh")
    private Date ngaySinh;

    @Column(name = "dia_chi", columnDefinition = "NVARCHAR(100)")
    private String diaChi;

    @Column(name = "sdt", columnDefinition = "VARCHAR(30)")
    private String sdt;

    @Column(name = "mat_khau", columnDefinition = "VARCHAR(MAX)")
    private String matKhau;

    @Column(name = "email", columnDefinition = "VARCHAR(MAX)")
    private String email;

    @ManyToOne
    @JoinColumn(name = "idch")
    private CuaHang cuaHang;

    @ManyToOne
    @JoinColumn(name = "idcv")
    private ChucVu chucVu;

    @Column(name = "trang_thai")
    private int trangThai;

}
