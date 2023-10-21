package GasStationsAPI.GasStationsAPI.client;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface StationClient {

    @GetExchange("https://wejago.de/assets/data/gas-stations-data.json")
    Object getStationData();
}