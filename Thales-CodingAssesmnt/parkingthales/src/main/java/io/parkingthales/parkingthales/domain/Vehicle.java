package io.parkingthales.parkingthales.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;


@Entity
@Data
public class Vehicle {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Long id;

    @Column(nullable = false)
    private Boolean occupied;
    
    @Column(nullable = false)
    private String type;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_vehiculo_id", nullable = false)
//    private ParkingSpot idVehiculo;
    @OneToMany(mappedBy = "vehicle")
    private List<ParkingSpot> parkingSpots;
   
}
