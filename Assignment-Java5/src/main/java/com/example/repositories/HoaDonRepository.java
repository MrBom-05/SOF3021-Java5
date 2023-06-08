package com.example.repositories;

import com.example.entities.HoaDon;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.UUID;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, UUID> {

    @Query("select hd from HoaDon hd where hd.khachHang.id=:id")
    public HoaDon findHoaDonByKhachHang(@Param("id") UUID id);

    @Transactional
    @Modifying
    @Query("update HoaDon hd set hd.trangThai=:trangThai where hd.id=:id")
    public void updateHuy(@Param("id") UUID id, @Param("trangThai") int trangThai);

    @Transactional
    @Modifying
    @Query("update HoaDon hd set hd.trangThai=:trangThai, hd.ngayShip=:ngayShip  where hd.id=:id")
    public void updateNgayShip(@Param("id") UUID id, @Param("trangThai") int trangThai, @Param("ngayShip") Date ngayShip);

    @Transactional
    @Modifying
    @Query("update HoaDon hd set hd.trangThai=:trangThai, hd.ngayNhan=:ngayNhan  where hd.id=:id")
    public void updateNgayNhan(@Param("id") UUID id, @Param("trangThai") int trangThai, @Param("ngayNhan") Date ngayNhan);

    @Transactional
    @Modifying
    @Query("update HoaDon hd set hd.trangThai=:trangThai, hd.ngayThanhToan=:ngayThanhToan  where hd.id=:id")
    public void updateNgayThanhToan(@Param("id") UUID id, @Param("trangThai") int trangThai, @Param("ngayThanhToan") Date ngayThanhToan);
}
