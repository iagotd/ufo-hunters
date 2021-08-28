package com.iagotd.ufohuntersapi.domain;

import com.iagotd.ufohuntersapi.domain.exceptions.IllegalLatitudeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LatitudeTest {

    @Test
    void constructorThrowsWhenInvalidLatitude() {
        assertThrows(
                IllegalLatitudeException.class,
                () -> new Latitude(-150),
                "Expected latitude constructor to throw, but it didn't"
        );
    }

    @Test
    void constructorDoesNotThrow() throws IllegalLatitudeException {
        new Latitude(80);
    }
}