package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.model.Airplane;
import ru.geekbrains.repository.AirplaneRepository;

import java.util.List;

@Service
public class AirplaneService {

    @Autowired
    private AirplaneRepository airplaneRepository;

    public List<Airplane> getAirplanesByBrand(String brand) {
        return airplaneRepository.findByBrand(brand);
    }
}
