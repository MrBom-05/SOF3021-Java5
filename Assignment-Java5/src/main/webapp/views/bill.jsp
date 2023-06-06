<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/17/2023
  Time: 9:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>

<div>
    <div>
        <c:if test="${ f:length(list) == 0 }">
            <h4 class="text-center">Không có sản phẩm</h4>
        </c:if>
        <c:if test="${ f:length(list) != 0 }">
            <c:forEach var="hoaDon" items="${ list }" varStatus="status">
                <div class="card mb-2 border col-8 offset-2">
                    <div class="card-body">
                        <div class="row align-items-center">
                            <div class="col-1">
                                <span class="text-decoration-none text-black">${status.index + 1}</span>
                            </div>
                            <div class="col-2">
                                <span>Mã Đơn Hàng:</span>
                                <a href="/bill-detail/${hoaDon.id}"
                                   class="text-decoration-none text-black" scroll-to-top>${hoaDon.ma}</a>
                            </div>
                            <div class="col-3">
                                <span>Ngày Tạo:</span>
                                <span class="text-decoration-none text-black">${hoaDon.ngayTao}</span>
                            </div>

                            <div class="col-2">
                                <span>Số Lượng Sản Phẩm:</span>
                                <span class="text-center text-truncate">${hoaDon.tongSoLuong}</span>
                            </div>

                            <div class="col-2">
                                <span>Tổng Tiền</span>
                                <span class="text-center text-truncate text-danger">$${hoaDon.tongTien}</span>
                            </div>

                            <div class="col-2">
                                <span>Trạng Thái</span>
                                <span class="text-center text-truncate text-danger">${hoaDon.trangThai}</span>
                            </div>
                        </div>
                    </div>

                </div>
            </c:forEach>
        </c:if>

    </div>
</div>
