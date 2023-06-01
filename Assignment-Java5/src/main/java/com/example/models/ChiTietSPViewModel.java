package com.example.models;

import com.example.entities.DongSP;
import com.example.entities.MauSac;
import com.example.entities.NSX;
import com.example.entities.SanPham;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@Component
public class ChiTietSPViewModel {
    private UUID id;
//    @NotBlank(message = "Bạn chưa chọn sản phẩm")
    private SanPham sanPham;
//    @NotBlank(message = "Bạn chưa chọn nhà sản xuất")
    private NSX nsx;
//    @NotBlank(message = "Bạn chưa chọn màu sắc")
    private MauSac mauSac;
//    @NotBlank(message = "Bạn chưa chọn dòng sản phẩm")
    private DongSP dongSP;
//    @NotBlank(message = "Bạn chưa nhập năm sản xuất")
    private int namSX;
    @NotBlank(message = "Bạn chưa nhập mô tả")
    private String moTa;
//    @NotBlank(message = "Bạn chưa nhập số lượng tồn")
    private int soLuongTon;
//    @NotBlank(message = "Bạn chưa nhập giá nhập")
    private BigDecimal giaNhap;
//    @NotBlank(message = "Bạn chưa nhập giá bán")
    private BigDecimal giaBan;
}
