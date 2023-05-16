package com.example.entities;

import jakarta.persistence.*;
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

    private String ma;

    private String ten;

    private String diaChi;

    private String thanhPho;

    private String quocGia;
}
