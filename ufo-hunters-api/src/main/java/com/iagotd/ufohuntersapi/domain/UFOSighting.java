package com.iagotd.ufohuntersapi.domain;

import java.time.LocalDateTime;

public class UFOSighting {
    private Latitude latitude;
    private Longitude longitude;
    private LocalDateTime sightingDateTime;
    private String comment;

    public UFOSighting(Latitude latitude, Longitude longitude, LocalDateTime sightingDateTime, String comment) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.sightingDateTime = sightingDateTime;
        this.comment = comment;
    }
}
