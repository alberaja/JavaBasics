package io.parkingthales.parkingthales.repos;

import io.parkingthales.parkingthales.domain.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {
}
