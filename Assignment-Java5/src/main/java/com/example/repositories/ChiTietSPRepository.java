package com.example.repositories;

import com.example.entities.ChiTietSP;
import com.example.infrastructure.response.ChiTietSPResponse;
import com.example.infrastructure.response.SanPhamResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChiTietSPRepository extends JpaRepository<ChiTietSP, UUID> {
    @Query("select new com.example.infrastructure.response.ChiTietSPResponse(ctsp.sanPham, ctsp.giaBan) from ChiTietSP ctsp")
    public List<ChiTietSPResponse> findAllHomeByChiTietSP();


    @Query("select new com.example.infrastructure.response.SanPhamResponse(ctsp.sanPham, ctsp.id, ctsp.soLuongTon, ctsp.giaBan) from ChiTietSP ctsp where ctsp.sanPham.id = ?1")
    public SanPhamResponse findBySanPhamResponse(UUID id);
}
