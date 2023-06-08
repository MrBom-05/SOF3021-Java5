package com.example.repositories;

import com.example.entities.HoaDonChiTiet;
import com.example.infrastructure.primary.HoaDonChiTietPrimary;
import com.example.infrastructure.response.HoaDonChiTietResponse;
import com.example.infrastructure.response.HoaDonResponse;
import com.example.infrastructure.response.HoaDonUserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HoaDonChiTietRepository<S extends HoaDonChiTiet> extends JpaRepository<S, HoaDonChiTietPrimary> {

    @Query("select new com.example.infrastructure.response.HoaDonResponse" +
            "(hdct.hoaDon.id, hdct.hoaDon.ma, hdct.hoaDon.ngayTao, count(hdct), sum(hdct.donGia), hdct.hoaDon.trangThai)" +
            " from com.example.entities.HoaDonChiTiet hdct left join hdct.hoaDon hd " +
            "left join hdct.chiTietSP ctdp where hdct.hoaDon.khachHang.id=:id " +
            "group by hdct.hoaDon.id, hdct.hoaDon.ma, hdct.hoaDon.ngayTao, hdct.hoaDon.trangThai")
    public List<HoaDonResponse> findByKhachHang(@Param("id") UUID id);

    @Query("select new com.example.infrastructure.response.HoaDonUserResponse" +
            "(hdct.hoaDon.id, hdct.hoaDon.ma, hdct.hoaDon.trangThai, hdct.hoaDon.khachHang.ten, " +
            "hdct.hoaDon.khachHang.sdt, hdct.hoaDon.khachHang.diaChi, sum(hdct.donGia * hdct.soLuong)) " +
            "from com.example.entities.HoaDonChiTiet hdct left join hdct.hoaDon hd " +
            "where hdct.hoaDon.id=:id group by hdct.hoaDon.id, hdct.hoaDon.ma, " +
            "hdct.hoaDon.ngayTao, hdct.hoaDon.trangThai, hdct.hoaDon.khachHang.ten, " +
            "hdct.hoaDon.khachHang.sdt, hdct.hoaDon.khachHang.diaChi")
    public HoaDonUserResponse getByID(@Param("id") UUID id);

    @Query("select new com.example.infrastructure.response.HoaDonChiTietResponse" +
            "(hdct.chiTietSP.sanPham, hdct.chiTietSP.mauSac, hdct.donGia, hdct.soLuong)" +
            " from com.example.entities.HoaDonChiTiet hdct left join hdct.chiTietSP.sanPham spm " +
            "left join hdct.chiTietSP.mauSac ms where hdct.hoaDon.id=:id")
    public List<HoaDonChiTietResponse> getListByID(@Param("id") UUID id);
}
