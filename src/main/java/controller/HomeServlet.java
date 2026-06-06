package controller;

import java.io.IOException;
import java.util.List;

import dao.VehicleDAO;
import daoImpl.VehicleDAOImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Vehicle;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        VehicleDAO vdao =
                new VehicleDAOImpl();

        List<Vehicle> vehicleList =
                vdao.getAvailableVehicles();

        req.setAttribute(
                "vehicleList",
                vehicleList
        );

        RequestDispatcher rd =
                req.getRequestDispatcher(
                        "dashboard.jsp"
                );

        rd.forward(req, resp);
    }
}