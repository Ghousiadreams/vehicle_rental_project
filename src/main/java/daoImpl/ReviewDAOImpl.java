package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.ReviewDAO;
import model.Review;
import util.DBConnection;

public class ReviewDAOImpl implements ReviewDAO {
private Connection connection = DBConnection.getConnection();

@Override
public boolean addReview(Review review) {
String query = "INSERT INTO reviews (user_id, vehicle_id, rating, comment) VALUES (?, ?, ?, ?)";
 try (PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, review.getUserId());
            ps.setInt(2, review.getVehicleId());
            ps.setInt(3, review.getRating());
            ps.setString(4, review.getComment());

            return ps.executeUpdate() > 0;
 } catch (SQLException e) {
            e.printStackTrace();
        }
 return false;
    }

@Override
public List<Review> getReviewsByVehicleId(int vehicleId) {
List<Review> reviews = new ArrayList<>();
String query = "SELECT * FROM reviews WHERE vehicle_id = ?";
try (PreparedStatement ps = connection.prepareStatement(query)) {
        ps.setInt(1, vehicleId);
        ResultSet rs = ps.executeQuery();

            while (rs.next()) {
             Review review = new Review();

                review.setReviewId(rs.getInt("review_id"));
                review.setUserId(rs.getInt("user_id"));
                review.setVehicleId(rs.getInt("vehicle_id"));
                review.setRating(rs.getInt("rating"));
                review.setComment(rs.getString("comment"));

                reviews.add(review);
            }
 } catch (SQLException e) {
            e.printStackTrace();
        }
 return reviews;
    }

@Override
public List<Review> getReviewsByUserId(int userId) {
 List<Review> reviews = new ArrayList<>();
 String query = "SELECT * FROM reviews WHERE user_id = ?";
 try (PreparedStatement ps = connection.prepareStatement(query)) {
          ps.setInt(1, userId);
          ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            Review review = new Review();

                review.setReviewId(rs.getInt("review_id"));
                review.setUserId(rs.getInt("user_id"));
                review.setVehicleId(rs.getInt("vehicle_id"));
                review.setRating(rs.getInt("rating"));
                review.setComment(rs.getString("comment"));

                reviews.add(review);
            }
} catch (SQLException e) {
            e.printStackTrace();
        }
 return reviews;
    }

@Override
public boolean deleteReview(int reviewId) {
 String query = "DELETE FROM reviews WHERE review_id = ?";
try (PreparedStatement ps = connection.prepareStatement(query)) {
              ps.setInt(1, reviewId);
              return ps.executeUpdate() > 0;
              } catch (SQLException e) {
            e.printStackTrace();
        }
 return false;
    }
}