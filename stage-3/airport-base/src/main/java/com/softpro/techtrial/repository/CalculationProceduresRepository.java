package com.softpro.techtrial.repository;

import java.util.List;

public interface CalculationProceduresRepository {

    List<Object[]> calculateLandingsInAirport(Long arrivalAirportId);

}
