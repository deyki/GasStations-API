package GasStationsAPI.GasStationsAPI.controller;

import GasStationsAPI.GasStationsAPI.model.FuelInfoResponse;
import GasStationsAPI.GasStationsAPI.model.ResponseMessage;
import GasStationsAPI.GasStationsAPI.model.StationDTO;
import GasStationsAPI.GasStationsAPI.service.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class StationController {

    private final StationService stationService;


    @GetMapping("/getData")
    public ResponseEntity<ResponseMessage> getStationData() {
        return ResponseEntity.ok(stationService.getStationData());
    }

    @GetMapping("/getStation/{stationName}")
    public ResponseEntity<List<StationDTO>> getStationsByName(@PathVariable String stationName) {
        return ResponseEntity.ok(stationService.getStationsByName(stationName));
    }

    @GetMapping("/getFuelInfo/{fuelType}")
    public ResponseEntity<FuelInfoResponse> getFuelInfoByType(@PathVariable String fuelType) {
        return ResponseEntity.ok(stationService.getFuelInfoByType(fuelType));
    }

    @GetMapping("/getStationsNames")
    public ResponseEntity<List<String>> getStationsNames() {
        return ResponseEntity.ok(stationService.getStationsNames());
    }
}