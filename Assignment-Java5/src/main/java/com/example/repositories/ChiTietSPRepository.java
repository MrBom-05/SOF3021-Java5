package com.example.repositories;

import com.example.entities.ChiTietSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChiTietSPRepository extends JpaRepository<ChiTietSP, UUID> {
}
