package model;

import java.time.LocalDateTime;

public class Review {

    private int reviewId;
    private int userId;
    private int vehicleId;

    private int rating;

    private String comment;

    private LocalDateTime createdAt;

    public Review() {
    }

    public Review(int reviewId, int userId, int vehicleId,
                  int rating, String comment,
                  LocalDateTime createdAt) {

        this.reviewId = reviewId;
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.rating = rating;
        this.comment = comment;
        this.createdAt = createdAt;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Review [reviewId=" + reviewId + ", rating=" + rating
                + ", comment=" + comment + "]";
    }
}