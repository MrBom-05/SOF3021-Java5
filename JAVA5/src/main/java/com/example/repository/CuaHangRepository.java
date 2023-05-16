package com.example.repository;

import com.example.entities.CuaHang;

import java.util.ArrayList;

public class CuaHangRepository {
    private ArrayList<CuaHang> list = new ArrayList<>();

    public void insert(CuaHang cuaHang) {

        this.list.add(cuaHang);
    }


    public void update(CuaHang cuaHang) {
        // UPDATE KhachHang SET ... WHERE ma = ?
        for (int i = 0; i < this.list.size(); i++) {
            CuaHang vm = this.list.get(i);
            if (vm.getMa().equals(cuaHang.getMa())) {
                this.list.set(i, cuaHang);
            }
        }
    }

    public void delete(CuaHang cuaHang) {
        // DELETE FROM KhachHang WHERE ma = ?
        for (int i = 0; i < this.list.size(); i++) {
            CuaHang vm = this.list.get(i);
            if (vm.getMa().equals(cuaHang.getMa())) {
                this.list.remove(i);
            }
        }
    }

    public ArrayList<CuaHang> findAll() {
        return list;
    }

    public CuaHang findByMa(String ma) {
        // SELECT * FROM KhachHang WHERE ma = ?
        for (int i = 0; i < this.list.size(); i++) {
            CuaHang vm = this.list.get(i);
            if (vm.getMa().equals(ma)) {
                return this.list.get(i);
            }
        }

        return null;
    }
}
