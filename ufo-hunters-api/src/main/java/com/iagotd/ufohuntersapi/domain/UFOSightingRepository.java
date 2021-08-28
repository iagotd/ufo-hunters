package com.iagotd.ufohuntersapi.domain;

import java.util.List;

public interface UFOSightingRepository {

    void save(UFOSighting ufoSighting);

    List<UFOSighting> getAll();
}
