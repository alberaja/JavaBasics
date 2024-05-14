package io.parkingthales.parkingthales.service;

import io.parkingthales.parkingthales.domain.ParkingSpot;
import io.parkingthales.parkingthales.domain.Vehicle;
import io.parkingthales.parkingthales.model.VehicleDTO;
import io.parkingthales.parkingthales.repos.ParkingSpotRepository;
import io.parkingthales.parkingthales.repos.VehicleRepository;
import io.parkingthales.parkingthales.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final ParkingSpotRepository parkingSpotRepository;

    public VehicleService(final VehicleRepository vehicleRepository,
            final ParkingSpotRepository parkingSpotRepository) {
        this.vehicleRepository = vehicleRepository;
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public List<VehicleDTO> findAll() {
        final List<Vehicle> vehicles = vehicleRepository.findAll(Sort.by("id"));
        return vehicles.stream()
                .map(vehicle -> mapToDTO(vehicle, new VehicleDTO()))
                .toList();
    }

    public VehicleDTO get(final Long id) {
        return vehicleRepository.findById(id)
                .map(vehicle -> mapToDTO(vehicle, new VehicleDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final VehicleDTO vehicleDTO) {
        final Vehicle vehicle = new Vehicle();
        mapToEntity(vehicleDTO, vehicle);
        return vehicleRepository.save(vehicle).getId();
    }

    public void update(final Long id, final VehicleDTO vehicleDTO) {
        final Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(vehicleDTO, vehicle);
        vehicleRepository.save(vehicle);
    }

    public void delete(final Long id) {
        vehicleRepository.deleteById(id);
    }

    private VehicleDTO mapToDTO(final Vehicle vehicle, final VehicleDTO vehicleDTO) {
        vehicleDTO.setId(vehicle.getId());
        vehicleDTO.setOccupied(vehicle.getOccupied());
        vehicleDTO.setIdVehiculo(vehicle.getId() == null ? null : vehicle.getId());/*.getId());*/
        return vehicleDTO;
    }

    private Vehicle mapToEntity(final VehicleDTO vehicleDTO, final Vehicle vehicle) {
        vehicle.setOccupied(vehicleDTO.getOccupied());
        final ParkingSpot idVehiculo = vehicleDTO.getIdVehiculo() == null ? null : parkingSpotRepository.findById(vehicleDTO.getIdVehiculo())
                .orElseThrow(() -> new NotFoundException("idVehiculo not found"));
//        vehicle.setId(idVehiculo);
        return vehicle;
    }

}
