package com.example.infrastructure.primary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@Component
public class GioHangChiTietPrimary implements Serializable {
    private UUID gioHang;
    private UUID chiTietSP;
}
