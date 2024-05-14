package io.parkingthales.parkingthales.controller;

import io.parkingthales.parkingthales.model.VehicleDTO;
import io.parkingthales.parkingthales.service.VehicleService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/vehicles", produces = MediaType.APPLICATION_JSON_VALUE)
public class VehicleResource {

    private final VehicleService vehicleService;

    public VehicleResource(final VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicle(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(vehicleService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createVehicle(@RequestBody @Valid final VehicleDTO vehicleDTO) {
        final Long createdId = vehicleService.create(vehicleDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateVehicle(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final VehicleDTO vehicleDTO) {
        vehicleService.update(id, vehicleDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteVehicle(@PathVariable(name = "id") final Long id) {
        vehicleService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
