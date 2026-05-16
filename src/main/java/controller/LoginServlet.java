package controller;

import java.io.IOException;

import dao.UserDAO;
import daoImpl.UserDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        String email =
                req.getParameter("email");

        String password =
                req.getParameter("password");

        UserDAO udao = new UserDAOImpl();

        User user =
                udao.login(email, password);

        if(user != null) {

            HttpSession session =
                    req.getSession();

            session.setAttribute(
                    "loggedUser",
                    user
            );

            if(user.getRole().equals("admin")) {

                resp.sendRedirect("adminDashboard.jsp");

            } else {

                resp.sendRedirect("home");
            }

        } else {

            resp.sendRedirect("error.jsp");
        }
    }
}