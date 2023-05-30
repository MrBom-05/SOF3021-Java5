package com.example.models;

import jakarta.validation.constraints.NotBlank;
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
public class ChucVuViewModel {
    private UUID id;

    private String ma;

    @NotBlank(message = "Tên chức vụ không được để trống")
    private String ten;
}
