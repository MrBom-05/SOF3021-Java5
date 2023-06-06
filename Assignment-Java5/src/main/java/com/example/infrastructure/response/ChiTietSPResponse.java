package com.example.infrastructure.response;

import com.example.entities.SanPham;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@Component

public class ChiTietSPResponse {
    private SanPham sanPham;
    private BigDecimal giaBan;
}
