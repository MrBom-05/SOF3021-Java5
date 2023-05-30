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
@Table
public class KhachHang implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "Ma", columnDefinition = "Varchar(20)", unique = true)
    private String ma;

    @Column(name = "Ten", columnDefinition = "Nvarchar(30)")
    private String ten;

    @Column(name = "TenDem", columnDefinition = "Nvarchar(30)")
    private String tenDem;

    @Column(name = "Ho", columnDefinition = "Nvarchar(30)")
    private String ho;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "DiaChi", columnDefinition = "Nvarchar(100)")
    private String diaChi;

    @Column(name = "ThanhPho", columnDefinition = "Nvarchar(50)")
    private String thanhPho;

    @Column(name = "QuocGia", columnDefinition = "Nvarchar(50)")
    private String quocGia;

    @Column(name = "Sdt", columnDefinition = "Varchar(30)")
    private String sdt;

    @Column(name = "MatKhau", columnDefinition = "Varchar(MAX)")
    private String matKhau;

    @Column(name = "Email", columnDefinition = "Varchar(MAX)")
    private String email;

    @OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY)
    private List<GioHang> listGioHang;

    @OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY)
    private List<HoaDon> listHoaDon;
}
