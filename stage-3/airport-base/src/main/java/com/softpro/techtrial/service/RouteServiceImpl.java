package com.softpro.techtrial.service;

import com.softpro.techtrial.model.Route;
import com.softpro.techtrial.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    RouteRepository routeRepository;

    public List<Route> findRoutesByArrivalAirportId(Long airportArrivalId) {
        return routeRepository.findRoutesByArrivalAirportId(airportArrivalId);
    }
}
