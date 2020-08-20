package com.softpro.techtrial.service;

import com.softpro.techtrial.model.Airport;
import com.softpro.techtrial.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    AirportRepository airportRepository;

    public Airport findByCode(String code) {
        return airportRepository.findByCode(code);
    }

    public List<Airport> getAllAirport() {
        return airportRepository.findAll();
    }
}
