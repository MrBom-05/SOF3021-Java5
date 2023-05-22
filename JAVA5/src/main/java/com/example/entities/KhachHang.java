package com.example.entities;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class KhachHang {

    @NotEmpty(message = "Không được để trống")
    private String ma;
    @NotEmpty(message = "Không được để trống")
    private String ten;
    @NotEmpty(message = "Không được để trống")
    private String tenDem;
    @NotEmpty(message = "Không được để trống")
    private String ho;
    private Date ngaySinh;
    @NotEmpty(message = "Không được để trống")
    private String diaChi;
    @NotEmpty(message = "Không được để trống")
    private String thanhPho;
    @NotEmpty(message = "Không được để trống")
    private String quocGia;
    @NotEmpty(message = "Không được để trống")
    private String sdt;
    @NotEmpty(message = "Không được để trống")
    private String email;
}
