package com.example.repository;

import com.example.entities.NhanVien;

import java.util.ArrayList;

public class NhanVienRepository {
    private ArrayList<NhanVien> list;

    public NhanVienRepository() {
        this.list = new ArrayList<>();

    }

    public void insert(NhanVien nhanVien) {

        this.list.add(nhanVien);
    }


    public void update(NhanVien nhanVien) {
        // UPDATE KhachHang SET ... WHERE ma = ?
        for (int i = 0; i < this.list.size(); i++) {
            NhanVien vm = this.list.get(i);
            if (vm.getMa().equals(nhanVien.getMa())) {
                this.list.set(i, nhanVien);
            }
        }
    }

    public void delete(NhanVien nhanVien) {
        // DELETE FROM KhachHang WHERE ma = ?
        for (int i = 0; i < this.list.size(); i++) {
            NhanVien vm = this.list.get(i);
            if (vm.getMa().equals(nhanVien.getMa())) {
                this.list.remove(i);
            }
        }
    }

    public ArrayList<NhanVien> findAll() {
        return list;
    }

    public NhanVien findByMa(String ma) {
        // SELECT * FROM KhachHang WHERE ma = ?
        for (int i = 0; i < this.list.size(); i++) {
            NhanVien vm = this.list.get(i);
            if (vm.getMa().equals(ma)) {
                return this.list.get(i);
            }
        }

        return null;
    }
}
