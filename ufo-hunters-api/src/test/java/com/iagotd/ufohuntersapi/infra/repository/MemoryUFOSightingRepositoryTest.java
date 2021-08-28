package com.iagotd.ufohuntersapi.infra.repository;

import com.iagotd.ufohuntersapi.domain.Latitude;
import com.iagotd.ufohuntersapi.domain.Longitude;
import com.iagotd.ufohuntersapi.domain.UFOSightingBuilder;
import com.iagotd.ufohuntersapi.domain.UFOSightingRepository;
import com.iagotd.ufohuntersapi.domain.exceptions.IllegalLatitudeException;
import com.iagotd.ufohuntersapi.domain.exceptions.IllegalLongitudeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class MemoryUFOSightingRepositoryTest {

    private final LocalDateTime SIGHTING_DATE_TIME = LocalDateTime.of(2021, Month.AUGUST, 28, 16, 36);

    private UFOSightingRepository ufoSightingRepository;

    @BeforeEach
    void setUp() {
        ufoSightingRepository = new MemoryUFOSightingRepository();
    }

    @Test
    void getAllShouldReturnAsExpected() {
        var allSightings = ufoSightingRepository.getAll();
        assertEquals(0, allSightings.size());
    }

    @Test
    void saveShouldAddASighting() throws IllegalLatitudeException, IllegalLongitudeException {
        var ufoSighting = new UFOSightingBuilder()
                .setLatitude(new Latitude(41.38))
                .setLongitude(new Longitude(2.17))
                .setSightingDateTime(SIGHTING_DATE_TIME)
                .setContact("It was green and pear shaped!")
                .build();

        ufoSightingRepository.save(ufoSighting);

        var allSightings = ufoSightingRepository.getAll();
        assertEquals(1, allSightings.size());
    }

}