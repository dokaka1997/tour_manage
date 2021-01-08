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
                        <th>Mã</th>
                        <th>Tên dịch vụ</th>
                        <th>Ngày bắt đầu</th>
                        <th>Đơn giá</th>
                        <th>Số Lượng</th>
                        <th>Thành Tiền</th>
                    </tr>
                    <c:forEach var="item" items="${billDetail}">
                        <tr>
                            <td>${item.code}</td>
                            <td>${item.name}</td>
                            <td>${item.date}</td>
                            <td>${item.amount}</td>
                            <td>${item.money}</td>
                            <td>${item.money * item.amount}</td>
                        </tr>
                    </c:forEach>
                </table>
                <label>Tổng tiền: ${sum}  </label><br>
                <button onclick="myFunction(${idBill})">Thanh Toán</button>
                <!--<button><a href="PaymentController?id=${idBill}">Thanh Toán</a></button>-->
            </div>
        </div>
        <script>
            function myFunction(id) {
                var answer = window.confirm("Xác nhận thanh toán tới stk ${stk} với số tiền là ${sum} ");
                if (answer) {
                    location.href = "PaymentController?idPartner=" + id;
                }
                else {
                    //some code
                }
            }
        </script>
    </body>
</html>
