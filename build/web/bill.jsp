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
                            <td>${item.status}</td>
                            <td>
                                <button><a href="PaymentController?id=${item.id}">Thanh Toán</a></button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
