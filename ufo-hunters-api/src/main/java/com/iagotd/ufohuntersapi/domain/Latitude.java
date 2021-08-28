package com.iagotd.ufohuntersapi.domain;

import com.iagotd.ufohuntersapi.domain.exceptions.IllegalLatitudeException;

public class Latitude {
    private final double value;

    public Latitude(double value) throws IllegalLatitudeException {
        validateLatitude(value);
        this.value = value;
    }

    private void validateLatitude(double value) throws IllegalLatitudeException {
        if ((value < -90) || (value > 90)) {
            throw new IllegalLatitudeException("Invalid latitude. Values should go from -90 to 90.");
        }
    }
}
