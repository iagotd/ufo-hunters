package com.iagotd.ufohuntersapi.infra.repository;

import com.iagotd.ufohuntersapi.domain.UFOSighting;
import com.iagotd.ufohuntersapi.domain.UFOSightingRepository;

import java.util.ArrayList;
import java.util.List;

public class MemoryUFOSightingRepository implements UFOSightingRepository {

    private final List<UFOSighting> ufoSightings = new ArrayList<>();

    public void save(UFOSighting ufoSighting) {
        ufoSightings.add(ufoSighting);
    }

    public List<UFOSighting> getAll() {
        return this.ufoSightings;
    }
}
