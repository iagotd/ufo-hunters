package com.iagotd.ufohuntersapi.infra;

public class SightingResponse {

    private boolean success;
    private String message;

    public SightingResponse(boolean success, String message) {
        this.message = message;
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
