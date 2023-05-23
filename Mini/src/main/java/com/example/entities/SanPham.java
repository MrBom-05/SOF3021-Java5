package com.example.entities;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@Table(name = "san_pham")
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "ma", columnDefinition = "VARCHAR(20)", unique = true)
    private String ma;

    @Column(name = "ten", columnDefinition = "NVARCHAR(30)")
    private String ten;

    @Column(name = "anh", columnDefinition = "NVARCHAR(max)")
    private String anh;
}
