package com.iagotd.ufohuntersapi.usecases;

import com.iagotd.ufohuntersapi.domain.UFOSightingRepository;

public class AddSighting {

    private final UFOSightingRepository repository;

    public AddSighting(UFOSightingRepository repository) {
        this.repository = repository;
    }

    public void addSighting() {
    }
}
