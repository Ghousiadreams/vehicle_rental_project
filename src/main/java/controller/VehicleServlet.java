package controller;

import java.io.IOException;
import java.time.LocalDateTime;

import dao.VehicleDAO;
import daoImpl.VehicleDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Vehicle;

@WebServlet("/addVehicle")
public class VehicleServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        String name =
                req.getParameter("name");

        String type =
                req.getParameter("type");

        String brand =
                req.getParameter("brand");

        double pricePerDay =
                Double.parseDouble(
                        req.getParameter(
                                "pricePerDay"
                        )
                );

        boolean available =
                Boolean.parseBoolean(
                        req.getParameter(
                                "available"
                        )
                );

        String imageUrl =
                req.getParameter("imageUrl");

        Vehicle vehicle = new Vehicle();

        vehicle.setName(name);
        vehicle.setType(type);
        vehicle.setBrand(brand);

        vehicle.setPricePerDay(pricePerDay);

        vehicle.setAvailable(available);

        vehicle.setImageUrl(imageUrl);

        vehicle.setCreatedAt(
                LocalDateTime.now()
        );

        VehicleDAO vdao =
                new VehicleDAOImpl();

        boolean isAdded =
                vdao.addVehicle(vehicle);

        if(isAdded) {

            resp.sendRedirect("home");

        } else {

            resp.sendRedirect("error.jsp");
        }
    }
}