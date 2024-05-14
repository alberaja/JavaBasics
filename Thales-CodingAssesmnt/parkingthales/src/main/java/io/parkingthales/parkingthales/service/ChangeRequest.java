package io.parkingthales.parkingthales.service;

import lombok.Data;

@Data
public class ChangeRequest {
	private Long vehicleId;
    private Long newParkingSpotId;
}
