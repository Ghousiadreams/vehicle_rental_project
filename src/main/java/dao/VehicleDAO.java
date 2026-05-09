package dao;

import java.util.List;

import model.Vehicle;

public interface VehicleDAO {

    boolean addVehicle(Vehicle vehicle); // admin

    List<Vehicle> getAllVehicles();

    List<Vehicle> getAvailableVehicles();

    Vehicle getVehicleById(int vehicleId);

    boolean updateVehicle(Vehicle vehicle); // admin

    boolean deleteVehicle(int vehicleId); // admin

    boolean updateAvailability(int vehicleId, boolean isAvailable);
}
