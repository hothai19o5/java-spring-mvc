<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!-- Hero Start -->
<div class="container-fluid py-5 mb-5 hero-header">
    <div class="container py-5">
        <div class="row g-5 align-items-center">
            <div class="col-md-12 col-lg-7 d-none d-md-block">
                <h4 class="mb-3 text-secondary">100% Sản Phẩm Chính Hãng</h4>
                <h1 class="mb-5 display-3 text-primary">Hàng cao cấp<br>Rẻ vô địch</h1>
                <div class="position-relative mx-auto">
                    <input class="form-control border-2 border-secondary w-75 py-3 px-4 rounded-pill"
                        type="number" placeholder="Search">
                    <button type="submit"
                        class="btn btn-primary border-2 border-secondary py-3 px-4 position-absolute rounded-pill text-white h-100"
                        style="top: 0; right: 25%;">Submit Now</button>
                </div>
            </div>
            <div class="col-md-12 col-lg-5">
                <div id="carouselId" class="carousel slide position-relative" data-bs-ride="carousel">
                    <div class="carousel-inner" role="listbox">
                        <div class="carousel-item active rounded">
                            <img src="/images/products/1729828751581-9174_9020_900x900_9__3_.jpg"
                                class="img-fluid w-100 h-100 bg-secondary rounded" alt="First slide">
                            <a href="#" class="btn px-4 py-2 text-white rounded">Gaming</a>
                        </div>
                        <div class="carousel-item rounded">
                            <img src="/images/products/1729829308254-8982_laptop_lg_gram.jpg"
                                class="img-fluid w-100 h-100 rounded" alt="Second slide">
                            <a href="#" class="btn px-4 py-2 text-white rounded">Mỏng nhẹ</a>
                        </div>
                        <div class="carousel-item rounded">
                            <img src="/images/products/1729828946672-8912_m__n_h__nh.jpg"
                                class="img-fluid w-100 h-100 rounded" alt="Second slide">
                            <a href="#" class="btn px-4 py-2 text-white rounded">Đồ họa</a>
                        </div>
                        <div class="carousel-item rounded">
                            <img src="/images/products/1729080999419-lenovoV14G4.jpg"
                                class="img-fluid w-100 h-100 rounded" alt="Second slide">
                            <a href="#" class="btn px-4 py-2 text-white rounded">Văn phòng</a>
                        </div>
                        <div class="carousel-item rounded">
                            <img src="/images/products/1729829776298-8902_dell_xps_13_9340_t7n66aaaa.jpg"
                                class="img-fluid w-100 h-100 rounded" alt="Second slide">
                            <a href="#" class="btn px-4 py-2 text-white rounded">Doanh nhân</a>
                        </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselId"
                        data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselId"
                        data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Hero End -->