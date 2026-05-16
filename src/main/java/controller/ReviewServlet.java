package controller;

import java.io.IOException;
import java.time.LocalDateTime;

import dao.ReviewDAO;
import daoImpl.ReviewDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Review;

@WebServlet("/addReview")
public class ReviewServlet extends HttpServlet {

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

        int rating =
                Integer.parseInt(
                        req.getParameter("rating")
                );

        String comment =
                req.getParameter("comment");

        Review review = new Review();

        review.setUserId(userId);

        review.setVehicleId(vehicleId);

        review.setRating(rating);

        review.setComment(comment);

        review.setCreatedAt(
                LocalDateTime.now()
        );

        ReviewDAO rdao =
                new ReviewDAOImpl();

        boolean isAdded =
                rdao.addReview(review);

        if(isAdded) {

            resp.sendRedirect("home");

        } else {

            resp.sendRedirect("error.jsp");
        }
    }
}