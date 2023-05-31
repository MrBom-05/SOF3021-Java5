package com.example.controllers.admin;

import com.example.models.NhanVienViewModel;
import com.example.services.ChucVuService;
import com.example.services.CuaHangService;
import com.example.services.NhanVienService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/nhan-vien")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private CuaHangService cuaHangService;

    @Autowired
    private ChucVuService chucVuService;

    @Autowired
    private NhanVienViewModel nhanVienViewModel;

    @Autowired
    private HttpServletRequest request;

    private static final String redirect = "admin/nhan-vien/index";

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("list", nhanVienService.findAll());
        request.setAttribute("view", "/views/admin/nhan-vien/index.jsp");
        return "admin/layout";
    }

    @GetMapping("create")
    public String createGet(Model model) {
        model.addAttribute("nhanVien", nhanVienViewModel);
        model.addAttribute("listCuaHang", cuaHangService.findAll());
        model.addAttribute("listChucVu", chucVuService.findAll());
        request.setAttribute("view", "/views/admin/nhan-vien/create.jsp");
        return "admin/layout";
    }


}
