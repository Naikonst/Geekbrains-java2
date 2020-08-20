package ru.geekbrains.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.model.Airplane;
import ru.geekbrains.model.Route;
import ru.geekbrains.service.AirplaneService;
import ru.geekbrains.service.RouteService;

import java.util.List;

@RestController
public class AirlinesController {

    @Autowired
    private AirplaneService airplaneService;

    @Autowired
    private RouteService routeService;

    //GET - получение данных
    //POST - создание нового объекта
    //PUT - изменение существующего объекта
    //DELETE - удаление объекта

    @GetMapping(path = "/airlines/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("<h1>Привет!</h1>");
    }

    @GetMapping(path = "/airlines/airplane/{brand}")
    public ResponseEntity<List<Airplane>> getAirplanesByBrand(
            @PathVariable(name = "brand") String brand) {
        return ResponseEntity.ok(airplaneService.getAirplanesByBrand(brand));
    }

    @GetMapping(path = "/airlines/routes/airplane/{number}")
    public ResponseEntity<List<Route>> getRoutesByAirplaneNumber(
            @PathVariable(name = "number") String number) {
        return ResponseEntity.ok(routeService.getRoutesByAirplaneNumber(number));
    }

}
