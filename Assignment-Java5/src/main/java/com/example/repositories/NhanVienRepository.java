package com.example.repositories;

import com.example.entities.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {
    @Query("SELECT nv FROM NhanVien nv WHERE nv.email=:email and nv.matKhau=:matKhau")
    public NhanVien login(@Param("email") String email, @Param("matKhau") String matKhau);
}
