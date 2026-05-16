package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import dao.BookingDAO;
import dao.VehicleDAO;
import daoImpl.BookingDAOImpl;
import daoImpl.VehicleDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Booking;

@WebServlet("/confirmBooking")
public class BookingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        int userId =
                Integer.parseInt(
                        req.getParameter("userId")
                );

        int vehicleId =
                Integer.parseInt(
                        req.getParameter("vehicleId")
                );

        LocalDate startDate =
                LocalDate.parse(
                        req.getParameter("startDate")
                );

        LocalDate endDate =
                LocalDate.parse(
                        req.getParameter("endDate")
                );

        double totalPrice =
                Double.parseDouble(
                        req.getParameter("totalPrice")
                );

        Booking booking = new Booking();

        booking.setUserId(userId);

        booking.setVehicleId(vehicleId);

        booking.setStartDate(startDate);

        booking.setEndDate(endDate);

        booking.setTotalPrice(totalPrice);

        booking.setStatus("BOOKED");

        booking.setCreatedAt(
                LocalDateTime.now()
        );

        BookingDAO bdao =
                new BookingDAOImpl();

        boolean isBooked =
                bdao.createBooking(booking);

        if(isBooked) {

            VehicleDAO vdao =
                    new VehicleDAOImpl();

            vdao.updateAvailability(
                    vehicleId,
                    false
            );

            resp.sendRedirect(
                    "bookingHistory"
            );

        } else {

            resp.sendRedirect("error.jsp");
        }
    }
}