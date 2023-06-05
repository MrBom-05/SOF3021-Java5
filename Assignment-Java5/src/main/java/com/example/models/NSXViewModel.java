package com.example.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@Component
public class NSXViewModel {
    private UUID id;
    private String ma;
    @Size(max = 50, message = "Tên không được quá 50 ký tự")
    @NotBlank(message = "Tên không được để trống")
    private String ten;
}
