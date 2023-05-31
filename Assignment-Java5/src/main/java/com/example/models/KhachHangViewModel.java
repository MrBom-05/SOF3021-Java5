package com.example.models;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
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
public class KhachHangViewModel {
    private UUID id;
    private String ma;
    @NotBlank(message = "Tên không được để trống")
    private String ten;
    @NotBlank(message = "Tên đệm không được để trống")
    private String tenDem;
    @NotBlank(message = "Họ không được để trống")
    private String ho;
    private Date ngaySinh;
    @NotBlank(message = "Địa chỉ không được để trống")
    private String diaChi;
    @NotBlank(message = "Thành phố không được để trống")
    private String thanhPho;
    @NotBlank(message = "Quốc gia không được để trống")
    private String quocGia;
    @NotBlank(message = "Số điện thoại không được để trống")
    private String sdt;
    @NotBlank(message = "Mật khẩu không được để trống")
    private String matKhau;
    @NotBlank(message = "Email không được để trống")
    private String email;
}
