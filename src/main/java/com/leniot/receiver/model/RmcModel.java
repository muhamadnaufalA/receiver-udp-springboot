package com.leniot.receiver.model;

public class RmcModel {
    private String utcTime;
    private String status;
    private String latitude;
    private String latitudePosition;
    private String longitude;
    private String longitudePosition;
    private String sog;
    private String cog;
    private String date;
    private String magnetic;
    private String degrees;
    private String modeIndicator;

    public RmcModel(String utcTime, String status, String latitude, String latitudePosition, String longitude, String longitudePosition, String sog, String cog, String date, String magnetic, String degrees, String modeIndicator) {
        this.utcTime = utcTime;
        this.status = status;
        this.latitude = latitude;
        this.latitudePosition = latitudePosition;
        this.longitude = longitude;
        this.longitudePosition = longitudePosition;
        this.sog = sog;
        this.cog = cog;
        this.date = date;
        this.magnetic = magnetic;
        this.degrees = degrees;
        this.modeIndicator = modeIndicator;
    }

    public String getUtcTime() {
        return utcTime;
    }

    public String getStatus() {
        return status;
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

    public String getSog() {
        return sog;
    }

    public String getCog() {
        return cog;
    }

    public String getDate() {
        return date;
    }

    public String getMagnetic() {
        return magnetic;
    }

    public String getDegrees() {
        return degrees;
    }

    public String getModeIndicator() {
        return modeIndicator;
    }

    @Override
    public String toString() {
        return 
            "utcTime=" + utcTime +
            ", status=" + status +
            ", latitude=" + latitude +
            ", latitudePosition=" + latitudePosition +
            ", longitude=" + longitude +
            ", longitudePosition=" + longitudePosition +
            ", sog=" + sog +
            ", cog=" + cog +
            ", date=" + date +
            ", magnetic=" + magnetic +
            ", degrees=" + degrees +
            ", modeIndicator=" + modeIndicator;
    }
}
