package com.example.controllers.admin;

import com.example.models.NhanVienViewModel;
import com.example.services.ChucVuService;
import com.example.services.CuaHangService;
import com.example.services.NhanVienService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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
    private HttpSession session;

    private static final String redirect = "redirect:/admin/nhan-vien/index";

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("list", nhanVienService.findAll());
        model.addAttribute("view", "/views/admin/nhan-vien/index.jsp");
        return "admin/layout";
    }

    @GetMapping("create")
    public String createGet(Model model) {
        model.addAttribute("nhanVien", nhanVienViewModel);
        model.addAttribute("listCuaHang", cuaHangService.findAll());
        model.addAttribute("listChucVu", chucVuService.findAll());
        model.addAttribute("name", "Add");
        model.addAttribute("action", "/admin/nhan-vien/create");
        model.addAttribute("view", "/views/admin/nhan-vien/create.jsp");
        return "admin/layout";
    }

    @GetMapping("update/{id}")
    public String updateGet(Model model, @PathVariable("id") UUID id) {
        NhanVienViewModel nhanVienViewModel = nhanVienService.findById(id);
        model.addAttribute("nhanVien", nhanVienViewModel);

        model.addAttribute("listCuaHang", cuaHangService.findAll());
        model.addAttribute("listChucVu", chucVuService.findAll());
        model.addAttribute("name", "Update");
        model.addAttribute("action", "/admin/nhan-vien/update/" + id);
        model.addAttribute("view", "/views/admin/nhan-vien/create.jsp");
        return "admin/layout";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") UUID id) {
        try {
            nhanVienService.deleteById(id);

        } catch (DataIntegrityViolationException e) {
            session.setAttribute("thongBao", "Không thể xóa sản phẩm do có bản ghi liên quan");
        }
        return redirect;
    }

    @PostMapping("create")
    public String createPost(@Valid @ModelAttribute("nhanVien") NhanVienViewModel nhanVienViewModel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("nhanVien", nhanVienViewModel);
            model.addAttribute("listCuaHang", cuaHangService.findAll());
            model.addAttribute("listChucVu", chucVuService.findAll());
            model.addAttribute("name", "Add");
            model.addAttribute("action", "/admin/nhan-vien/create");
            model.addAttribute("view", "/views/admin/nhan-vien/create.jsp");
            return "admin/layout";
        } else {
            nhanVienService.saveOrUpdate(nhanVienViewModel);
            return redirect;
        }
    }

    @PostMapping("update/{id}")
    public String updatePost(@Valid @ModelAttribute("nhanVien") NhanVienViewModel nhanVienViewModel, BindingResult result, @PathVariable("id") UUID id, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("nhanVien", nhanVienViewModel);
            model.addAttribute("listCuaHang", cuaHangService.findAll());
            model.addAttribute("listChucVu", chucVuService.findAll());
            model.addAttribute("name", "Update");
            model.addAttribute("action", "/admin/nhan-vien/update/" + id);
            model.addAttribute("view", "/views/admin/nhan-vien/create.jsp");
            return "admin/layout";
        } else {
            nhanVienViewModel.setId(id);
            nhanVienService.saveOrUpdate(nhanVienViewModel);
            return redirect;
        }
    }

}
