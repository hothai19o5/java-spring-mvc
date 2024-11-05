<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order History - LaptopShop</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
        href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Raleway:wght@600;800&display=swap"
        rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="/lib/lightbox/css/lightbox.min.css" rel="stylesheet">
    <link href="/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">


    <!-- Customized Bootstrap Stylesheet -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="/css/style.css" rel="stylesheet">
</head>

<body>

    <!-- Spinner Start -->
    <div id="spinner"
        class="show w-100 vh-100 bg-white position-fixed translate-middle top-50 start-50  d-flex align-items-center justify-content-center">
        <div class="spinner-grow text-primary" role="status"></div>
    </div>
    <!-- Spinner End -->


    <!-- Navbar start -->
    <jsp:include page="../layout/header.jsp" />
    <!-- Navbar End -->


    <!-- Single Page Header start -->
    <div class="container-fluid page-header py-5">
        <h1 class="text-center text-white display-6">Orders History</h1>
        <ol class="breadcrumb justify-content-center mb-0">
            <li class="breadcrumb-item"><a href="/">Home</a></li>
            <li class="breadcrumb-item"><a href="#">Pages</a></li>
            <li class="breadcrumb-item active text-white">Order History</li>
        </ol>
    </div>
    <!-- Single Page Header End -->


    <!-- Cart Page Start -->
    <div class="container-fluid py-5">
        <div class="container py-5">
            <div class="table-responsive">
                <table class="table">
                    <thead>
                        <tr>
                        <th scope="col">Products</th>
                        <th scope="col">Name</th>
                        <th scope="col">Price</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Total</th>
                        <th scope="col">Status</th>
                        </tr>
                    </thead>
                    <c:forEach var="order" items="${orders}">
                        <tbody>
                            <tr>
                                <th>
                                    <p class="mb-0 mt-4">Order Id = ${order.id}</p>
                                </th>
                                <td></td>
                                <td>
                                    <p class="mb-0 mt-4">
                                        <fmt:formatNumber type="number" value="${order.totalPrice}" /> đ
                                    </p>
                                </td>
                                <td></td>
                                <td></td>
                                <td>
                                    <p class="mb-0 mt-4">${order.status}</p>
                                </td>
                            </tr>
                            <c:forEach var="orderDetail" items="${orderDetails}">
                                <c:if test="${orderDetail.order.id == order.id}">
                                    <tr>
                                        <th scope="row">
                                            <div class="d-flex align-items-center">
                                                <img src="images/product/${orderDetail.product.image}" class="img-fluid me-5 rounded-circle" style="width: 80px; height: 80px;" alt="" alt="">
                                            </div>
                                        </th>
                                        <td>
                                            <p class="mb-0 mt-4">${orderDetail.product.name}</p>
                                        </td>
                                        <td>
                                            <p class="mb-0 mt-4">
                                                <fmt:formatNumber type="number" value="${orderDetail.product.price}" /> đ
                                            </p>
                                        </td>
                                        <td>
                                            <div class="input-group quantity mt-4" style="width: 100px;">
                                                <input type="text" class="form-control form-control-sm text-center border-0" value="${orderDetail.quantity}" >
                                            </div>
                                        </td>
                                        <td>
                                            <p class="mb-0 mt-4">
                                                <fmt:formatNumber type="number" value="${orderDetail.price}" /> đ
                                            </p>
                                        </td>
                                        <td></td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </tbody>
                    </c:forEach>
                </table>
            </div>
            <c:if test="${orders == null}">
                <div class="text-center mt-5">
                    <h3 class="text-danger">Bạn chưa mua đơn hàng nào trước đây</h3>
                    <a href="/" class="btn border-secondary rounded-pill px-4 py-3 text-primary text-uppercase mt-5">Tiếp tục mua hàng</a>
                </div>
            </c:if>
        </div>
    </div>
    <!-- Cart Page End -->


    <!-- Footer Start -->
    <jsp:include page="../layout/footer.jsp" />
    <!-- Footer End -->


    <!-- Back to Top -->
    <a href="#" class="btn btn-primary border-3 border-primary rounded-circle back-to-top"><i
            class="fa fa-arrow-up"></i></a>


    <!-- JavaScript Libraries -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="/lib/easing/easing.min.js"></script>
    <script src="/lib/waypoints/waypoints.min.js"></script>
    <script src="/lib/lightbox/js/lightbox.min.js"></script>
    <script src="/lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Template Javascript -->
    <script src="/js/main.js"></script>
</body>

</html>