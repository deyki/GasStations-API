package GasStationsAPI.GasStationsAPI.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class JsonDataDTO implements Serializable {

    private StationDTO[] stations;
}
