package com.example.models;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@Component
public class CuaHangViewModel {
    private UUID id;
    private String ma;
    @Size(max = 50, message = "Tên không được quá 50 ký tự")
    @NotBlank(message = "Tên không được để trống")
    private String ten;
    @Size(max = 100, message = "Địa chỉ không được quá 100 ký tự")
    @NotBlank(message = "Địa chỉ không được để trống")
    private String diaChi;
    @Size(max = 50, message = "Thành phố không được quá 50 ký tự")
    @NotBlank(message = "Thành phố không được để trống")
    private String thanhPho;
    @Size(max = 50, message = "Quốc gia không được quá 50 ký tự")
    @NotBlank(message = "Quốc gia không được để trống")
    private String quocGia;
}
