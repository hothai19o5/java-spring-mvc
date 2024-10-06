<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Delete User ${id}</title>
                <!-- Latest compiled and minified CSS -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
                <!-- Latest compiled JavaScript -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
            </head>

            <body>
                <div class="container mt-5">
                    <div class="row">
                        <div class="col-md-6 col-12 mx-auto">
                            <form:form action="/admin/user/delete" method="post" modelAttribute="user">
                                <h3>Delete User With ID = ${id}</h3>
                                <hr />
                                <div class="alert alert-danger" role="alert">
                                    Are you sure to delete this user ?
                                </div>
                                <div class="mb-3" style="display: none;">
                                    <label class="form-label">Id:</label>
                                    <form:input type="text" class="form-control" path="id" />
                                </div>
                                <div class="d-flex justify-content-between">
                                    <button type="submit" class="btn btn-danger">Confirm</button>
                                    <a href="http://localhost:8080/admin/user" class="btn btn-primary">Back</a>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>

            </body>

            </html>