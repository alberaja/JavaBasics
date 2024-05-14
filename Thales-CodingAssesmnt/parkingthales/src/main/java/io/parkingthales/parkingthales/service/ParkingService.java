package io.parkingthales.parkingthales.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.parkingthales.parkingthales.domain.ParkingSpot;
import io.parkingthales.parkingthales.domain.Vehicle;
import io.parkingthales.parkingthales.repos.ParkingSpotRepository;
import io.parkingthales.parkingthales.repos.VehicleRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ParkingService {

    private final ParkingSpotRepository parkingSpotRepository;

    private final VehicleRepository vehicleRepository;

    public void assignParkingSpot(Vehicle vehicle) {
        // Logic to assign a parking spot to the arriving vehicle
    }

    public void changeParkingSpot(ChangeRequest request) {
        // Logic to change the parking spot of a vehicle
    }

    public void leaveParking(Long vehicleId) {
        // Logic to handle vehicle leaving parking
    }

    public ParkingStatus getParkingStatus() {
        // Logic to get parking status
        // Return parking status
    	List<ParkingSpot> parkingSpots = parkingSpotRepository.findAll();
        ParkingStatus parkingStatus = new ParkingStatus();

        for (ParkingSpot spot : parkingSpots) {
            if (spot.isOccupied()) {
//                Vehicle parkedVehicle = vehicleRepository.findByParkingSpotId(spot.getId());
//                parkingStatus.addOccupiedSpot(spot.getLocation(), parkedVehicle.getType());
            } else {
                parkingStatus.addFreeSpot(spot.getLocation());
            }
        }

        return parkingStatus;
    }
}
