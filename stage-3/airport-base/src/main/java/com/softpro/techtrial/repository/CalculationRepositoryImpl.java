package com.softpro.techtrial.repository;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class CalculationRepositoryImpl implements CalculationProceduresRepository{

    @PersistenceContext
    private EntityManager em;


    @Override
    @Transactional
    public List<Object[]> calculateLandingsInAirport(Long arrivalAirportId) {
        StoredProcedureQuery landingReport = em.createNamedStoredProcedureQuery("getLandingReport");
        landingReport.setParameter(2, arrivalAirportId);
        return landingReport.getResultList();
    }
}
