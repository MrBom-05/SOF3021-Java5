INSERT INTO HangKhachHang
    (TenHang, MoTa, DiemToiThieu, TrangThai)
VALUES
    ('Hàng 1', 'Mô tả hàng 1', 100, 1);

INSERT INTO HangKhachHang
    (TenHang, MoTa, DiemToiThieu, TrangThai)
VALUES
    ('Hàng 2', 'Mô tả hàng 2', 200, 1);

INSERT INTO KhachHang
    (TenKhachHang, SinhNhat, DiaChi, SoDienThoai, Email, GioiTinh, ChungMinhThu, SoCanCuoc, AnhDaiDien, TrangThai, DiemTichLuy, HangKhachHang, NguoiGioiThieu)
VALUES
    ('Người 1', '1990-01-01', 'Địa chỉ 1', '123456789', 'email1@example.com', 1, '1234567890', '1234567890', 'anh1.jpg', 1, 0, 1, NULL)

INSERT INTO KhachHang
    (TenKhachHang, SinhNhat, DiaChi, SoDienThoai, Email, GioiTinh, ChungMinhThu, SoCanCuoc, AnhDaiDien, TrangThai, DiemTichLuy, HangKhachHang, NguoiGioiThieu)
VALUES
    ('Người 2', '1995-02-02', 'Địa chỉ 2', '987654321', 'email2@example.com', 0, '0987654321', '0987654321', 'anh2.jpg', 1, 0, 2, NULL)

INSERT INTO KhachHang
    (TenKhachHang, SinhNhat, DiaChi, SoDienThoai, Email, GioiTinh, ChungMinhThu, SoCanCuoc, AnhDaiDien, TrangThai, DiemTichLuy, HangKhachHang, NguoiGioiThieu)
VALUES
    ('Người 3', '1990-01-01', 'Địa chỉ 1', '123456789', 'email1@example.com', 1, '1234567890', '1234567890', 'anh1.jpg', 1, 0, 1, NULL)

INSERT INTO KhachHang
    (TenKhachHang, SinhNhat, DiaChi, SoDienThoai, Email, GioiTinh, ChungMinhThu, SoCanCuoc, AnhDaiDien, TrangThai, DiemTichLuy, HangKhachHang, NguoiGioiThieu)
VALUES
    ('Người 4', '1995-02-02', 'Địa chỉ 2', '987654321', 'email2@example.com', 0, '0987654321', '0987654321', 'anh2.jpg', 1, 0, 2, NULL)

INSERT INTO KhachHang
    (TenKhachHang, SinhNhat, DiaChi, SoDienThoai, Email, GioiTinh, ChungMinhThu, SoCanCuoc, AnhDaiDien, TrangThai, DiemTichLuy, HangKhachHang, NguoiGioiThieu)
VALUES
    ('Người 5', '1990-01-01', 'Địa chỉ 1', '123456789', 'email1@example.com', 1, '1234567890', '1234567890', 'anh1.jpg', 1, 0, 1, NULL)

INSERT INTO KhachHang
    (TenKhachHang, SinhNhat, DiaChi, SoDienThoai, Email, GioiTinh, ChungMinhThu, SoCanCuoc, AnhDaiDien, TrangThai, DiemTichLuy, HangKhachHang, NguoiGioiThieu)
VALUES
    ('Người 6', '1995-02-02', 'Địa chỉ 2', '987654321', 'email2@example.com', 0, '0987654321', '0987654321', 'anh2.jpg', 1, 0, 2, NULL)

INSERT INTO TheThanhVien
    (MaThe, MauThe, LoaiThe, NgayPhatHanh, NgayHuy, TrangThai, NguoiSoHuu)
VALUES
    ('The1', 'Màu 1', 'Loại 1', '2023-01-01', NULL, 1, 1);

INSERT INTO TheThanhVien
    (MaThe, MauThe, LoaiThe, NgayPhatHanh, NgayHuy, TrangThai, NguoiSoHuu)
VALUES
    ('The2', 'Màu 2', 'Loại 2', '2023-02-02', NULL, 1, 2);

INSERT INTO PhieuGiamGia
    (MaPhieu, TenPhieu, NgayBatDau, NgayKetThuc, GiaTriGiam, GiaTriGiamToiDa, HinhThucGiam, TrangThai, NguoiSoHuu)
VALUES
    ('PGD1', 'Phiếu 1', '2023-01-01', '2023-02-01', 10, 100, 1, 1, 1);

INSERT INTO PhieuGiamGia
    (MaPhieu, TenPhieu, NgayBatDau, NgayKetThuc, GiaTriGiam, GiaTriGiamToiDa, HinhThucGiam, TrangThai, NguoiSoHuu)
VALUES
    ('PGD2', 'Phiếu 2', '2023-02-02', '2023-03-02', 20, 200, 0, 1, 2);

INSERT INTO DiaChi
    (TenDiaChi, MoTaChiTiet, TinhThanhPho, QuanHuyen, PhuongXa, DuongPho, KhachHang)
VALUES
    ('Địa chỉ 1', 'Mô tả địa chỉ 1', 'Thành phố 1', 'Quận 1', 'Phường 1', 'Đường 1', 1);

INSERT INTO DiaChi
    (TenDiaChi, MoTaChiTiet, TinhThanhPho, QuanHuyen, PhuongXa, DuongPho, KhachHang)
VALUES
    ('Địa chỉ 2', 'Mô tả địa chỉ 2', 'Thành phố 2', 'Quận 2', 'Phường 2', 'Đường 2', 2);

INSERT INTO SanPham
    (TenSanPham, ChatLieu, GiaHienHanh, SoLuongTon, MoTa, LoaiSanPham, MauSac, NhaSanXuat, TrangThai)
