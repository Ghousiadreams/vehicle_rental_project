package dao;

import java.util.List;

import model.Review;

public interface ReviewDAO {

    boolean addReview(Review review);

    List<Review> getReviewsByVehicleId(int vehicleId);

    List<Review> getReviewsByUserId(int userId);

    boolean deleteReview(int reviewId); // admin or owner
}
