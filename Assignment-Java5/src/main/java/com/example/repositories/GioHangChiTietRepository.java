package com.example.repositories;

import com.example.entities.GioHangChiTiet;
import com.example.infrastructure.primary.GioHangChiTietPrimary;
import com.example.infrastructure.response.GioHangResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet, GioHangChiTietPrimary> {
    @Query("SELECT new com.example.infrastructure.response.GioHangResponse(ghct.chiTietSP.id, ghct.chiTietSP.sanPham, ghct.chiTietSP.mauSac, ghct.soLuong, ghct.donGia) FROM GioHangChiTiet ghct WHERE ghct.gioHang.khachHang.id=:id")
    public List<GioHangResponse> findGiaHangByKhachHang(@Param("id") UUID id);
}
