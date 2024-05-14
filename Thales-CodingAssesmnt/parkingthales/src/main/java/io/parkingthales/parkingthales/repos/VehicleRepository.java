package io.parkingthales.parkingthales.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.parkingthales.parkingthales.domain.Vehicle;


public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	
	// Método para buscar un vehículo por el ID de su lugar de estacionamiento
	//@Query("SELECT v FROM Vehicle v JOIN v.ParkingSpot vp WHERE vp.parkingSpotId = :parkingSpotId")
    //Vehicle findByParkingSpotId(Long parkingSpotId);
}
