package com.iagotd.ufohuntersapi.domain;

import com.iagotd.ufohuntersapi.domain.exceptions.IllegalLatitudeException;
import com.iagotd.ufohuntersapi.domain.exceptions.IllegalLongitudeException;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

class UFOSightingTest {

    private final LocalDateTime SIGHTING_DATE_TIME = LocalDateTime.of(2021, Month.AUGUST, 28, 16, 36);

    @Test
    void constructorDoesNotBreak() throws IllegalLatitudeException, IllegalLongitudeException {
        new UFOSighting(new Latitude(41.38), new Longitude(2.17), SIGHTING_DATE_TIME, "It was green and pear shaped!");
    }
}