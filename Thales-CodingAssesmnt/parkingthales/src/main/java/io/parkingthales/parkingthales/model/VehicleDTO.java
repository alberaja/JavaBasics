package io.parkingthales.parkingthales.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VehicleDTO {

    private Long id;

    @NotNull
    private Boolean occupied;

    @NotNull
    private Long idVehiculo;

    

}
