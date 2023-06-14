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

INSERT INTO TheThanhVien
    (MaThe, MauThe, LoaiThe, NgayPhatHanh, NgayHuy, TrangThai, NguoiSoHuu)
VALUES
    ('The1', 'Màu 1', 'Loại 1', '2023-01-01', NULL, 1, 12);

INSERT INTO TheThanhVien
    (MaThe, MauThe, LoaiThe, NgayPhatHanh, NgayHuy, TrangThai, NguoiSoHuu)
VALUES
    ('The2', 'Màu 2', 'Loại 2', '2023-02-02', NULL, 1, 15);

INSERT INTO PhieuGiamGia
    (MaPhieu, TenPhieu, NgayBatDau, NgayKetThuc, GiaTriGiam, GiaTriGiamToiDa, HinhThucGiam, TrangThai, NguoiSoHuu)
VALUES
    ('PGD1', 'Phiếu 1', '2023-01-01', '2023-02-01', 10, 100, 1, 1, 12);

INSERT INTO PhieuGiamGia
    (MaPhieu, TenPhieu, NgayBatDau, NgayKetThuc, GiaTriGiam, GiaTriGiamToiDa, HinhThucGiam, TrangThai, NguoiSoHuu)
VALUES
    ('PGD2', 'Phiếu 2', '2023-02-02', '2023-03-02', 20, 200, 0, 1, 15);

INSERT INTO DiaChi
    (TenDiaChi, MoTaChiTiet, TinhThanhPho, QuanHuyen, PhuongXa, DuongPho, KhachHang)
VALUES
    ('Địa chỉ 1', 'Mô tả địa chỉ 1', 'Thành phố 1', 'Quận 1', 'Phường 1', 'Đường 1', 12);

INSERT INTO DiaChi
    (TenDiaChi, MoTaChiTiet, TinhThanhPho, QuanHuyen, PhuongXa, DuongPho, KhachHang)
VALUES
    ('Địa chỉ 2', 'Mô tả địa chỉ 2', 'Thành phố 2', 'Quận 2', 'Phường 2', 'Đường 2', 15);

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
    ('2023-01-01', 'Người lập 1', 'Ghi chú hóa đơn 1', '2023-01-02', 1, 12);

INSERT INTO HoaDon
    (NgayLap, NguoiLap, GhiChu, NgayThanhToan, TrangThai, NguoiMua)
VALUES
    ('2023-02-01', 'Người lập 2', 'Ghi chú hóa đơn 2', '2023-02-02', 1, 15);

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
    ('Người nhận 1', '123456789', 'Người giao 1', '987654321', '2023-01-01', '2023-01-02', 'Người tạo 1', 100000, 1, '8a44a4d9-c5f3-43e9-8949-2b49c815dbe5', 'Ghi chú phiếu giao hàng 1', 1);

INSERT INTO PhieuGiaoHang
    (NguoiNhan, SdtNhan, NguoiGiao, SdtGiao, NgayGiao, NgayNhan, NguoiTao, PhiGiaoHang, HoaDonGiao, DiaChiGiao, GhiChu, TrangThai)
VALUES
    ('Người nhận 2', '987654321', 'Người giao 2', '123456789', '2023-02-01', '2023-02-02', 'Người tạo 2', 200000, 2, '8a44a4d9-c5f3-43e9-8949-2b49c815dbe5', 'Ghi chú phiếu giao hàng 2', 1);

INSERT INTO GioHang
    (NgayTao, NgayCapNhap, NguoiSoHuu, GhiChu, TrangThai)
VALUES
    ('2023-01-01', '2023-01-02', 12, 'Ghi chú giỏ hàng 1', 1);

INSERT INTO GioHang
    (NgayTao, NgayCapNhap, NguoiSoHuu, GhiChu, TrangThai)
VALUES
    ('2023-02-01', '2023-02-02', 15, 'Ghi chú giỏ hàng 2', 1);

INSERT INTO GioHangChiTiet
    (MaGioHang, MaSanPham, SoLuong, GhiChu, TrangThai)
VALUES
    ('8F4BCCBF-C017-4BC5-B674-13458E7F3A04', 1, 2, 'Ghi chú chi tiết giỏ hàng 1', 1);

INSERT INTO GioHangChiTiet
    (MaGioHang, MaSanPham, SoLuong, GhiChu, TrangThai)
VALUES
    ('C6180A8C-1F0A-4367-A330-82FC7B1D4008', 2, 1, 'Ghi chú chi tiết giỏ hàng 2', 1);

INSERT INTO DanhSachYeuThich
    (NgayTao, NgayCapNhap, NguoiSoHuu, GhiChu, TrangThai)
VALUES
    ('2023-01-01', '2023-01-02', 12, 'Ghi chú danh sách yêu thích 1', 1);

INSERT INTO DanhSachYeuThich
    (NgayTao, NgayCapNhap, NguoiSoHuu, GhiChu, TrangThai)
VALUES
    ('2023-02-01', '2023-02-02', 15, 'Ghi chú danh sách yêu thích 2', 1);

INSERT INTO YeuThichChiTiet
    (MaDanhSach, MaSanPham, GhiChu, TrangThai)
VALUES
    ('D877D421-2B4F-4403-8096-58C2FAE4D3BC', 1, 'Ghi chú chi tiết yêu thích 1', 1);

INSERT INTO YeuThichChiTiet
    (MaDanhSach, MaSanPham, GhiChu, TrangThai)
VALUES
    ('D877D421-2B4F-4403-8096-58C2FAE4D3BC', 2, 'Ghi chú chi tiết yêu thích 2', 1);

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
