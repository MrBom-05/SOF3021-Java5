package com.example.models;

import com.example.entities.ChucVu;
import com.example.entities.CuaHang;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@Component
public class NhanVienViewModel {
    private UUID id;
    private String ma;
    @Size(max = 30, message = "Tên không được quá 30 ký tự")
    @NotBlank(message = "Tên không được để trống")
    private String ten;
    @Size(max = 30, message = "Tên đệm không được quá 30 ký tự")
    @NotBlank(message = "Tên đệm không được để trống")
    private String tenDem;
    @Size(max = 30, message = "Họ không được quá 30 ký tự")
    @NotBlank(message = "Họ không được để trống")
    private String ho;
    private String gioiTinh;
    @Past(message = "Ngày sinh phải là ngày trong quá khứ")
    private Date ngaySinh;
    @Size(max = 100, message = "Địa chỉ không được quá 100 ký tự")
    @NotBlank(message = "Địa chỉ không được để trống")
    private String diaChi;
    @Size(max = 10, message = "Số điện thoại không được quá 10 ký tự")
    @NotBlank(message = "Số điện thoại không được để trống")
    private String sdt;
    @Size(max = 20, message = "Mật khẩu không được quá 20 ký tự")
    @NotBlank(message = "Mật khẩu không được để trống")
    private String matKhau;
    @Email(message = "Email không đúng định dạng")
    @Size(max = 50, message = "Email không được quá 50 ký tự")
    @NotBlank(message = "Email không được để trống")
    private String email;
    @NotNull(message = "Cửa hàng không được để trống")
    private CuaHang cuaHang;
    @NotNull(message = "Chức vụ không được để trống")
    private ChucVu chucVu;
    private int trangThai;
}
