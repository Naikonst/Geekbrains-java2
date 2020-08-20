package com.softpro.techtrial.controller;

import com.softpro.techtrial.dto.LandingCalculation;
import com.softpro.techtrial.model.Airport;
import com.softpro.techtrial.service.AirportService;
import com.softpro.techtrial.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AirlinesController {

    @Autowired
    AirportService airportService;

    @Autowired
    CalculateService calculateService;

    /**
     * Get airport landing report based on routes.
     * @param airportCode International airport code.
     * @return
     */

    @GetMapping(path = "/api/airport/{airport-code}/landing")
    public ResponseEntity<?> landingReport(
        @PathVariable(value = "airport-code") String airportCode) {
        Airport airport = airportService.findByCode(airportCode);
        if (airport == null) {
            return ResponseEntity.notFound().build();
        }
        List<LandingCalculation> report = calculateService.calculateLandingsInAirport(airport.getId());
        return ResponseEntity.ok(report);
    }

    /**
     * Get list of all airports.
     * @return
     */

    @GetMapping(path = "/api/airport")
    public ResponseEntity<?> airportList() {
        List<Airport> airports = airportService.getAllAirport();
        if (airports == null || airports.size() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(airports);
    }

    /**
     * Get airport information by code.
     * @param airportCode International airport code.
     * @return
     */

    @GetMapping(path = "/api/airport/{airport-code}")
    public ResponseEntity<?> airport(
            @PathVariable(value = "airport-code") String airportCode) {
        Airport airport = airportService.findByCode(airportCode);
        if (airport == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(airport);
    }

    /**
     * Greetings page on root path.
     * @param model MVC ModelMap.
     * @return
     */

    @GetMapping(path = "/")
    public String printHello(ModelMap model) {
        model.addAttribute("message", "High Sky Airlines Greetings");
        return "index";
    }

}
