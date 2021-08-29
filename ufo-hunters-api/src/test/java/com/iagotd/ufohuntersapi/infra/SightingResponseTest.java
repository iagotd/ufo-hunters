package com.iagotd.ufohuntersapi.infra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SightingResponseTest {

    private final String MESSAGE = "The UFO sighting has been stored in our systems.";
    private SightingResponse sightingResponse;

    @BeforeEach
    void setUp() {
        sightingResponse = new SightingResponse(true, MESSAGE);
    }

    @Test
    void constructorWorksAsExpected() {
        assertTrue(sightingResponse.isSuccess(), "success is not being correctly populated");
        assertEquals(MESSAGE, sightingResponse.getMessage(), "message is not being correctly populated");
    }
}