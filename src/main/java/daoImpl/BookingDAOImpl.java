package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.BookingDAO;
import model.Booking;
import util.DBConnection;

public class BookingDAOImpl implements BookingDAO {

    Connection con =
            DBConnection.getConnection();

    @Override
    public List<Booking> getBookingsByUserId(
            int userId
    ) {

        List<Booking> bookingList =
                new ArrayList<>();

        try {

            String query =
            "select * from bookings where user_id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, userId);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                Booking booking =
                        new Booking();

                booking.setBookingId(
                        rs.getInt("booking_id")
                );

                booking.setUserId(
                        rs.getInt("user_id")
                );

                booking.setVehicleId(
                        rs.getInt("vehicle_id")
                );

                booking.setStartDate(
                        rs.getDate("start_date")
                        .toLocalDate()
                );

                booking.setEndDate(
                        rs.getDate("end_date")
                        .toLocalDate()
                );

                booking.setTotalPrice(
                        rs.getDouble("total_price")
                );

                booking.setStatus(
                        rs.getString("status")
                );

                booking.setCreatedAt(
                        rs.getTimestamp("created_at")
                        .toLocalDateTime()
                );

                bookingList.add(booking);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bookingList;
    }

    @Override
    public boolean createBooking(Booking booking) {
        return false;
    }

    @Override
    public Booking getBookingById(int bookingId) {
        return null;
    }

    @Override
    public List<Booking> getAllBookings() {
        return null;
    }

    @Override
    public boolean updateBookingStatus(
            int bookingId,
            String status
    ) {
        return false;
    }

    @Override
    public boolean cancelBooking(int bookingId) {
        return false;
    }
}