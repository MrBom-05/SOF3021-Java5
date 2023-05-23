package com.example.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
@Table(name = "cua_hang")
public class CuaHang {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "ma", columnDefinition = "VARCHAR(20)", unique = true)
    private String ma;

    @NotEmpty(message = "Không được để trống")
    @Column(name = "ten", columnDefinition = "NVARCHAR(MAX)")
    private String ten;

    @NotEmpty(message = "Không được để trống")
    @Column(name = "dia_chi", columnDefinition = "NVARCHAR(MAX)")
    private String diaChi;

    @NotEmpty(message = "Không được để trống")
    @Column(name = "thanh_pho", columnDefinition = "NVARCHAR(MAX)")
    private String thanhPho;

    @NotEmpty(message = "Không được để trống")
    @Column(name = "quoc_gia", columnDefinition = "NVARCHAR(MAX)")
    private String quocGia;
}