VALUES
    ('Sản phẩm 1', 'Chất liệu 1', 1000000, 50, 'Mô tả sản phẩm 1', 'Loại 1', 'Màu 1', 'Nhà sản xuất 1', 1);

INSERT INTO SanPham
    (TenSanPham, ChatLieu, GiaHienHanh, SoLuongTon, MoTa, LoaiSanPham, MauSac, NhaSanXuat, TrangThai)
VALUES
    ('Sản phẩm 2', 'Chất liệu 2', 2000000, 100, 'Mô tả sản phẩm 2', 'Loại 2', 'Màu 2', 'Nhà sản xuất 2', 1);

INSERT INTO HoaDon
    (NgayLap, NguoiLap, GhiChu, NgayThanhToan, TrangThai, NguoiMua)
VALUES
    ('2023-01-01', 'Người lập 1', 'Ghi chú hóa đơn 1', '2023-01-02', 1, 1);

INSERT INTO HoaDon
    (NgayLap, NguoiLap, GhiChu, NgayThanhToan, TrangThai, NguoiMua)
VALUES
    ('2023-02-01', 'Người lập 2', 'Ghi chú hóa đơn 2', '2023-02-02', 1, 2);

INSERT INTO HoaDonChiTiet
    (MaHoaDon, MaSanPham, SoLuong, DonGia, GhiChu, TrangThai)
VALUES
    (1, 1, 2, 500000, 'Ghi chú chi tiết hóa đơn 1', 1);

INSERT INTO HoaDonChiTiet
    (MaHoaDon, MaSanPham, SoLuong, DonGia, GhiChu, TrangThai)
VALUES
    (1, 2, 1, 1500000, 'Ghi chú chi tiết hóa đơn 2', 1);

INSERT INTO PhieuGiaoHang
    (NguoiNhan, SdtNhan, NguoiGiao, SdtGiao, NgayGiao, NgayNhan, NguoiTao, PhiGiaoHang, HoaDonGiao, DiaChiGiao, GhiChu, TrangThai)
VALUES
    ('Người nhận 1', '123456789', 'Người giao 1', '987654321', '2023-01-01', '2023-01-02', 'Người tạo 1', 100000, 1, '5B7B91C4-2B88-4E9A-8D96-3DD6EA8D4D06', 'Ghi chú phiếu giao hàng 1', 1);

INSERT INTO PhieuGiaoHang
    (NguoiNhan, SdtNhan, NguoiGiao, SdtGiao, NgayGiao, NgayNhan, NguoiTao, PhiGiaoHang, HoaDonGiao, DiaChiGiao, GhiChu, TrangThai)
VALUES
    ('Người nhận 2', '987654321', 'Người giao 2', '123456789', '2023-02-01', '2023-02-02', 'Người tạo 2', 200000, 2, 'D596A639-2F0E-48E0-B172-130858D6559E', 'Ghi chú phiếu giao hàng 2', 1);

INSERT INTO GioHang
    (NgayTao, NgayCapNhap, NguoiSoHuu, GhiChu, TrangThai)
VALUES
    ('2023-01-01', '2023-01-02', 1, 'Ghi chú giỏ hàng 1', 1);

INSERT INTO GioHang
    (NgayTao, NgayCapNhap, NguoiSoHuu, GhiChu, TrangThai)
VALUES
    ('2023-02-01', '2023-02-02', 2, 'Ghi chú giỏ hàng 2', 1);

INSERT INTO GioHangChiTiet
    (MaGioHang, MaSanPham, SoLuong, GhiChu, TrangThai)
VALUES
    ('79465C1F-DE97-4088-AA7B-F3CC97463F78', 1, 2, 'Ghi chú chi tiết giỏ hàng 1', 1);

INSERT INTO GioHangChiTiet
    (MaGioHang, MaSanPham, SoLuong, GhiChu, TrangThai)
VALUES
    ('65CFAD8A-45DA-496B-A55D-BCD1C6FD9719', 2, 1, 'Ghi chú chi tiết giỏ hàng 2', 1);

INSERT INTO DanhSachYeuThich
    (NgayTao, NgayCapNhap, NguoiSoHuu, GhiChu, TrangThai)
VALUES
    ('2023-01-01', '2023-01-02', 1, 'Ghi chú danh sách yêu thích 1', 1);

INSERT INTO DanhSachYeuThich
    (NgayTao, NgayCapNhap, NguoiSoHuu, GhiChu, TrangThai)
VALUES
    ('2023-02-01', '2023-02-02', 2, 'Ghi chú danh sách yêu thích 2', 1);

INSERT INTO YeuThichChiTiet
    (MaDanhSach, MaSanPham, GhiChu, TrangThai)
VALUES
    ('D244D0D9-628A-465E-B288-E4AD75B5478A', 1, 'Ghi chú chi tiết yêu thích 1', 1);

INSERT INTO YeuThichChiTiet
    (MaDanhSach, MaSanPham, GhiChu, TrangThai)
VALUES
    ('E8193D4E-B3E0-4F01-963B-B4424CBB6E7E', 2, 'Ghi chú chi tiết yêu thích 2', 1);

SELECT *
FROM HangKhachHang;

SELECT *
FROM KhachHang;

SELECT *
FROM TheThanhVien;

SELECT *
FROM PhieuGiamGia;

SELECT *
FROM DiaChi;

SELECT *
FROM SanPham;

SELECT *
FROM HoaDon;

SELECT *
FROM HoaDonChiTiet;

SELECT *
FROM PhieuGiaoHang;

SELECT *
FROM GioHang;

SELECT *
FROM GioHangChiTiet;

SELECT *
FROM DanhSachYeuThich;

SELECT *
FROM YeuThichChiTiet;
