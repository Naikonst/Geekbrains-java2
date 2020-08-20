package com.softpro.techtrial.service;

import com.softpro.techtrial.model.Airport;

import java.util.List;

public interface AirportService {

    Airport findByCode(String code);

    List<Airport> getAllAirport();
}
