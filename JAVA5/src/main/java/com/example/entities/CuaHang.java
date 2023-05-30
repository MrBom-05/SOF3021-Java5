package com.example.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CuaHang")
public class CuaHang {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    @NotBlank(message = "Id không được để trống")
    private UUID id;

    @Column(name = "Ma", columnDefinition = "Varchar(20)", unique = true)
    @NotBlank(message = "Mã không được để trống")
    private String ma;

    @Column(name = "Ten", columnDefinition = "Nvarchar(MAX)")
    @NotBlank(message = "Tên không được để trống")
    private String ten;

    @Column(name = "DiaChi", columnDefinition = "Nvarchar(MAX)")
    @NotBlank(message = "Địa chỉ không được để trống")
    private String diaChi;

    @Column(name = "ThanhPho", columnDefinition = "Nvarchar(MAX)")
    @NotBlank(message = "Thành phố không được để trống")
    private String thanhPho;

    @Column(name = "QuocGia", columnDefinition = "Nvarchar(MAX)")
    @NotBlank(message = "Quốc gia không được để trống")
    private String quocGia;
}
