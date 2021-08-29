package com.iagotd.ufohuntersapi.infra.controller;

import com.iagotd.ufohuntersapi.infra.SightingRequest;
import com.iagotd.ufohuntersapi.infra.SightingResponse;
import com.iagotd.ufohuntersapi.usecases.AddSighting;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SightingController {

    private AddSighting addSighting;

    public SightingController(AddSighting addSighting) {
        this.addSighting = addSighting;
    }

    @PostMapping("/sighting")
    public ResponseEntity<SightingResponse> postSighting(@RequestBody SightingRequest req) {
        var response = addSighting.addSighting(req);

        return response.isSuccess()
                ? ResponseEntity.ok().body(response)
                : ResponseEntity.badRequest().body(response);
    }
}
