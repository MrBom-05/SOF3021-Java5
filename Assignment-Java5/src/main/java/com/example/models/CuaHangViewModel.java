package com.example.models;


import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Tên không được để trống")
    private String ten;
    @NotBlank(message = "Địa chỉ không được để trống")
    private String diaChi;
    @NotBlank(message = "Thành phố không được để trống")
    private String thanhPho;
    @NotBlank(message = "Quốc gia không được để trống")
    private String quocGia;
}
