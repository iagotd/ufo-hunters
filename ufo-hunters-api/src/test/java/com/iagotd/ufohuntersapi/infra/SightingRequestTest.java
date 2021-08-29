package com.iagotd.ufohuntersapi.infra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SightingRequestTest {

    private final double LATITUDE = 40.28;
    private final double LONGITUDE = 30.25;
    private final int YEAR = 2021;
    private final int MONTH = 4;
    private final int DAY_OF_MONTH = 20;
    private final int HOUR = 16;
    private final int MINUTE = 32;
    private final String CONTACT = "John Doe";

    private SightingRequest sightingRequest;

    @BeforeEach
    void setUp() {
        sightingRequest = new SightingRequest(LATITUDE, LONGITUDE, YEAR, MONTH, DAY_OF_MONTH, HOUR, MINUTE, CONTACT);
    }

    @Test
    void constructorWorksAsExpected() {
        assertEquals(LATITUDE, sightingRequest.getLatitude(), "latitude is not being populated");
        assertEquals(LONGITUDE, sightingRequest.getLongitude(), "longitude is not being populated");
        assertEquals(YEAR, sightingRequest.getYear(), "year is not being populated");
        assertEquals(MONTH, sightingRequest.getMonth(), "month is not being populated");
        assertEquals(DAY_OF_MONTH, sightingRequest.getDayOfMonth(), "dayOfMonth is not being populated");
        assertEquals(HOUR, sightingRequest.getHour(), "hour is not being populated");
        assertEquals(MINUTE, sightingRequest.getMinute(), "minute is not being populated");
        assertEquals(CONTACT, sightingRequest.getContact(), "contact is not being populated");
    }
}