package GasStationsAPI.GasStationsAPI.repository;

import GasStationsAPI.GasStationsAPI.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationRepository extends JpaRepository<Station, String> {

    @Query("SELECT s.e5 from Station s")
    List<Double> findAllE5();

    @Query("SELECT s.e10 from Station s")
    List<Double> findAllE10();

    @Query("SELECT s.diesel from Station s")
    List<Double> findAllDiesel();

    @Query("SELECT s.name from Station s")
    List<String> findAllStationsNames();
}
