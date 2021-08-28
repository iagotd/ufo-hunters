package com.iagotd.ufohuntersapi.domain;

import java.time.LocalDateTime;

public class UFOSighting {
    private Latitude latitude;
    private Longitude longitude;
    private LocalDateTime sightingDateTime;
    private String contact;

    public UFOSighting(Latitude latitude, Longitude longitude, LocalDateTime sightingDateTime, String contact) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.sightingDateTime = sightingDateTime;
        this.contact = contact;
    }
}
