package com.softpro.techtrial.service;

import com.softpro.techtrial.dto.LandingCalculation;

import java.util.List;

public interface CalculateService {

    List<LandingCalculation> calculateLandingsInAirport(Long arrivalAirportId);
}
