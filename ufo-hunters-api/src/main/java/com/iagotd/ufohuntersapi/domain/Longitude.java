package com.iagotd.ufohuntersapi.domain;

import com.iagotd.ufohuntersapi.domain.exceptions.IllegalLongitudeException;

public class Longitude {
    private final double value;

    public Longitude(double value) throws IllegalLongitudeException {
        validateLongitude(value);
        this.value = value;
    }

    private void validateLongitude(double value) throws IllegalLongitudeException {
        if ((value < -180) || (value > 180)) {
            throw new IllegalLongitudeException("Invalid longitude. Values should go from -180 to 180.");
        }
    }
}
