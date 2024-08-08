package service;

import model.FloorPlan;

import java.util.List;

public interface IFloorPlanService {
    List<FloorPlan> showAllFloorPlan();

    void createFloorPlan(FloorPlan floorPlan);

    FloorPlan findFloorPlanById(String id);

    boolean deleteFloorPlanById(String id);
}
