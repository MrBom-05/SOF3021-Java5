package com.example.infrastructure.filters;

import com.example.models.KhachHangViewModel;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class UserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession();
        KhachHangViewModel khachHang = (KhachHangViewModel) session.getAttribute("khachHang");

        if (httpRequest.getRequestURI().equals(httpRequest.getContextPath() + "/sign-in")) {
            // Nếu truy cập vào trang đăng nhập, tiếp tục xử lý request
            chain.doFilter(request, response);
        } else if (khachHang == null) {
            // Nếu session không tồn tại hoặc người dùng chưa đăng nhập, chuyển hướng đến trang đăng nhập
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/sign-in");
        } else {
            // Cho phép tiếp tục xử lý request
            chain.doFilter(request, response);
        }
    }
}
