package dao;

import java.util.List;

import model.Payment;

public interface PaymentDAO {

    boolean makePayment(Payment payment);

    Payment getPaymentById(int paymentId);

    List<Payment> getPaymentsByUserId(int userId);

    List<Payment> getAllPayments(); // admin
}