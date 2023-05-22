package com.example.repository;

import com.example.entities.KhachHang;

import java.util.ArrayList;

public class KhachHangRepository {

    private ArrayList<KhachHang> list = new ArrayList<>();

    public ArrayList<KhachHang> findAll(){
        return list;
    }

    public void insert(KhachHang khachHang){
        list.add(khachHang);
    }

    public void delete(String ma){
        for (int i = 0; i < list.size(); i++) {
            KhachHang khachHang = list.get(i);
            if (khachHang.getMa().equals(ma)) {
                list.remove(i);
            }
        }
    }

    public void update(KhachHang khachHang){
        for (int i = 0; i < list.size(); i++) {
            KhachHang kh = list.get(i);
            if (kh.getMa().equals(khachHang.getMa())) {
                list.set(i, khachHang);
            }
        }
    }

    public KhachHang findByMa(String ma){
        for (int i = 0; i < list.size(); i++) {
            KhachHang kh = list.get(i);
            if (kh.getMa().equals(ma)) {
                return kh;
            }
        }
        return null;
    }
}
