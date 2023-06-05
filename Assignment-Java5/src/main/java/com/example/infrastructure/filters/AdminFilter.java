package com.example.infrastructure.filters;

import com.example.models.NhanVienViewModel;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession();
        NhanVienViewModel nhanVien = (NhanVienViewModel) session.getAttribute("nhanVien");

        if (httpRequest.getRequestURI().equals(httpRequest.getContextPath() + "/admin/login")) {
            // Nếu truy cập vào trang đăng nhập, tiếp tục xử lý request
            chain.doFilter(request, response);
        } else if (nhanVien == null) {
            // Nếu session không tồn tại hoặc người dùng chưa đăng nhập, chuyển hướng đến trang đăng nhập
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/admin/login");
        } else {
            // Cho phép tiếp tục xử lý request
            chain.doFilter(request, response);
        }
    }

}
