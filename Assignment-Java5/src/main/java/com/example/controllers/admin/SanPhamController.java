package com.example.controllers.admin;

import com.example.models.SanPhamViewModel;
import com.example.services.SanPhamService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Controller
@RequestMapping("admin/san-pham")
public class SanPhamController {
    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private SanPhamViewModel sanPhamViewModel;

    @Autowired
    private HttpServletRequest request;

    private static final String redidect = "redirect:/admin/san-pham/index";

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("list", sanPhamService.findAll());
        request.setAttribute("view", "/views/admin/san-pham/index.jsp");
        return "admin/layout";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("sanPham", sanPhamViewModel);
        model.addAttribute("name", "Add");
        model.addAttribute("action", "/admin/san-pham/create");
        request.setAttribute("view", "/views/admin/san-pham/create.jsp");
        return "admin/layout";
    }

    @GetMapping("update/{id}")
    public String update(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("sanPham", sanPhamService.findById(id));
        model.addAttribute("name", "Update");
        model.addAttribute("action", "/admin/san-pham/update/" + id);
        request.setAttribute("view", "/views/admin/san-pham/create.jsp");
        return "admin/layout";
    }

    @PostMapping("create")
    public String createPost(@Valid @ModelAttribute("sanPham") SanPhamViewModel sanPhamViewModel, BindingResult result, Model model, @RequestParam("anh") MultipartFile file) {
        if (file.isEmpty()) {
            // Xử lý khi không có tệp được chọn
            return "redirect:/error";
        }

        try {
            // Đảm bảo tên tệp là duy nhất bằng cách thêm UUID vào tên tệp
            String fileName = StringUtils.cleanPath(UUID.randomUUID() + "_" + file.getOriginalFilename());
            Path uploadPath = Paths.get("images");

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Lưu tệp vào thư mục images
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // Lưu đường dẫn tới ảnh vào cơ sở dữ liệu
            if (result.hasErrors()) {
                model.addAttribute("name", "Add");
                model.addAttribute("action", "/admin/san-pham/create");
                request.setAttribute("view", "/views/admin/san-pham/create.jsp");
                return "admin/layout";
            } else {
                sanPhamViewModel.setAnh(filePath.toString());
                sanPhamService.saveOrUpdate(sanPhamViewModel);
                return redidect;
            }
        } catch (IOException e) {
            // Xử lý lỗi khi lưu tệp
            return "redirect:/error";
        }
    }
}
