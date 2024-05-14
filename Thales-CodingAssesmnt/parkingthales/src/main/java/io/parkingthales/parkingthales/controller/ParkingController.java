package io.parkingthales.parkingthales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.parkingthales.parkingthales.domain.Vehicle;
import io.parkingthales.parkingthales.service.ParkingService;
import io.parkingthales.parkingthales.service.ParkingStatus;
import lombok.extern.slf4j.Slf4j;


@Validated
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/parking")
public class ParkingController {

	@Autowired
//    private final ParkingService parkingService;


    @PostMapping("/vehicles")
    public ResponseEntity<Void> parkVehicle(@RequestBody Vehicle vehicle) {
//        parkingService.parkVehicle(vehicle);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/vehicles/{vehicleId}")
    public ResponseEntity<Void> changeVehicleLocation(@PathVariable Long vehicleId, @RequestParam Long newSpotId) {
//        parkingService.changeVehicleLocation(vehicleId, newSpotId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/vehicles/{vehicleId}")
    public ResponseEntity<Void> removeVehicle(@PathVariable Long vehicleId) {
//        parkingService.removeVehicle(vehicleId);
        return ResponseEntity.noContent().build();
    }

//    @GetMapping("/status")
//    public ResponseEntity<ParkingStatus> getParkingStatus() {
////        ParkingStatus parkingStatus = parkingService.getParkingStatus();
//        return ResponseEntity.ok(parkingStatus);
//    }

//    @GetMapping("/vehicles/count")
//    public ResponseEntity<VehicleCount> getVehicleCount() {
//        VehicleCount vehicleCount = parkingService.getVehicleCount();
//        return ResponseEntity.ok(vehicleCount);
//    }
}
