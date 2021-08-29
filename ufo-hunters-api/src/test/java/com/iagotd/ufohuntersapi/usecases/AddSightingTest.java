package com.iagotd.ufohuntersapi.usecases;

import com.iagotd.ufohuntersapi.domain.UFOSightingRepository;
import com.iagotd.ufohuntersapi.infra.SightingRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class AddSightingTest {

    private final String INVALID_SIGHTING_LATITUDE = "Invalid latitude. Values should go from -90 to 90.";
    private final String INVALID_SIGHTING_LONGITUDE = "Invalid longitude. Values should go from -180 to 180.";
    private final String SIGHTING_STORED = "The UFO sighting has been stored in our systems.";

    private AddSighting addSighting;

    @Mock
    private final UFOSightingRepository ufoSightingRepository = Mockito.mock(UFOSightingRepository.class);

    @BeforeEach
    void setUp() {
        addSighting = new AddSighting(ufoSightingRepository);
    }

    @Test
    void shouldFailWhenLatitudeIsInvalid() {
        var req = new SightingRequest(400, 30, 2021, 4, 26, 16, 40, "John Doe");

        var res = addSighting.addSighting(req);

        assertFalse(res.isSuccess());
        assertEquals(INVALID_SIGHTING_LATITUDE, res.getMessage());
    }

    @Test
    void shouldFailWhenLongitudeIsInvalid() {
        var req = new SightingRequest(40, 200, 2021, 4, 26, 16, 40, "John Doe");

        var res = addSighting.addSighting(req);

        assertFalse(res.isSuccess());
        assertEquals(INVALID_SIGHTING_LONGITUDE, res.getMessage());
    }

    @Test
    void shouldSucceedWhenAllDataIsValid(){
        var req = new SightingRequest(40, 30, 2021, 4, 26, 16, 40, "John Doe");

        var res = addSighting.addSighting(req);

        assertTrue(res.isSuccess());
        assertEquals(SIGHTING_STORED, res.getMessage());
    }

}