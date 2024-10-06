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
                                        <th scope="row">Email:</th>
                                        <td>${user.email}</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">FullName:</th>
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
                                </tbody>
                            </table>
                        </div>
                    </div>

                </div>
            </body>

            </html>