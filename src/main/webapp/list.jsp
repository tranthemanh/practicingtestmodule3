<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/8/2024
  Time: 9:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quan Ly Mat bang</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<style>
    .table {
        font-size: 13px;
    }

    a:hover {
        text-decoration: none;
        color: #fff;
    }

    .middle {
        /* Any additional styling can go here */
    }
</style>
<body>

<div class="container mt-4">
    <h1>Quan Ly Mat bang</h1>

    <form method="get" action="${pageContext.request.contextPath}/floorplans">
        <input type="hidden" name="action" value="search"/>
        <div class="form-group">
            <label for="minPrice">Min Price:</label>
            <input type="number" step="0.01" class="form-control" id="minPrice" name="minPrice" required>
        </div>
        <div class="form-group">
            <label for="maxPrice">Max Price:</label>
            <input type="number" step="0.01" class="form-control" id="maxPrice" name="maxPrice" required>
        </div>
        <button type="submit" class="btn btn-primary">Search</button>
    </form>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>Ma mat bang</th>
            <th>Dien Tich (m²)</th>
            <th>Trang Thai</th>
            <th>Tang</th>
            <th>Lai van phong</th>
            <th>Mo ta chi tiet</th>
            <th>Gia</th>
            <th>Ngay bat dau</th>
            <th>Ngay ket thuc</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:set var="count" value="0" scope="page"/>
        <c:forEach var="floorPlan" items="${listFloorPlan}">
            <tr class="middle">
                <td><c:out value="${floorPlan.id}"/></td>
                <td><c:out value="${floorPlan.area}"/></td>
                <td><c:out value="${floorPlan.status}"/></td>
                <td><c:out value="${floorPlan.floor}"/></td>
                <td><c:out value="${floorPlan.roomType}"/></td>
                <td><c:out value="${floorPlan.description}"/></td>
                <td><c:out value="${floorPlan.rentPrice}"/></td>
                <td><c:out value="${floorPlan.startDate}"/></td>
                <td><c:out value="${floorPlan.endDate}"/></td>

                <td>
                    <a href="#" class="btn btn-danger btn-sm"
                       onclick="confirmDelete('${floorPlan.id}')">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="${pageContext.request.contextPath}/floorplans?action=create" class="btn btn-primary">Add New</a>
</div>

<script>
    function confirmDelete(id) {
        if (confirm("Bạn có chắc chắn muốn xóa mặt bằng với mã số " + id + " không?")) {
            window.location.href = "${pageContext.request.contextPath}/floorplans?action=delete&id=" + id;
        }
    }
</script>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

