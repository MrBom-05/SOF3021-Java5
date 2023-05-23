package com.example.entities;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@Table(name = "khach_hang")
public class KhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "ma", columnDefinition = "VARCHAR(20)", unique = true)
    private String ma;

    @NotEmpty(message = "Không được để trống")
    @Column(name = "ten", columnDefinition = "NVARCHAR(30)")
    private String ten;

    @NotEmpty(message = "Không được để trống")
    @Column(name = "ten_dem", columnDefinition = "NVARCHAR(30)")
    private String tenDem;

    @NotEmpty(message = "Không được để trống")
    @Column(name = "ho", columnDefinition = "NVARCHAR(30)")
    private String ho;

    @Column(name = "ngay_sinh")
    private Date ngaySinh;

    @NotEmpty(message = "Không được để trống")
    @Column(name = "dia_chi", columnDefinition = "NVARCHAR(100)")
    private String diaChi;

    @NotEmpty(message = "Không được để trống")
    @Column(name = "thanh_pho", columnDefinition = "NVARCHAR(50)")
    private String thanhPho;

    @NotEmpty(message = "Không được để trống")
    @Column(name = "quoc_gia", columnDefinition = "NVARCHAR(50)")
    private String quocGia;

    @NotEmpty(message = "Không được để trống")
    @Column(name = "sdt", columnDefinition = "VARCHAR(30)")
    private String sdt;

    @NotEmpty(message = "Không được để trống")
    @Column(name = "mat_khau", columnDefinition = "VARCHAR(MAX)")
    private String matKhau;

    @NotEmpty(message = "Không được để trống")
    @Column(name = "email", columnDefinition = "VARCHAR(MAX)")
    private String email;

}
