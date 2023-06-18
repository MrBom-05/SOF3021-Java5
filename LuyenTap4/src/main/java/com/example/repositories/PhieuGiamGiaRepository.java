package com.example.repositories;

import com.example.entities.PhieuGiamGia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface PhieuGiamGiaRepository extends JpaRepository<PhieuGiamGia, String> {

    @Query("select p from PhieuGiamGia p where p.nguoiSoHuu.id = ?1")
    Page<PhieuGiamGia> findByNguoiSoHuu(String maKhachHang, Pageable pageable);

    @Query("select p from PhieuGiamGia p where p.ngayBatDau >= ?1 and p.ngayKetThuc <= ?2")
    Page<PhieuGiamGia> findByKhoangNgay(Date ngayBatDau, Date ngayKetThuc, Pageable pageable);

    @Query("select p from PhieuGiamGia p where p.ngayBatDau >= ?1 and p.ngayKetThuc <= ?2 and p.nguoiSoHuu.id = ?3")
    Page<PhieuGiamGia> findByKhoangNgayAndNguoiSoHuu(Date ngayBatDau, Date ngayKetThuc, String maKhachHang, Pageable pageable);
}
