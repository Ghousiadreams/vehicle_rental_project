package controller;

import java.io.IOException;
import java.time.LocalDateTime;

import dao.PaymentDAO;
import daoImpl.PaymentDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Payment;

@WebServlet("/makePayment")
public class PaymentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        int bookingId =
                Integer.parseInt(
                        req.getParameter("bookingId")
                );

        int userId =
                Integer.parseInt(
                        req.getParameter("userId")
                );

        double amount =
                Double.parseDouble(
                        req.getParameter("amount")
                );

        String paymentMethod =
                req.getParameter("paymentMethod");

        Payment payment = new Payment();

        payment.setBookingId(bookingId);

        payment.setUserId(userId);

        payment.setAmount(amount);

        payment.setPaymentMethod(paymentMethod);

        payment.setPaymentStatus("SUCCESS");

        payment.setPaymentDate(
                LocalDateTime.now()
        );

        PaymentDAO pdao =
                new PaymentDAOImpl();

        boolean isPaid =
                pdao.makePayment(payment);

        if(isPaid) {

            resp.sendRedirect(
                    "bookingHistory"
            );

        } else {

            resp.sendRedirect("error.jsp");
        }
    }
}