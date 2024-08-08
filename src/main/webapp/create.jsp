<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/8/2024
  Time: 10:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Mặt Bằng</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h1>Thêm Mặt Bằng</h1>
    <form action="floorplans" method="post">
        <div class="form-group">
            <label for="id">Mã mặt bằng</label>
            <input type="text" class="form-control" id="id" name="id" required>
        </div>
        <div class="form-group">
            <label for="area">Diện tích (m²)</label>
            <input type="number" class="form-control" id="area" name="area" step="0.01" required>
        </div>
        <div class="form-group">
            <label for="status">Trạng thái</label>
            <select class="form-control" id="status" name="status">
                <option value="Trong">Trong</option>
                <option value="Ha tang">Ha tang</option>
                <option value="Day du">Day du</option>
            </select>
        </div>
        <div class="form-group">
            <label for="floor">Tầng</label>
            <input type="number" class="form-control" id="floor" name="floor" min="1" max="15" required>
        </div>
        <div class="form-group">
            <label for="roomType">Loại văn phòng</label>
            <select class="form-control" id="roomType" name="roomType">
                <option value="Van phong chia se">Van phong chia se</option>
                <option value="Van phong tron goi">Van phong tron goi</option>
            </select>
        </div>
        <div class="form-group">
            <label for="description">Mô tả chi tiết</label>
            <textarea class="form-control" id="description" name="description" rows="3"></textarea>
        </div>
        <div class="form-group">
            <label for="rentPrice">Giá thuê (VNĐ)</label>
            <input type="number" class="form-control" id="rentPrice" name="rentPrice" step="0.01" required>
        </div>
        <div class="form-group">
            <label for="startDate">Ngày bắt đầu</label>
            <input type="date" class="form-control" id="startDate" name="startDate" required>
        </div>
        <div class="form-group">
            <label for="endDate">Ngày kết thúc</label>
            <input type="date" class="form-control" id="endDate" name="endDate">
        </div>
        <button type="submit" class="btn btn-primary">Thêm</button>
        <a href="floorplans" class="btn btn-secondary">Hủy</a>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

