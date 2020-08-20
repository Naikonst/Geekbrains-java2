package ru.geekbrains.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.model.Airplane;

import java.util.List;

public interface AirplaneRepository extends JpaRepository<Airplane, Long> {

    List<Airplane> findByBrand(String brand);

    Airplane findByNumber(String number);

}
