package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.model.Airplane;
import ru.geekbrains.model.Route;
import ru.geekbrains.repository.AirplaneRepository;
import ru.geekbrains.repository.RouteRepository;

import java.util.List;

@Service
public class RouteService {

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Autowired
    private RouteRepository routeRepository;

    public List<Route> getRoutesByAirplaneNumber(String number) {
        Airplane airplane = airplaneRepository.findByNumber(number);
        return routeRepository.findByAirplane(airplane);
    }

}
