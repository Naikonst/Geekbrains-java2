package com.softpro.techtrial.repository;

import com.softpro.techtrial.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AirportRepository extends JpaRepository<Airport, Long> {

    Airport findByCode(String code);

}
