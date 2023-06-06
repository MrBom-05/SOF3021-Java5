package com.example.repositories;

import com.example.entities.GioHangChiTiet;
import com.example.infrastructure.primary.GioHangChiTietPrimary;
import com.example.infrastructure.response.GioHangResponse;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet, GioHangChiTietPrimary> {
    @Query("SELECT new com.example.infrastructure.response.GioHangResponse(ghct.chiTietSP.id, ghct.chiTietSP.sanPham, ghct.chiTietSP.mauSac, ghct.soLuong, ghct.donGia) FROM GioHangChiTiet ghct WHERE ghct.gioHang.khachHang.id=:id")
    public List<GioHangResponse> findGiaHangByKhachHang(@Param("id") UUID id);

    @Query("select case when count(ghct) > 0 then true else false end from GioHangChiTiet ghct where ghct.chiTietSP.id=:idSP and ghct.gioHang.id=:idGH")
    public boolean existsByChiTietSPAndGioHang(UUID idSP, UUID idGH);

    @Query("select ghct.soLuong from GioHangChiTiet ghct where ghct.chiTietSP.id=:idSP and ghct.gioHang.id=:idGH")
    public int findSoLuongByChiTietSPAndGioHang(UUID idSP, UUID idGH);

    @Transactional
    @Modifying
    @Query("delete from GioHangChiTiet ghct where ghct.chiTietSP.id=:idSP and ghct.gioHang.id=:idGH")
    public void deleteGioHangChiTietByChiTietSPAndGioHang(UUID idSP, UUID idGH);
}
