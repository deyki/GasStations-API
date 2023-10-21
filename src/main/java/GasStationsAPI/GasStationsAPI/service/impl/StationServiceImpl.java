package GasStationsAPI.GasStationsAPI.service.impl;

import GasStationsAPI.GasStationsAPI.client.StationClient;
import GasStationsAPI.GasStationsAPI.entity.Station;
import GasStationsAPI.GasStationsAPI.error.InvalidFuelTypeException;
import GasStationsAPI.GasStationsAPI.error.StationNotFoundException;
import GasStationsAPI.GasStationsAPI.model.FuelInfoResponse;
import GasStationsAPI.GasStationsAPI.model.JsonDataDTO;
import GasStationsAPI.GasStationsAPI.model.ResponseMessage;
import GasStationsAPI.GasStationsAPI.model.StationDTO;
import GasStationsAPI.GasStationsAPI.repository.StationRepository;
import GasStationsAPI.GasStationsAPI.service.StationService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@RequiredArgsConstructor
@Service
public class StationServiceImpl implements StationService {

    private final ModelMapper modelMapper;
    private final StationRepository stationRepository;
    private final StationClient stationClient;

    @Override
    public ResponseMessage getStationData(){
        Object object = stationClient.getStationData();

        JsonDataDTO jsonDataDTO = modelMapper.map(object, JsonDataDTO.class);

        List<Station> stations = Arrays.stream(jsonDataDTO.getStations())
                .filter(StationDTO::isOpen)
                .map(stationDTO -> modelMapper.map(stationDTO, Station.class))
                .collect(Collectors.toList());

        stationRepository.saveAll(stations);

        return new ResponseMessage("Data is saved.");
    }

    @Override
    public List<StationDTO> getStationsByName(String stationName) {
        List<StationDTO> stations = stationRepository.findAll()
                .stream()
                .filter(station -> station.getName().equals(stationName))
                .map(station -> modelMapper.map(station, StationDTO.class))
                .collect(Collectors.toList());

        if (stations.isEmpty()) {
            throw new StationNotFoundException("No stations with this name found!");
        }

        return stations;
    }

    @Override
    public FuelInfoResponse getFuelInfoByType(String fuelType) {
        List<Double> fuelValues;

        switch (fuelType) {
            case "E5" -> fuelValues = stationRepository.findAllE5()
                    .stream()
                    .sorted()
                    .collect(Collectors.toList());
            case "E10" -> fuelValues = stationRepository.findAllE10()
                    .stream()
                    .sorted()
                    .collect(Collectors.toList());
            case "DIESEL" -> fuelValues = stationRepository.findAllDiesel()
                    .stream()
                    .sorted()
                    .collect(Collectors.toList());
            default -> throw new InvalidFuelTypeException("Invalid fuel type.");
        }

        double median = findMedian(fuelValues);
        double max = fuelValues.get(fuelValues.size() - 1);
        double min = fuelValues.get(0);

        return new FuelInfoResponse(fuelType, median, max, min);
    }

    @Override
    public double findMedian(List<Double> fuelValues) {
        if (fuelValues.size() % 2 == 1) {
            return fuelValues.get(fuelValues.size() / 2);
        } else {
            int middleIndex1 = fuelValues.size() / 2 - 1;
            int middleIndex2 = fuelValues.size() / 2;
            double middleValue1 = fuelValues.get(middleIndex1);
            double middleValue2 = fuelValues.get(middleIndex2);
            return (middleValue1 + middleValue2) / 2.0;
        }
    }

    @Override
    public List<String> getStationsNames() {
        return stationRepository.findAllStationsNames();
    }
}