package service;

import model.FloorPlan;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FloorPlanDAO implements IFloorPlanService{

    public static Connection getConnection() {
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/practicing_test";
        String user = "root";
        String password = "012345";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("Ket noi thanh cong");
        }catch (SQLException e) {
            System.out.println("Loi ket noi");
        }
        return connection;
    }

    @Override
    public List<FloorPlan> showAllFloorPlan() {
        List<FloorPlan> floorPlanList = new ArrayList<>();
        String sql = "SELECT * FROM FloorPlan ORDER BY area";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                double area = resultSet.getDouble("area");
                String status = resultSet.getString("status");
                int floor = resultSet.getInt("floor");
                String roomType = resultSet.getString("roomType");
                String description = resultSet.getString("description");
                double rentPrice = resultSet.getDouble("rentPrice");
                LocalDate startDate = resultSet.getDate("startDate").toLocalDate();
                LocalDate endDate = resultSet.getDate("endDate").toLocalDate();
                FloorPlan floorPlan = new FloorPlan(id, area, status, floor, roomType, description, rentPrice, startDate, endDate);
                floorPlanList.add(floorPlan);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn: " + e.getMessage());
        }
        return floorPlanList;
    }

    @Override
    public void createFloorPlan(FloorPlan floorPlan) {
        String sql = "INSERT INTO FloorPlan (id, area, status, floor, roomType, description, rentPrice, startDate, endDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, floorPlan.getId());
            preparedStatement.setDouble(2, floorPlan.getArea());
            preparedStatement.setString(3, floorPlan.getStatus());
            preparedStatement.setInt(4, floorPlan.getFloor());
            preparedStatement.setString(5, floorPlan.getRoomType());
            preparedStatement.setString(6, floorPlan.getDescription());
            preparedStatement.setDouble(7, floorPlan.getRentPrice());

            if (floorPlan.getStartDate() != null) {
                preparedStatement.setDate(8, java.sql.Date.valueOf(floorPlan.getStartDate()));
            } else {
                preparedStatement.setNull(8, Types.DATE);
            }

            if (floorPlan.getEndDate() != null) {
                preparedStatement.setDate(9, java.sql.Date.valueOf(floorPlan.getEndDate()));
            } else {
                preparedStatement.setNull(9, Types.DATE);
            }

            preparedStatement.executeUpdate();
            System.out.println("Floor plan created successfully");
        } catch (SQLException e) {
            System.out.println("Error creating floor plan: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public FloorPlan findFloorPlanById(String id) {
        FloorPlan floorPlan = null;
        String sql = "SELECT * FROM FloorPlan WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String retrievedId = resultSet.getString("id");
                double area = resultSet.getDouble("area");
                String status = resultSet.getString("status");
                int floor = resultSet.getInt("floor");
                String roomType = resultSet.getString("roomType");
                String description = resultSet.getString("description");
                double rentPrice = resultSet.getDouble("rentPrice");
                LocalDate startDate = resultSet.getDate("startDate").toLocalDate();
                LocalDate endDate = resultSet.getDate("endDate").toLocalDate();

                floorPlan = new FloorPlan(retrievedId, area, status, floor, roomType, description, rentPrice, startDate, endDate);
            }

        } catch (SQLException e) {
            System.out.println("Error finding floor plan by id: " + e.getMessage());
            throw new RuntimeException(e);
        }

        return floorPlan;
    }

    @Override
    public boolean deleteFloorPlanById(String id) {
        String sql = "DELETE FROM FloorPlan WHERE id = ?";
        boolean rowDeleted = false;

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, id);

            rowDeleted = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error deleting floor plan by id: " + e.getMessage());
            throw new RuntimeException(e);
        }

        return rowDeleted;
    }

    public List<FloorPlan> searchFloorPlansByPrice(double minPrice, double maxPrice) {
        List<FloorPlan> floorPlanList = new ArrayList<>();
        String sql = "SELECT * FROM FloorPlan WHERE rentPrice BETWEEN ? AND ? ORDER BY area";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setDouble(1, minPrice);
            preparedStatement.setDouble(2, maxPrice);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                double area = resultSet.getDouble("area");
                String status = resultSet.getString("status");
                int floor = resultSet.getInt("floor");
                String roomType = resultSet.getString("roomType");
                String description = resultSet.getString("description");
                double rentPrice = resultSet.getDouble("rentPrice");
                LocalDate startDate = resultSet.getDate("startDate").toLocalDate();
                LocalDate endDate = resultSet.getDate("endDate").toLocalDate();

                FloorPlan floorPlan = new FloorPlan(id, area, status, floor, roomType, description, rentPrice, startDate, endDate);
                floorPlanList.add(floorPlan);
            }

        } catch (SQLException e) {
            System.out.println("Error searching floor plans by price: " + e.getMessage());
            throw new RuntimeException(e);
        }

        return floorPlanList;
    }



}
