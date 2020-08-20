package com.softpro.techtrial.service;

import com.softpro.techtrial.model.Route;

import java.util.List;

public interface RouteService {

    List<Route> findRoutesByArrivalAirportId(Long airportArrivalId);
}
