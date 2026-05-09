package dao;

import java.util.List;

import model.Booking;

public interface BookingDAO {

    boolean createBooking(Booking booking);

    Booking getBookingById(int bookingId);

    List<Booking> getBookingsByUserId(int userId);

    List<Booking> getAllBookings(); // admin

    boolean updateBookingStatus(int bookingId, String status);

    boolean cancelBooking(int bookingId);
}