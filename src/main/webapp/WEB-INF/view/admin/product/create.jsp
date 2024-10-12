<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Create Product</title>
                <!-- Latest compiled and minified CSS -->
                <link href="/css/styles.css" rel="stylesheet" />
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
                <!-- Latest compiled JavaScript -->
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
                <script>
                    $(document).ready(() => {
                        const avatarFile = $("#productImg");
                        avatarFile.change(function (e) {
                            const imgURL = URL.createObjectURL(e.target.files[0]);
                            $("#productPreview").attr("src", imgURL);
                            $("#productPreview").css({ "display": "block" });
                        });
                    });
                </script>
            </head>

            <body class="sb-nav-fixed">
                <jsp:include page="../layout/header.jsp" />
                <div id="layoutSidenav">
                    <jsp:include page="../layout/sidebar.jsp" />
                    <div id="layoutSidenav_content">
                        <main>
                            <div class="container-fluid px-4">
                                <h1 class="mt-4">Manage Product</h1>
                                <div class="container mt-5">
                                    <div class="row">
                                        <div class="col-md-6 col-12 mx-auto">
                                            <h3>Create a product</h3>
                                            <hr />
                                            <form:form action="/admin/product/create" method="post"
                                                modelAttribute="newProduct" class="row g-3"
                                                enctype="multipart/form-data">
                                                <div class="col-md-6 mb-3">
                                                    <label class="form-label">Name:</label>
                                                    <form:input type="text" class="form-control" path="name" />
                                                </div>
                                                <div class="col-md-6 mb-3">
                                                    <label class="form-label">Price:</label>
                                                    <form:input type="text" class="form-control" path="price" />
                                                </div>
                                                <div class="col-12 mb-3">
                                                    <label class="form-label">Detail Description:</label>
                                                    <form:input type="text" class="form-control" path="detailDesc" />
                                                </div>
                                                <div class="col-md-6 mb-3">
                                                    <label class="form-label">Short Description:</label>
                                                    <form:input type="text" class="form-control" path="shortDesc" />
                                                </div>
                                                <div class="col-md-6 mb-3">
                                                    <label class="form-label">Quantity:</label>
                                                    <form:input type="text" class="form-control" path="quantity" />
                                                </div>
                                                <div class="col-md-6 mb-3">
                                                    <label class="form-label">Factory:</label>
                                                    <!-- Thêm tag form để JavaSpring quản lý -->
                                                    <form:select class="form-select" path="factory">
                                                        <form:option value="Lenovo">LENOVO</form:option>
                                                        <form:option value="HP">HP</form:option>
                                                        <form:option value="Dell">DELL</form:option>
                                                        <form:option value="Asus">ASUS</form:option>
                                                        <form:option value="Apple">APPLE</form:option>
                                                        <form:option value="Acer">ACER</form:option>
                                                        <form:option value="Msi">MSI</form:option>
                                                    </form:select>
                                                </div>
                                                <div class="col-md-6 mb-3">
                                                    <label class="form-label">Target:</label>
                                                    <!-- Thêm tag form để JavaSpring quản lý -->
                                                    <form:select class="form-select" path="target">
                                                        <form:option value="Gaming">Gaming</form:option>
                                                        <form:option value="DoHoa">Đồ họa</form:option>
                                                        <form:option value="MongNhe">Mỏng nhẹ</form:option>
                                                        <form:option value="GiaRe">Giá rẻ</form:option>
                                                    </form:select>
                                                </div>
                                                <div class="col-md-6 mb-3">
                                                    <label for="productImg" class="form-label">Image:</label>
                                                    <input class="form-control" type="file" id="productImg"
                                                        accept=".jpg, .png, .jpeg" name="productImg" />
                                                </div>
                                                <div class="col-12 mb-3 d-flex justify-content-around">
                                                    <img style="max-height: 250px; display: none;" alt="product preview"
                                                        id="productPreview">
                                                </div>
                                                <div class="col-12 mb-3 d-flex justify-content-between">
                                                    <button type="submit" class="btn btn-primary">Create</button>
                                                    <a href="/admin/product" class="btn btn-primary">Back</a>
                                                </div>
                                            </form:form>
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
            </body>

            </html>