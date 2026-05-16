package controller;

import java.io.IOException;
import java.util.List;

import dao.BookingDAO;
import daoImpl.BookingDAOImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Booking;
import model.User;

@WebServlet("/bookingHistory")
public class BookingHistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session =
                req.getSession();

        User user =
                (User)session.getAttribute(
                        "loggedUser"
                );

        if(user == null) {

            resp.sendRedirect("login.jsp");

            return;
        }

        BookingDAO bdao =
                new BookingDAOImpl();

        List<Booking> bookingList =
                bdao.getBookingsByUserId(
                        user.getUserId()
                );

        req.setAttribute(
                "bookingList",
                bookingList
        );

        RequestDispatcher rd =
                req.getRequestDispatcher(
                        "bookingHistory.jsp"
                );

        rd.forward(req, resp);
    }
}