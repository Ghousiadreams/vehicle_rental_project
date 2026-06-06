package controller;

import java.io.IOException;

import dao.UserDAO;
import daoImpl.UserDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        long phone =
                Long.parseLong(req.getParameter("phone"));

        String role = req.getParameter("role");

        User user = new User();

        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        user.setRole(role);

        UserDAO udao = new UserDAOImpl();

        boolean isRegistered =
                udao.registerUser(user);

        if(isRegistered) {

            resp.sendRedirect("login.jsp");

        } else {

            resp.sendRedirect("error.jsp");
        }
    }
}