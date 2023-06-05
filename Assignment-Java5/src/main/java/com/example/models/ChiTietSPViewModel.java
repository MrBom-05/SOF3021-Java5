package com.example.models;

import com.example.entities.DongSP;
import com.example.entities.MauSac;
import com.example.entities.NSX;
import com.example.entities.SanPham;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotNull(message = "Bạn chưa chọn sản phẩm")
    private SanPham sanPham;
    @NotNull(message = "Bạn chưa chọn nhà sản xuất")
    private NSX nsx;
    @NotNull(message = "Bạn chưa chọn màu sắc")
    private MauSac mauSac;
    @NotNull(message = "Bạn chưa chọn dòng sản phẩm")
    private DongSP dongSP;
//    @NotBlank(message = "Bạn chưa nhập năm sản xuất")
    private int namSX;
    @Size(max = 50, message = "Mô tả không được quá 50 ký tự")
    @NotBlank(message = "Bạn chưa nhập mô tả")
    private String moTa;
//    @NotBlank(message = "Bạn chưa nhập số lượng tồn")
    private int soLuongTon;
//    @NotBlank(message = "Bạn chưa nhập giá nhập")
    private BigDecimal giaNhap;
//    @NotBlank(message = "Bạn chưa nhập giá bán")
    private BigDecimal giaBan;
}
