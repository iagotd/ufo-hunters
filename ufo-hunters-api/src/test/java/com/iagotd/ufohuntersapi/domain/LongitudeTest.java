package com.iagotd.ufohuntersapi.domain;

import com.iagotd.ufohuntersapi.domain.exceptions.IllegalLongitudeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongitudeTest {

    @Test
    void constructorThrowsWhenInvalidLongitude() {
        assertThrows(
                IllegalLongitudeException.class,
                () -> new Longitude(-200),
                "Expected Longitude constructor to throw, but it didn't"
        );
    }

    @Test
    void constructorDoesNotThrow() throws IllegalLongitudeException {
        new Longitude(160);
    }
}