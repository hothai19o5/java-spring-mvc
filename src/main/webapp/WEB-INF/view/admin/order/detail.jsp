<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Detail</title>
    <!-- Latest compiled and minified CSS -->
    <link href="/css/styles.css" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Latest compiled JavaScript -->
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</head>

<body class="sb-nav-fixed">
    <jsp:include page="../layout/header.jsp" />
    <div id="layoutSidenav">
        <jsp:include page="../layout/sidebar.jsp" />
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">Orders</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item active"><a style="text-decoration: none;"
                                href="/admin">Dashboard</a>/ <a style="text-decoration: none;"
                                href="/admin/order">Order</a>/Detail
                        </li>
                    </ol>
                    <div class="mt-5">
                        <div class="d-flex justify-content-between">
                            <h3>Order Detail with Id = ${id}</h3>
                            <a href="/admin/order" class="btn btn-primary">Back</a>
                        </div>
                        <hr />
                        <div class="card">
                            <div class="card-header">
                            </div>
                            <div class="card-body">
                                <table class="table table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th scope="col">Sản phẩm</th>
                                            <th scope="col">Tên Sản Phẩm</th>
                                            <th scope="col">Giá</th>
                                            <th scope="col">Số Lượng</th>
                                            <th scope="col">Thành Tiền</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="orderDetail" items="${orderDetails}">
                                            <c:if test="${orderDetail.order.id == id}">
                                                <tr>
                                                    <th scope="row">
                                                        <div class="d-flex align-items-center">
                                                            <img src="/images/product/${orderDetail.product.image}" class="img-fluid me-5 rounded-circle" style="width: 80px; height: 80px;" alt="" alt="">
                                                        </div>
                                                    </th>
                                                    <td>
                                                        <p class="mb-0 mt-4">${orderDetail.product.name}</p>
                                                    </td>
                                                    <td>
                                                        <p class="mb-0 mt-4">
                                                            <fmt:formatNumber type="number" value="${orderDetail.price}" /> đ
                                                        </p>
                                                    </td>
                                                    <td>
                                                        <div class="input-group quantity mt-4" style="width: 100px;">
                                                            <fmt:formatNumber type="number" value="${orderDetail.quantity}" /> đ
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <p class="mb-0 mt-4" data-cart-detail-id="${orderDetail.id}" >
                                                            <fmt:formatNumber type="number" value="${orderDetail.price * orderDetail.quantity}" /> đ
                                                        </p>
                                                    </td>
                                                </tr>
                                            </c:if>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
            <jsp:include page="../layout/footer.jsp" />
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
    <script src="/js/scripts.js"></script>
    <script src="/js/datatables-simple-demo.js"></script>
</body>

</html>