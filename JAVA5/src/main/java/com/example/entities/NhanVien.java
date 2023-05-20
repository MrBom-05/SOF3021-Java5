package com.example.entities;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NhanVien {
    private UUID id;
    @NotBlank(message = "Không được để trống")
    private String ma;
    @NotBlank(message = "Không được để trống")
    private String ten;
    @NotBlank(message = "Không được để trống")
    private String tenDem;
    @NotBlank(message = "Không được để trống")
    private String ho;
    @NotBlank(message = "Không được để trống")
    private String gioiTinh;
    private Date ngaySinh;
    @NotBlank(message = "Không được để trống")
    private String diaChi;
    @NotBlank(message = "Không được để trống")
    private String sdt;
    @NotBlank(message = "Không được để trống")
    private String matKhau;
    @NotBlank(message = "Không được để trống")
    private String email;
    private Integer trangThai;
    @NotBlank(message = "Không được để trống")
    private String tenCuaHang;
    @NotBlank(message = "Không được để trống")
    private String tenChucVu;


}
