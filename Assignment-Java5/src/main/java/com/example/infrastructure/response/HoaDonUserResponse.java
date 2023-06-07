package com.example.infrastructure.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class HoaDonUserResponse {
    private UUID id;
    private String ma;
    private int trangThai;
    private String tenKH;
    private String sdt;
    private String diaChi;
    private BigDecimal tongTien;

    public String getTrangThai() {
        if (trangThai == 1) {
            return "Đã Ship";
        } else if (trangThai == 2) {
            return "Đã Nhận";
        } else if (trangThai == 3) {
            return "Đã Thanh Toán";
        } else if (trangThai == 4){
            return "Đã Hủy";
        }
        return "Chưa Thanh Toán";
    }
}
