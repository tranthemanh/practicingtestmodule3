package model;

import java.time.LocalDate;

public class FloorPlan {
    private String id;
    private double area;
    private String status;
    private int floor;
    private String roomType;
    private String description;
    private double rentPrice;
    private LocalDate startDate;
    private LocalDate endDate;

    public FloorPlan() {
    }

    public FloorPlan(String id, double area, String status, int floor, String roomType, String description, double rentPrice, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.area = area;
        this.status = status;
        this.floor = floor;
        this.roomType = roomType;
        this.description = description;
        this.rentPrice = rentPrice;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
