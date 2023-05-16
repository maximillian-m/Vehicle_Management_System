package com.Maximillian.vehicle_parking_mgt_system.repository;

import com.Maximillian.vehicle_parking_mgt_system.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {

    Vehicle findVehicleByNumberPlate(String numberPlate);
}
