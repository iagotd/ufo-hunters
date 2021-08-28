package com.iagotd.ufohuntersapi.infra.config;

import com.iagotd.ufohuntersapi.domain.UFOSightingRepository;
import com.iagotd.ufohuntersapi.infra.repository.MemoryUFOSightingRepository;
import com.iagotd.ufohuntersapi.usecases.AddSighting;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public AddSighting addSighting(UFOSightingRepository ufoSightingRepository) {
        return new AddSighting(ufoSightingRepository);
    }

    @Bean
    public UFOSightingRepository ufoSightingRepository() {
        return new MemoryUFOSightingRepository();
    }
}
