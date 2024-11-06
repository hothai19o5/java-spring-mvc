<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Table Users</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
    <link href="/css/styles.css" rel="stylesheet" />
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
                        <div class="row">
                            <div class="col-12 mx-auto">
                                <div class="d-flex justify-content-between">
                                    <h3>Table Users</h3>
                                    <a href="/admin/user/create" class="btn btn-primary">Create User</a>
                                </div>
                                <hr />
                                <table class="table table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th scope="col">ID</th>
                                            <th scope="col">Email</th>
                                            <th scope="col">FullName</th>
                                            <th scope="col">Role</th>
                                            <th scope="col">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="user" items="${users}">
                                            <tr>
                                                <th>${user.id}</th>
                                                <td>${user.email}</td>
                                                <td>${user.fullName}</td>
                                                <td>${user.role.name}</td>
                                                <td>
                                                    <a href="/admin/user/${user.id}"
                                                        class="btn btn-success mx-2">View</a>
                                                    <a href="/admin/user/update/${user.id}"
                                                        class="btn btn-warning mx-1">Update</a>
                                                    <a href="/admin/user/delete/${user.id}"
                                                        class="btn btn-danger mx-2">Delete</a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                                <nav aria-label="...">
                                    <ul class="pagination justify-content-center">
                                        <li class="page-item ${currentPage eq 1 ? 'disabled' : ''}">
                                            <a class="page-link" href="/admin/user?page=${currentPage - 1}">Previous</a>
                                        </li>
                                        <c:forEach begin="0" end="${totalPages-1}" varStatus="loop">
                                            <li class="page-item">
                                                <a class="${(loop.index + 1) eq currentPage ? 'active' : ''} page-link" href="/admin/user?page=${loop.index+1}">${loop.index+1}</a>
                                            </li>
                                        </c:forEach>
                                        <li class="page-item ${currentPage eq (totalPages) ? 'disabled' : ''}">
                                            <a class="page-link" href="/admin/user?page=${currentPage + 1}">Next</a>
                                        </li>
                                    </ul>
                                </nav>
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