<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Show User</title>
                <!-- Latest compiled and minified CSS -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
                <!-- Latest compiled JavaScript -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
            </head>

            <body>
                <div class="container mt-5">
                    <div class="d-flex justify-content-between">
                        <h3>Detail User</h3>
                        <a href="http://localhost:8080/admin/user" class="btn btn-primary">Back</a>
                    </div>
                    <hr />
                    <table class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Email</th>
                                <th scope="col">FullName</th>
                                <th scope="col">Address</th>
                                <th scope="col">Phone</th>
                                <th scope="col">Password</th>

                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th>${user.id}</th>
                                <td>${user.email}</td>
                                <td>${user.fullName}</td>
                                <td>${user.address}</td>
                                <td>${user.phone}</td>
                                <td>${user.password}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </body>

            </html>