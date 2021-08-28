package com.iagotd.ufohuntersapi.domain;

import java.time.LocalDateTime;

public class UFOSightingBuilder {
    private Latitude latitude;
    private Longitude longitude;
    private LocalDateTime sightingDateTime;
    private String contact;

    public UFOSightingBuilder setLatitude(Latitude latitude) {
        this.latitude = latitude;
        return this;
    }

    public UFOSightingBuilder setLongitude(Longitude longitude) {
        this.longitude = longitude;
        return this;
    }

    public UFOSightingBuilder setSightingDateTime(LocalDateTime sightingDateTime) {
        this.sightingDateTime = sightingDateTime;
        return this;
    }

    public UFOSightingBuilder setContact(String contact) {
        this.contact = contact;
        return this;
    }

    public UFOSighting build() {
        return new UFOSighting(latitude, longitude, sightingDateTime, contact);
    }
}
