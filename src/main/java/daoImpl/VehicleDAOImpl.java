package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.VehicleDAO;
import model.Vehicle;
import util.DBConnection;

public class VehicleDAOImpl implements VehicleDAO {
private Connection connection = DBConnection.getConnection();

@Override
public boolean addVehicle(Vehicle vehicle) {
String query = "INSERT INTO vehicles (vehicle_name,type, brand, price_per_day, is_available) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, vehicle.getName());
            ps.setString(2, vehicle.getType());
            ps.setString(3, vehicle.getBrand());
            ps.setDouble(4, vehicle.getPricePerDay());
            ps.setBoolean(5, vehicle.isAvailable());

            return ps.executeUpdate() > 0;
} catch (SQLException e) {
            e.printStackTrace();
        }
return false;
    }

@Override
public List<Vehicle> getAllVehicles() {
List<Vehicle> list = new ArrayList<>();
String query = "SELECT * FROM vehicles";
try (PreparedStatement ps = connection.prepareStatement(query);
       ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
            Vehicle v = new Vehicle();

                v.setVehicleId(rs.getInt("vehicle_id"));
                v.setName(rs.getString("vehicle_name"));
                v.setType(rs.getString("type"));
                v.setBrand(rs.getString("brand"));
                v.setPricePerDay(rs.getDouble("price_per_day"));
                v.setAvailable(rs.getBoolean("is_available"));

                list.add(v);
            }
} catch (SQLException e) {
            e.printStackTrace();
        }
return list;
    }

@Override
public List<Vehicle> getAvailableVehicles() {
List<Vehicle> list = new ArrayList<>();
 String query = "SELECT * FROM vehicles WHERE available = true";
 try (PreparedStatement ps = connection.prepareStatement(query);
          ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Vehicle v = new Vehicle();

                v.setVehicleId(rs.getInt("vehicle_id"));
                v.setName(rs.getString("vehicle_name"));
                v.setType(rs.getString("type"));
                v.setBrand(rs.getString("brand"));
                v.setPricePerDay(rs.getDouble("price_per_day"));
                v.setAvailable(rs.getBoolean("is_available"));

                list.add(v);
            }
} catch (SQLException e) {
            e.printStackTrace();
        }
return list;
    }

@Override
public Vehicle getVehicleById(int vehicleId) {
String query = "SELECT * FROM vehicles WHERE vehicle_id = ?";
 try (PreparedStatement ps = connection.prepareStatement(query)) {
               ps.setInt(1, vehicleId);
               ResultSet rs = ps.executeQuery();

            if (rs.next()) {
             Vehicle v = new Vehicle();

                v.setVehicleId(rs.getInt("vehicle_id"));
                v.setName(rs.getString("vehicle_name"));
                v.setType(rs.getString("type"));
                v.setBrand(rs.getString("brand"));
                v.setPricePerDay(rs.getDouble("price_per_day"));
                v.setAvailable(rs.getBoolean("is_available"));

                return v;
            }
} catch (SQLException e) {
            e.printStackTrace();
        }
return null;
    }

@Override
public boolean updateVehicle(Vehicle vehicle) {
String query = "UPDATE vehicles SET vehicle_name=?,type=?, brand=?, price_per_day=?, is_available=? WHERE vehicle_id=?";
try (PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, vehicle.getName());
            ps.setString(2,vehicle.getType());
            ps.setString(3, vehicle.getBrand());
            ps.setDouble(4, vehicle.getPricePerDay());
            ps.setBoolean(5, vehicle.isAvailable());
            ps.setInt(6, vehicle.getVehicleId());

            return ps.executeUpdate() > 0;
 } catch (SQLException e) {
            e.printStackTrace();
        }
 return false;
    }

@Override
public boolean deleteVehicle(int vehicleId) {
String query = "DELETE FROM vehicles WHERE vehicle_id = ?";
 try (PreparedStatement ps = connection.prepareStatement(query)) {
       ps.setInt(1, vehicleId);
        return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
 return false;
    }

@Override
public boolean updateAvailability(int vehicleId, boolean isAvailable) {
 String query = "UPDATE vehicles SET available = ? WHERE vehicle_id = ?";
 try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setBoolean(1, isAvailable);
            ps.setInt(2, vehicleId);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
 return false;
    }
}