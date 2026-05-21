package daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import dao.UserDAO;
import model.User;
import util.DBConnection;

public class UserDAOImpl implements UserDAO {

 private Connection connection = DBConnection.getConnection();

 @Override
 public boolean registerUser(User user) {
String query ="INSERT INTO users(name,email,password,phone,role) VALUES(?,?,?,?,?)";
 try {
        PreparedStatement ps = connection.prepareStatement(query);
           ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setLong(4, user.getPhone());
            ps.setString(5, user.getRole());

            return ps.executeUpdate() > 0;
} catch (SQLException e) {
    e.printStackTrace();
   }
return false;
    }
 @Override
    public User login(String email, String password) {
String query ="SELECT * FROM users WHERE email=? AND password=?";
try {
PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

        if (rs.next()) {
        User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getLong("phone"));
                user.setRole(rs.getString("role"));

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
return null;
    }

@Override
public User getUserById(int userId) {
String query = "SELECT * FROM users WHERE user_id=?";
try {
PreparedStatement ps = connection.prepareStatement(query);
ps.setInt(1, userId);

        ResultSet rs = ps.executeQuery();

            if (rs.next()) {
             User user = new User();
               user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getLong("phone"));
                user.setRole(rs.getString("role"));

                return user;
            }
} catch (SQLException e) {
            e.printStackTrace();
        }
return null;
    }

@Override
public List<User> getAllUsers() {
List<User> users = new ArrayList<>();
String query = "SELECT * FROM users";
try {
PreparedStatement ps = connection.prepareStatement(query);
ResultSet rs = ps.executeQuery();

       while (rs.next()) {
          User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getLong("phone"));
                user.setRole(rs.getString("role"));

                users.add(user);
            }
 } catch (SQLException e) {
            e.printStackTrace();
        }
 return users;
    }
 @Override
 public boolean updateUser(User user) {
String query ="UPDATE users SET name=?,email=?,phone=? WHERE user_id=?";
 try {
 PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setLong(3, user.getPhone());
            ps.setInt(4, user.getUserId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
  return false;
    }

    @Override
    public boolean deleteUser(int userId) {
 String query = "DELETE FROM users WHERE user_id=?";
try {
PreparedStatement ps = connection.prepareStatement(query);
ps.setInt(1, userId);
return ps.executeUpdate() > 0;
} catch (SQLException e) {
            e.printStackTrace();
        }
 return false;
    }
}