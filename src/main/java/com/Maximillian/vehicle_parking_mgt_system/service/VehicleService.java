package com.Maximillian.vehicle_parking_mgt_system.service;

import com.Maximillian.vehicle_parking_mgt_system.dto.request.VehicleRequest;
import com.Maximillian.vehicle_parking_mgt_system.dto.response.VehicleResponse;


import java.util.List;

public interface VehicleService {
    VehicleResponse addVehicle(VehicleRequest vehicleRequest);

    VehicleRequest getVehicle(String vehicleId);

    List<VehicleRequest> getAllVehicle();

    VehicleResponse deleteVehicle(String vehicleId);

    VehicleRequest searchVehicle(String numberPlate);
}
