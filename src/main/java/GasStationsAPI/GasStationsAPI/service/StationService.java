package GasStationsAPI.GasStationsAPI.service;

import GasStationsAPI.GasStationsAPI.model.FuelInfoResponse;
import GasStationsAPI.GasStationsAPI.model.ResponseMessage;
import GasStationsAPI.GasStationsAPI.model.StationDTO;

import java.util.List;

public interface StationService {

    ResponseMessage getStationData();

    List<StationDTO> getStationsByName(String stationName);

    FuelInfoResponse getFuelInfoByType(String fuelType);

    double findMedian(List<Double> fuelValues);

    List<String> getStationsNames();
}