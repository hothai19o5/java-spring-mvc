<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!-- Navbar start -->
<div class="container-fluid fixed-top">
    <div class="container topbar bg-primary d-none d-lg-block">
        <div class="d-flex justify-content-between">
            <div class="top-info ps-2">
                <small class="me-3"><i class="fas fa-map-marker-alt me-2 text-secondary"></i> <a href="#"
                        class="text-white">Hai Ba Trung, Ha Noi</a></small>
                <small class="me-3"><i class="fas fa-envelope me-2 text-secondary"></i><a href="#"
                        class="text-white">Thai.HX04@gmai.com</a></small>
            </div>
            <div class="top-link pe-2">
                <a href="#" class="text-white"><small class="text-white mx-2">Privacy Policy</small>/</a>
                <a href="#" class="text-white"><small class="text-white mx-2">Terms of Use</small>/</a>
                <a href="#" class="text-white"><small class="text-white ms-2">Sales and Refunds</small></a>
            </div>
        </div>
    </div>
    <div class="container px-0">
        <nav class="navbar navbar-light bg-white navbar-expand-xl">
            <a href="#" class="navbar-brand">
                <h1 class="text-primary display-6">LaptopShop</h1>
            </a>
            <button class="navbar-toggler py-2 px-3" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarCollapse">
                <span class="fa fa-bars text-primary"></span>
            </button>
            <div class="collapse navbar-collapse bg-white justify-content-between mx-5" id="navbarCollapse">
                <div class="navbar-nav">
                    <a href="#" class="nav-item nav-link active">Home</a>
                    <a href="#" class="nav-item nav-link">Shop</a>
                    <a href="#" class="nav-item nav-link">Shop Detail</a>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Pages</a>
                        <div class="dropdown-menu m-0 bg-secondary rounded-0">
                            <a href="#" class="dropdown-item">Cart</a>
                            <a href="#" class="dropdown-item">Chackout</a>
                            <a href="#" class="dropdown-item">Testimonial</a>
                            <a href="/404" class="dropdown-item">404 Page</a>
                        </div>
                    </div>
                    <a href="#" class="nav-item nav-link">Contact</a>
                </div>
                <div class="d-flex m-3 me-0">
                    <c:if test="${not empty pageContext.request.userPrincipal}">
                        <button class="btn-search btn border border-secondary btn-md-square rounded-circle bg-white me-4"
                            data-bs-toggle="modal" data-bs-target="#searchModal"><i
                                class="fas fa-search text-primary"></i></button>
                        <a href="#" class="position-relative me-4 my-auto">
                            <i class="fa fa-shopping-bag fa-2x"></i>
                            <span
                                class="position-absolute bg-secondary rounded-circle d-flex align-items-center justify-content-center text-dark px-1"
                                style="top: -5px; left: 15px; height: 20px; min-width: 20px;">${sessionScope.quantity}</span>
                        </a>
                        <div class="nav-item dropdown my-auto">
                            <a href="#" class="dropdown" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false" data-bs-toggle="dropdown" aria-expanded="false">
                                <i class="fas fa-user fa-2x"></i>
                            </a>
                            <ul class="dropdown-menu m-4 dropdown-menu-start p-3 bg-secondary" arialabelledby="dropdownMenuLink" style="right: -50px;">
                                <li class="d-flex align-items-center flex-column" style="min-width: 200px;">
                                    <img style="width: 150px; height: 150px; border-radius: 50%; overflow: hidden;"
                                    src="/images/avatar/${sessionScope.avatar}" />
                                    <div class="text-center my-3">
                                        <c:out value="${sessionScope.fullName}" />
                                    </div>
                                </li>
                                <li><a class="dropdown-item rounded" href="#">Quản Lý Tài Khoản</a></li>
                                <li><a class="dropdown-item rounded" href="#">Lịch Sử Mua Hàng</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li>
                                    <form method="post" action="/logout">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <button class="dropdown-item rounded" href="#">Đăng Xuất</button>
                                    </form>
                                </li>
                            </ul>
                        </div>
                    </c:if>
                    <c:if test="${empty pageContext.request.userPrincipal}">
                        <a href="/login" class="nav-item nav-link">Login</a>
                        <a href="/register" class="nav-item nav-link">Register</a>
                    </c:if>
                </div>
            </div>
        </nav>
    </div>
</div>
<!-- Navbar End -->

<!-- Modal Search Start -->
<div class="modal fade" id="searchModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-fullscreen">
        <div class="modal-content rounded-0">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Search by keyword</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body d-flex align-items-center">
                <div class="input-group w-75 mx-auto d-flex">
                    <input type="search" class="form-control p-3" placeholder="keywords"
                        aria-describedby="search-icon-1">
                    <span id="search-icon-1" class="input-group-text p-3"><i class="fa fa-search"></i></span>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Modal Search End -->