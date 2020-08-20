package com.softpro.techtrial.controller;

import com.softpro.techtrial.model.Airport;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AirlinesControllerTest {

    MockMvc mockMvc;

    @Mock
    private AirlinesController airlinesController;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setup() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(airlinesController).build();
    }

    @Test
    public void testReceiveExistingAirport() throws Exception {
        ResponseEntity<Airport> response = template.getForEntity(
                "/api/airport/SVO", Airport.class);
        Assert.assertEquals(200,response.getStatusCode().value());
        Assert.assertEquals("Шереметьево", response.getBody().getName());
    }

    @Test
    public void testReceiveUnexistingAirport() throws Exception {
        ResponseEntity<Airport> response = template.getForEntity(
                "/api/airport/AMS", Airport.class);
        Assert.assertEquals(404,response.getStatusCode().value());
    }

    @Test
    public void testReceiveLandingReportExistingAirport() throws Exception {
        ResponseEntity<List> response = template.getForEntity(
                "/api/airport/SVO/landing", List.class);
        Assert.assertEquals(200,response.getStatusCode().value());
        List<HashMap<String, Object>> landingCalculations = response.getBody();
        Assert.assertEquals("SVO", landingCalculations.get(0).get("airportCode"));
    }

    @Test
    public void testReceiveLandingReportUnexistingAirport() throws Exception {
        ResponseEntity<List> response = template.getForEntity(
                "/api/airport/AMS/landing", List.class);
        Assert.assertEquals(404,response.getStatusCode().value());
    }

    @Test
    public void testCheckAirportsListNotNull() throws Exception {
        ResponseEntity<List> response = template.getForEntity(
                "/api/airport", List.class);
        Assert.assertEquals(200,response.getStatusCode().value());
        Assert.assertNotNull(response.getBody());
        Assert.assertTrue(response.getBody().size() != 0);
    }

}
