package daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.BookingDAO;
import model.Booking;
import util.DBConnection;

public class BookingDAOImpl implements BookingDAO {
 private Connection connection = DBConnection.getConnection();

@Override
public boolean createBooking(Booking booking) {
 String query = "INSERT INTO bookings (user_id, vehicle_id, start_date, end_date, total_price, status) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, booking.getUserId());
            ps.setInt(2, booking.getVehicleId());
            ps.setDate(3, booking.getStartDate());
            ps.setDate(4, booking.getEndDate());
            ps.setDouble(5, booking.getTotalPrice());
            ps.setString(6, booking.getStatus());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
       return false;
    }
 @Override
    public Booking getBookingById(int bookingId) {
   String query = "SELECT * FROM bookings WHERE booking_id = ?";
     try (PreparedStatement ps = connection.prepareStatement(query)) {
         ps.setInt(1, bookingId);
         ResultSet rs = ps.executeQuery();

            if (rs.next()) {
             Booking booking = new Booking();

                booking.setBookingId(rs.getInt("booking_id"));
                booking.setUserId(rs.getInt("user_id"));
                booking.setVehicleId(rs.getInt("vehicle_id"));
                booking.setStartDate(rs.getDate("start_date"));
                booking.setEndDate(rs.getDate("end_date"));
                booking.setTotalPrice(rs.getDouble("total_price"));
                booking.setStatus(rs.getString("status"));

                return booking;
            }
 } catch (SQLException e) {
            e.printStackTrace();
        }
return null;
    }

@Override
public List<Booking> getBookingsByUserId(int userId) {
 List<Booking> bookings = new ArrayList<>();
 String query = "SELECT * FROM bookings WHERE user_id = ?";
try (PreparedStatement ps = connection.prepareStatement(query)) {
       ps.setInt(1, userId);
       ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            Booking booking = new Booking();

                booking.setBookingId(rs.getInt("booking_id"));
                booking.setUserId(rs.getInt("user_id"));
                booking.setVehicleId(rs.getInt("vehicle_id"));
                booking.setStartDate(rs.getDate("start_date"));
                booking.setEndDate(rs.getDate("end_date"));
                booking.setTotalPrice(rs.getDouble("total_price"));
                booking.setStatus(rs.getString("status"));

                bookings.add(booking);
            }
} catch (SQLException e) {
            e.printStackTrace();
        }
  return bookings;
    }

    @Override
    public List<Booking> getAllBookings() {
    List<Booking> bookings = new ArrayList<>();
   String query = "SELECT * FROM bookings";
 try (PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
             Booking booking = new Booking();

                booking.setBookingId(rs.getInt("booking_id"));
                booking.setUserId(rs.getInt("user_id"));
                booking.setVehicleId(rs.getInt("vehicle_id"));
                booking.setStartDate(rs.getDate("start_date"));
                booking.setEndDate(rs.getDate("end_date"));
                booking.setTotalPrice(rs.getDouble("total_price"));
                booking.setStatus(rs.getString("status"));

                bookings.add(booking);
            }
 } catch (SQLException e) {
            e.printStackTrace();
        }
return bookings;
    }

    @Override
    public boolean updateBookingStatus(int bookingId, String status) {
 String query = "UPDATE bookings SET status = ? WHERE booking_id = ?";
 try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, status);
            ps.setInt(2, bookingId);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
  return false;
    }

    @Override
    public boolean cancelBooking(int bookingId) {
    String query = "UPDATE bookings SET status = 'Cancelled' WHERE booking_id = ?";
     try (PreparedStatement ps = connection.prepareStatement(query)) {
           ps.setInt(1, bookingId);
          return ps.executeUpdate() > 0;
 } catch (SQLException e) {
            e.printStackTrace();
        }
return false;
    }
}