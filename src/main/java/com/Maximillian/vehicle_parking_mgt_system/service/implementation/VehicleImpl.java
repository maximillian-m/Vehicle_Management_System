package com.Maximillian.vehicle_parking_mgt_system.service.implementation;

import com.Maximillian.vehicle_parking_mgt_system.dto.request.VehicleRequest;
import com.Maximillian.vehicle_parking_mgt_system.dto.response.VehicleResponse;
import com.Maximillian.vehicle_parking_mgt_system.entity.Category;
import com.Maximillian.vehicle_parking_mgt_system.entity.Vehicle;
import com.Maximillian.vehicle_parking_mgt_system.repository.CategoryRepository;
import com.Maximillian.vehicle_parking_mgt_system.repository.VehicleRepository;
import com.Maximillian.vehicle_parking_mgt_system.service.VehicleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class VehicleImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;
    private final CategoryRepository categoryRepository;
    @Autowired
    public VehicleImpl(VehicleRepository vehicleRepository, CategoryRepository categoryRepository) {
        this.vehicleRepository = vehicleRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public VehicleResponse addVehicle(VehicleRequest vehicleRequest) {
        log.info("Inside addVehicle of VehicleService");
        Vehicle vehicle = new Vehicle();
        BeanUtils.copyProperties(vehicleRequest, vehicle);
        Category category = categoryRepository.findCategoriesByCategoryName(vehicleRequest.getCategory());
        vehicle.setCategory(category);
        return mapToResponse(vehicleRepository.save(vehicle));
    }

    @Override
    public VehicleRequest getVehicle(String vehicleId) {
        Vehicle returnVehicle = vehicleRepository.findById(vehicleId).get();
        if(returnVehicle == null) {
            throw new RuntimeException();
        }
        return mapToRequest(returnVehicle);
    }

    @Override
    public List<VehicleRequest> getAllVehicle() {
        return vehicleRepository.findAll().stream().map(this::mapToRequest)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleResponse deleteVehicle(String vehicleId) {
        vehicleRepository.deleteById(vehicleId);
        return new VehicleResponse();
    }

    @Override
    public VehicleRequest searchVehicle(String numberPlate) {
        Vehicle returnVehicle = vehicleRepository.findVehicleByNumberPlate(numberPlate);
        if(returnVehicle != null) {
            return mapToRequest(returnVehicle);
        }
        return null;
    }

    public VehicleResponse mapToResponse(Vehicle vehicle) {
        return VehicleResponse.builder()
                .numberPlate(vehicle.getNumberPlate()).build();
    }

    public VehicleRequest mapToRequest(Vehicle vehicle) {
        return VehicleRequest.builder()
                .numberPlate(vehicle.getNumberPlate())
                .colour(vehicle.getColour())
                .ownerName(vehicle.getOwnerName())
                .build();
    }
}
