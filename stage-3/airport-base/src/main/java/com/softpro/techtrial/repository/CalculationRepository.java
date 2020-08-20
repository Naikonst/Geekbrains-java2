package com.softpro.techtrial.repository;

import com.softpro.techtrial.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculationRepository extends JpaRepository<Route, Long>, CalculationProceduresRepository {
}
