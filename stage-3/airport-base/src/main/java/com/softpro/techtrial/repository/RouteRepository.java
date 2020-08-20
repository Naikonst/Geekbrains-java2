package com.softpro.techtrial.repository;

import com.softpro.techtrial.model.Route;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RouteRepository extends CrudRepository<Route, Long> {

    List<Route> findRoutesByArrivalAirportId(Long airportArrivalId);

}
