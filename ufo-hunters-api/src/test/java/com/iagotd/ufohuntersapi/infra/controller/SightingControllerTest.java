package com.iagotd.ufohuntersapi.infra.controller;

import com.iagotd.ufohuntersapi.infra.SightingRequest;
import com.iagotd.ufohuntersapi.infra.SightingResponse;
import com.iagotd.ufohuntersapi.usecases.AddSighting;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class SightingControllerTest {

    private final String INVALID_SIGHTING_LATITUDE = "Invalid latitude. Values should go from -90 to 90.";
    private final String SIGHTING_STORED = "The UFO sighting has been stored in our systems.";

    private SightingController sightingController;

    @Mock
    private final AddSighting addSighting = Mockito.mock(AddSighting.class);

    @BeforeEach
    void setUp() {
        sightingController = new SightingController(addSighting);
    }

    @Test
    void shouldReturnFailWhenPostSightingIsNotSuccessful() {
        var req = new SightingRequest(40, 300, 2021, 4, 26, 16, 40, "John Doe");
        var res = new SightingResponse(false, INVALID_SIGHTING_LATITUDE);
        Mockito.when(addSighting.addSighting(req)).thenReturn(res);

        var resEntity = sightingController.postSighting(req);

        assertEquals(HttpStatus.BAD_REQUEST, resEntity.getStatusCode());
        assertFalse(Objects.requireNonNull(resEntity.getBody()).isSuccess());
    }

    @Test
    void shouldReturnTrueWhenPostSightingIsSuccessful() {
        var req = new SightingRequest(40, 30, 2021, 4, 26, 16, 40, "John Doe");
        var res = new SightingResponse(true, SIGHTING_STORED);
        Mockito.when(addSighting.addSighting(req)).thenReturn(res);

        var resEntity = sightingController.postSighting(req);

        assertEquals(HttpStatus.OK, resEntity.getStatusCode());
        assertTrue(Objects.requireNonNull(resEntity.getBody()).isSuccess());
    }
}