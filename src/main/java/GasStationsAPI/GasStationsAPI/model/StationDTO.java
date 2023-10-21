package GasStationsAPI.GasStationsAPI.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
public class StationDTO implements Serializable {

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