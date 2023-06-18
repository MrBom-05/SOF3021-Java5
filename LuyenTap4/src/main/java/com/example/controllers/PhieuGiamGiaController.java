package com.example.controllers;

import com.example.entities.PhieuGiamGia;
import com.example.repositories.KhachHangRepository;
import com.example.repositories.PhieuGiamGiaRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
@RequestMapping("phieu-giam-gia")
public class PhieuGiamGiaController {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Autowired
    private PhieuGiamGiaRepository phieuGiamGiaRepository;

    @Autowired
    private HttpSession session;

    @GetMapping("hien-thi")
    public String hienThi(Model model, @RequestParam(defaultValue = "0", name = "page") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        model.addAttribute("list", phieuGiamGiaRepository.findAll(pageable));
        model.addAttribute("listKhachHang", khachHangRepository.findAll());
        return "hien-thi";
    }


    @GetMapping("edit/{id}")
    public String edit(Model model, @PathVariable("id") String id) {
        model.addAttribute("listKhachHang", khachHangRepository.findAll());
        model.addAttribute("phieuGiamGia", phieuGiamGiaRepository.findById(id).get());
        return "update";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        session.setAttribute("thongBao", "Xóa thành công");
        phieuGiamGiaRepository.deleteById(id);
        return "redirect:/phieu-giam-gia/hien-thi";
    }

    @PostMapping("update/{id}")
    public String update(@Valid @ModelAttribute("phieuGiamGia") PhieuGiamGia phieuGiamGia, BindingResult result, @PathVariable("id") String id, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("listKhachHang", khachHangRepository.findAll());
            model.addAttribute("phieuGiamGia", phieuGiamGiaRepository.findById(id).get());
            return "update";
        }

        PhieuGiamGia phieuGiamGia1 = phieuGiamGiaRepository.findById(id).get();
        phieuGiamGia1.setMaPhieu(id);
        phieuGiamGia1.setTenPhieu(phieuGiamGia.getTenPhieu());
        phieuGiamGia1.setNgayBatDau(phieuGiamGia.getNgayBatDau());
        phieuGiamGia1.setNgayKetThuc(phieuGiamGia.getNgayKetThuc());
        phieuGiamGia1.setGiaTriGiam(phieuGiamGia.getGiaTriGiam());
        phieuGiamGia1.setGiaTriGiamToiDa(phieuGiamGia.getGiaTriGiamToiDa());
        phieuGiamGia1.setNguoiSoHuu(phieuGiamGia.getNguoiSoHuu());

        session.setAttribute("thongBao", "Cập nhật thành công");
        phieuGiamGiaRepository.save(phieuGiamGia1);
        return "redirect:/phieu-giam-gia/hien-thi";
    }

    @PostMapping("search")
    public String search(Model model, @RequestParam(defaultValue = "0", name = "page") int page,
                         @RequestParam("ngayBatDau") Date ngayBatDau,
                         @RequestParam("ngayKetThuc") Date ngayKetThuc,
                         @RequestParam("maKhachHang") String maKhachHang) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<PhieuGiamGia> list;

         if (ngayBatDau.toString().trim().length() == 0 || ngayKetThuc.toString().trim().length() == 0) {
            System.out.println(1);
            list = phieuGiamGiaRepository.findByNguoiSoHuu(maKhachHang, pageable);
        } else if (maKhachHang.trim().length() == 0) {
            System.out.println(2);
            list = phieuGiamGiaRepository.findByKhoangNgay(ngayBatDau, ngayKetThuc, pageable);
        } else {
            System.out.println(3);
            list = phieuGiamGiaRepository.findByKhoangNgayAndNguoiSoHuu(ngayBatDau, ngayKetThuc, maKhachHang, pageable);
        }


        model.addAttribute("list", list);
        model.addAttribute("listKhachHang", khachHangRepository.findAll());
        return "hien-thi";
    }
}
