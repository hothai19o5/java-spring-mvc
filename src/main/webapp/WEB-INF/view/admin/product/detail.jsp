<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show Product ${id}</title>
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
                    <h1 class="mt-4">Manage Product</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item active"><a style="text-decoration: none;"
                                href="/admin">Dashboard</a>/ <a style="text-decoration: none;"
                                href="/admin/product">Product</a>
                        </li>
                    </ol>
                    <div class="mt-5">
                        <div class="d-flex justify-content-between">
                            <h3>Detail Product ${id}</h3>
                            <a href="http://localhost:8080/admin/product" class="btn btn-primary">Back</a>
                        </div>
                        <hr />
                        <div class="card">
                            <div class="card-header">
                                Details Product
                            </div>
                            <div class="card-body">
                                <table class="table">
                                    <tbody>
                                        <tr>
                                            <th scope="row">ID:</th>
                                            <td>${product.id}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Name:</th>
                                            <td>${product.name}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Price:</th>
                                            <td>
                                                <fmt:formatNumber type="number" value="${product.price}" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <th scope="row">ShortDesc:</th>
                                            <td>${product.shortDesc}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">DetailDesc:</th>
                                            <td>${product.detailDesc}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Quantity:</th>
                                            <td>${product.quantity}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Sold:</th>
                                            <td>${product.sold}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Factory:</th>
                                            <td>${product.factory}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Target:</th>
                                            <td>${product.target}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Image:</th>
                                            <td><img style="max-height: 500px; max-width: 1000px; object-fit: contain;"
                                                    src="/products/${product.image}" alt="image product">
                                            </td>
                                        </tr>
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