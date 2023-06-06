package com.example.repositories;

import com.example.entities.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GioHangRepository extends JpaRepository<GioHang, UUID> {
    @Query("select case when count(gh) > 0 then true else false end from GioHang gh where gh.khachHang.id=:id")
    public boolean existsByKhachHang(@Param("id") UUID id);
}
