package com.example.entities;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CuaHang {

    private UUID id;

    @NotEmpty(message = "Không được để trống")
    private String ma;

    @NotEmpty(message = "Không được để trống")
    private String ten;

    @NotEmpty(message = "Không được để trống")
    private String diaChi;

    @NotEmpty(message = "Không được để trống")
    private String thanhPho;

    @NotEmpty(message = "Không được để trống")
    private String quocGia;
}
