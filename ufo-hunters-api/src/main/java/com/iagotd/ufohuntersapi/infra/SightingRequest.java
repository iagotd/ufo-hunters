package com.iagotd.ufohuntersapi.infra;

public class SightingRequest {

    private double latitude;
    private double longitude;
    private int year;
    private int month;
    private int dayOfMonth;
    private int hour;
    private int minute;
    private String contact;

    public SightingRequest(double latitude, double longitude, int year, int month, int dayOfMonth, int hour, int minute, String contact) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
        this.hour = hour;
        this.minute = minute;
        this.contact = contact;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public String getContact() {
        return contact;
    }
}
