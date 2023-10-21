package GasStationsAPI.GasStationsAPI.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name = "stations")
public class Station {

    @Id
    private String id;

    private String name;
    private String brand;
    private String street;
    private String place;
    private double lat;
    private double lng;
    private double dist;
    private double diesel;
    private double e5;
    private double e10;
    private boolean isOpen;
    private String houseNumber;
    private double postCode;
}