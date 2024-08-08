package controller;

import model.FloorPlan;
import service.FloorPlanDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "floorPlanController", value = "/floorplans")
public class FloorPlanController extends HttpServlet {

    private static FloorPlanDAO floorPlanDAO = new FloorPlanDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "create":
                formCreate(request, response);
                break;
            case "delete":
                deleteFloorPlan(request, response);
                break;
            case "search":
                searchFloorPlansByPrice(request, response);
                break;
            default:
                listFloorPlan(request, response);
                break;
        }

    }

    private void searchFloorPlansByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double minPrice = Double.parseDouble(request.getParameter("minPrice"));
        double maxPrice = Double.parseDouble(request.getParameter("maxPrice"));

        List<FloorPlan> listFloorPlan = floorPlanDAO.searchFloorPlansByPrice(minPrice, maxPrice);
        request.setAttribute("listFloorPlan", listFloorPlan);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    private static void listFloorPlan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<FloorPlan> listFloorPlan = floorPlanDAO.showAllFloorPlan();
        request.setAttribute("listFloorPlan", listFloorPlan);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    private void formCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteFloorPlan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        boolean success = floorPlanDAO.deleteFloorPlanById(id);

        if (success) {
            request.setAttribute("message", "Floor plan deleted successfully!");
        } else {
            request.setAttribute("message", "Error deleting floor plan.");
        }

        listFloorPlan(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        double area = Double.parseDouble(request.getParameter("area"));
        String status = request.getParameter("status");
        int floor = Integer.parseInt(request.getParameter("floor"));
        String roomType = request.getParameter("roomType");
        String description = request.getParameter("description");
        double rentPrice = Double.parseDouble(request.getParameter("rentPrice"));
        LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));
        LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));

        FloorPlan newFloorPlan = new FloorPlan(id, area, status, floor, roomType, description, rentPrice, startDate, endDate);
        floorPlanDAO.createFloorPlan(newFloorPlan);

        response.sendRedirect("floorplans");
    }
}
