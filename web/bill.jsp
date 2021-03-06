<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            margin-left: auto;
            margin-right: auto
        }
    </style>
    <body>
        <div style="text-align: center">
            <label>Hóa Đơn Thanh Toán</label>
            <div>
                <table>
                    <tr>
                        <th>Tháng</th>
                        <th>Hóa Đởn</th>
                        <th>Tổng Tiền</th>
                        <th>Trạng thái</th>
                    </tr>
                    <c:forEach var="item" items="${bills}">
                        <tr>
                            <td>${item.month}</td>
                            <td>${item.code}</td>
                            <td>${item.money}</td>
                            <c:choose>
                                <c:when test="${item.status == '1'}">
                                    <td>Da thanh toan</td>
                                </c:when>
                                <c:when test="${item.status == '2'}">
                                    <td>Chua thanh toan</td>
                                </c:when>
                            </c:choose>
                            <td>
                                <button><a href="BillDetailController?idPartner=${item.id}&status=${item.status}">Xem chi tiết</a></button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <button><a href="index.jsp">Home</a></button>
            </div>
        </div>
    </body>
</html>
