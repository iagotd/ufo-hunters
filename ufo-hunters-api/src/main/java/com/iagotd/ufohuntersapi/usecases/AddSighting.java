package com.iagotd.ufohuntersapi.usecases;

import com.iagotd.ufohuntersapi.domain.Latitude;
import com.iagotd.ufohuntersapi.domain.Longitude;
import com.iagotd.ufohuntersapi.domain.UFOSightingBuilder;
import com.iagotd.ufohuntersapi.domain.UFOSightingRepository;
import com.iagotd.ufohuntersapi.domain.exceptions.IllegalLatitudeException;
import com.iagotd.ufohuntersapi.domain.exceptions.IllegalLongitudeException;
import com.iagotd.ufohuntersapi.infra.SightingRequest;
import com.iagotd.ufohuntersapi.infra.SightingResponse;

import java.time.LocalDateTime;

public class AddSighting {

    private final String SIGHTING_STORED = "The UFO sighting has been stored in our systems.";

    private final UFOSightingRepository repository;

    public AddSighting(UFOSightingRepository repository) {
        this.repository = repository;
    }

    public SightingResponse addSighting(SightingRequest sightingRequest) {
        try {
            var ufoSighting = new UFOSightingBuilder()
                    .setLatitude(new Latitude(sightingRequest.getLatitude()))
                    .setLongitude(new Longitude(sightingRequest.getLongitude()))
                    .setSightingDateTime(getSightingDateTime(sightingRequest))
                    .setContact(sightingRequest.getContact())
                    .build();

            repository.save(ufoSighting);
        } catch (IllegalLatitudeException | IllegalLongitudeException e) {
            return new SightingResponse(false, e.getMessage());
        }
        return new SightingResponse(true, SIGHTING_STORED);
    }

    private LocalDateTime getSightingDateTime(SightingRequest req) {
        return LocalDateTime.of(req.getYear(),
                req.getMonth(),
                req.getDayOfMonth(),
                req.getHour(),
                req.getMinute());
    }
}
