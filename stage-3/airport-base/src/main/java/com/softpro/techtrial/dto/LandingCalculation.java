package com.softpro.techtrial.dto;

public class LandingCalculation {

    private String airportCode;

    private String airportName;

    private String airplane;

    private Long landingCount;

    public LandingCalculation() {
    }

    public LandingCalculation(String airportCode, String airportName, String airplane, Long landingCount) {
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.airplane = airplane;
        this.landingCount = landingCount;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getAirplane() {
        return airplane;
    }

    public void setAirplane(String airplane) {
        this.airplane = airplane;
    }

    public Long getLandingCount() {
        return landingCount;
    }

    public void setLandingCount(Long landingCount) {
        this.landingCount = landingCount;
    }

    @Override
    public String toString() {
        return "LandingCalculation{" +
                "airportCode='" + airportCode + '\'' +
                ", airportName='" + airportName + '\'' +
                ", airplane='" + airplane + '\'' +
                ", landingCount=" + landingCount +
                '}';
    }
}
