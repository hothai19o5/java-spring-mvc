<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Show User ${id}</title>
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
                                <h1 class="mt-4">Manage User</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item active"><a style="text-decoration: none;"
                                            href="/admin">Dashboard</a>/ <a style="text-decoration: none;"
                                            href="/admin/user">User</a>
                                    </li>
                                </ol>
                                <div class="mt-5">
                                    <div class="d-flex justify-content-between">
                                        <h3>Detail User ${id}</h3>
                                        <a href="/admin/user" class="btn btn-primary">Back</a>
                                    </div>
                                    <hr />
                                    <div class="card">
                                        <div class="card-header">
                                            Details User
                                        </div>
                                        <div class="card-body">
                                            <table class="table">
                                                <tbody>
                                                    <tr>
                                                        <th scope="row">ID:</th>
                                                        <td>${user.id}</td>
                                                    </tr>
                                                    <tr>
                                                        <th scope="row">Name:</th>
                                                        <td>${user.fullName}</td>
                                                    </tr>
                                                    <tr>
                                                        <th scope="row">Address:</th>
                                                        <td>${user.address}</td>
                                                    </tr>
                                                    <tr>
                                                        <th scope="row">Phone:</th>
                                                        <td>${user.phone}</td>
                                                    </tr>
                                                    <tr>
                                                        <th scope="row">Password:</th>
                                                        <td>${user.password}</td>
                                                    </tr>
                                                    <tr>
                                                        <th scope="row">Avatar:</th>
                                                        <td>
                                                            <img style="max-height: 500px; max-width: 100%; object-fit: contain;"
                                                                src="/avatar/${user.avatar}" alt="image avatar">
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