package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.PaymentDAO;
import model.Payment;
import util.DBConnection;

public class PaymentDAOImpl implements PaymentDAO {
private Connection connection = DBConnection.getConnection();

@Override
public boolean makePayment(Payment payment) {
String query = "INSERT INTO payments (booking_id, user_id, amount, payment_method, payment_status) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, payment.getBookingId());
            ps.setInt(2, payment.getUserId());
            ps.setDouble(3, payment.getAmount());
            ps.setString(4, payment.getPaymentMethod());
            ps.setString(5, payment.getPaymentStatus());

            return ps.executeUpdate() > 0;
 } catch (SQLException e) {
            e.printStackTrace();
        }
 return false;
    }

@Override
public Payment getPaymentById(int paymentId) {
String query = "SELECT * FROM payments WHERE payment_id = ?";
try (PreparedStatement ps = connection.prepareStatement(query)) {
 ps.setInt(1, paymentId);
ResultSet rs = ps.executeQuery(); 

              if (rs.next()) {
               Payment payment = new Payment();

                payment.setPaymentId(rs.getInt("payment_id"));
                payment.setBookingId(rs.getInt("booking_id"));
                payment.setUserId(rs.getInt("user_id"));
                payment.setAmount(rs.getDouble("amount"));
                payment.setPaymentMethod(rs.getString("payment_method"));
                payment.setPaymentStatus(rs.getString("payment_status"));

                return payment;
            }
} catch (SQLException e) {
            e.printStackTrace();
        }
return null;
    }

@Override
public List<Payment> getPaymentsByUserId(int userId) {
 List<Payment> payments = new ArrayList<>();
String query = "SELECT * FROM payments WHERE user_id = ?";
 try (PreparedStatement ps = connection.prepareStatement(query)) {
  ps.setInt(1, userId);
  ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            Payment payment = new Payment();

                payment.setPaymentId(rs.getInt("payment_id"));
                payment.setBookingId(rs.getInt("booking_id"));
                payment.setUserId(rs.getInt("user_id"));
                payment.setAmount(rs.getDouble("amount"));
                payment.setPaymentMethod(rs.getString("payment_method"));
                payment.setPaymentStatus(rs.getString("payment_status"));

                payments.add(payment);
            }
} catch (SQLException e) {
            e.printStackTrace();
        }
 return payments;
    }

    @Override
    public List<Payment> getAllPayments() {
 List<Payment> payments = new ArrayList<>();
 String query = "SELECT * FROM payments";
try (PreparedStatement ps = connection.prepareStatement(query);
     ResultSet rs = ps.executeQuery()) {

       while (rs.next()) {
      Payment payment = new Payment();

                payment.setPaymentId(rs.getInt("payment_id"));
                payment.setBookingId(rs.getInt("booking_id"));
                payment.setUserId(rs.getInt("user_id"));
                payment.setAmount(rs.getDouble("amount"));
                payment.setPaymentMethod(rs.getString("payment_method"));
                payment.setPaymentStatus(rs.getString("payment_status"));

                payments.add(payment);
            }
 } catch (SQLException e) {
            e.printStackTrace();
        }
return payments;
    }
}