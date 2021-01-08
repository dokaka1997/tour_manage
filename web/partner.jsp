<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Tour</title>
        <meta charset="UTF-8">
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
            <label>Danh sách đối tác</label>
            <form action="FindPartnerController">
                <label for="name">Tên đối tác</label>
                <input type="text" id="name" name="name">
                <input type="submit" value="Submit">
            </form>

            <div>
                <table>
                    <tr>
                        <th>Họ và tên</th>
                        <th>Mã đối tác</th>
                        <th>Hóa đơn thanh toán</th>
                        <th>Trạng thái</th>
                    </tr>
                    <c:forEach var="item" items="${partners}">
                        <tr>
                            <td>${item.name}</td>
                            <td>${item.code}</td>
                            <td>${item.mail}</td>
                            <c:choose>
                                <c:when test="${item.status == '1'}">
                                    <td>Da thanh toan</td>
                                </c:when>
                                <c:when test="${item.status == '2'}">
                                    <td>Chua thanh toan</td>
                                </c:when>
                            </c:choose>
                            <td>
                                <button><a href="BillController?idPartner=${item.id}">Xem</a></button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>

    </body>
</html>
