package com.leniot.receiver.model;

public class GllModel {
    private String latitude;
    private String latitudePosition;
    private String longitude;
    private String longitudePosition;
    private String utcOfPosition;
    private String status;
    private String modeIndicator;

    public GllModel(String latitude, String latitudePosition, String longitude, String longitudePosition, String utcOfPosition, String status, String modeIndicator) {
        this.latitude = latitude;
        this.latitudePosition = latitudePosition;
        this.longitude = longitude;
        this.longitudePosition = longitudePosition;
        this.utcOfPosition = utcOfPosition;
        this.status = status;
        this.modeIndicator = modeIndicator;
    }   

    public String getLatitude() {
        return latitude;
    }

    public String getLatitudePosition() {
        return latitudePosition;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLongitudePosition() {
        return longitudePosition;
    }

    public String getUtcOfPosition() {
        return utcOfPosition;
    }

    public String getStatus() {
        return status;
    }

    public String getModeIndicator() {
        return modeIndicator;
    }

    @Override
    public String toString() {
        return 
            "latitude=" + latitude +
            ", latitudePosition=" + latitudePosition +
            ", longitude=" + longitude +
            ", longitudePosition=" + longitudePosition +
            ", utcOfPosition=" + utcOfPosition +
            ", status=" + status +
            ", modeIndicator=" + modeIndicator;
    }
}
