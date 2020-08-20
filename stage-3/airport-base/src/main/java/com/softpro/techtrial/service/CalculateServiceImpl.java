package com.softpro.techtrial.service;

import com.softpro.techtrial.dto.LandingCalculation;
import com.softpro.techtrial.repository.CalculationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculateServiceImpl implements CalculateService {

    @Autowired
    CalculationRepository calculationRepository;

    @Override
    public List<LandingCalculation> calculateLandingsInAirport(Long arrivalAirportId) {
        List<Object[]> records = calculationRepository.calculateLandingsInAirport(arrivalAirportId);
        List<LandingCalculation> result = new ArrayList<>();
        for (Object[] record : records) {
            result.add(new LandingCalculation(
                    (String)record[0],
                    (String)record[1],
                    (String)record[2],
                    ((java.math.BigInteger)record[3]).longValue()
            ));
        }
        return result;
    }
}
