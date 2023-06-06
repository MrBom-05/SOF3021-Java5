package com.example.repositories;

import com.example.entities.ChiTietSP;
import com.example.infrastructure.response.ChiTietSPResponse;
import com.example.infrastructure.response.SanPhamResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface ChiTietSPRepository extends JpaRepository<ChiTietSP, UUID> {
    @Query("select new com.example.infrastructure.response.ChiTietSPResponse(ctsp.sanPham, ctsp.giaBan) from ChiTietSP ctsp")
    public List<ChiTietSPResponse> findAllHomeByChiTietSP();


    @Query("select new com.example.infrastructure.response.SanPhamResponse(ctsp.sanPham, ctsp.id, ctsp.soLuongTon, ctsp.giaBan) from ChiTietSP ctsp where ctsp.sanPham.id = ?1")
    public SanPhamResponse findBySanPhamResponse(UUID id);

    @Query("select ctsp.giaBan from ChiTietSP ctsp where ctsp.id=:id")
    public BigDecimal findByGiaBan(@Param("id") UUID id);
}
