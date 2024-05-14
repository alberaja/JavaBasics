package io.parkingthales.parkingthales.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingStatus {
    private Map<String, String> occupiedSpots; // Mapa de ubicación de lugar a tipo de vehículo
    private List<String> freeSpots; // Lista de ubicaciones de lugares libres

    // Constructor
    public ParkingStatus() {
        this.occupiedSpots = new HashMap<>();
        this.freeSpots = new ArrayList<>();
    }

    // Método para agregar un lugar ocupado al estado de estacionamiento
    public void addOccupiedSpot(String location, String vehicleType) {
        occupiedSpots.put(location, vehicleType);
    }

    // Método para agregar un lugar libre al estado de estacionamiento
    public void addFreeSpot(String location) {
        freeSpots.add(location);
    }

}
