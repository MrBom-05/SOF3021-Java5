package com.example.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "PhieuGiamGia")
@Component
public class PhieuGiamGia {
    @Id
    @Size(max = 10)
    @Column(name = "MaPhieu", nullable = false, length = 10)
    private String maPhieu;

    @Size(max = 20, message = "Tên phiếu không được quá 20 ký tự")
    @Nationalized
    @Column(name = "TenPhieu", length = 20)
    @NotBlank(message = "Tên phiếu không được để trống")
    private String tenPhieu;

    @Column(name = "NgayBatDau")
    @NotNull(message = "Ngày bắt đầu không được để trống")
    private Date ngayBatDau;

    @Column(name = "NgayKetThuc")
    @NotNull(message = "Ngày kết thúc không được để trống")
    private Date ngayKetThuc;

    @Column(name = "GiaTriGiam")
    @NotNull(message = "Giá trị giảm không được để trống")
    private BigDecimal giaTriGiam;

    @Column(name = "GiaTriGiamToiDa")
    @NotNull(message = "Giá trị giảm tối đa không được để trống")
    private BigDecimal giaTriGiamToiDa;

    @Column(name = "HinhThucGiam")
    private Boolean hinhThucGiam;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NguoiSoHuu")
    @NotNull(message = "Người sở hữu không được để trống")
    private KhachHang nguoiSoHuu;

}