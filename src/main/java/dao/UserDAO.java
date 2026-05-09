package dao;

import java.util.List;

import model.User;

public interface UserDAO {

    boolean registerUser(User user);

    User login(String email, String password);

    User getUserById(int userId);

    List<User> getAllUsers(); // admin use

    boolean updateUser(User user);

    boolean deleteUser(int userId);
}