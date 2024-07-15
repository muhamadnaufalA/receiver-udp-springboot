package com.leniot.receiver.model;

public class MwvModel {
    private String windAngle;
    private String reference;
    private String windSpeed;
    private String windSpeedUnit;

    public MwvModel(String windAngle, String reference, String windSpeed, String windSpeedUnit) {
        this.windAngle = windAngle;
        this.reference = reference;
        this.windSpeed = windSpeed;
        this.windSpeedUnit = windSpeedUnit;
    }

    public String getWindAngle() {
        return windAngle;
    }

    public String getReference() {
        return reference;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public String getWindSpeedUnit() {
        return windSpeedUnit;
    }

    @Override
    public String toString() {
        return 
            "windAngle=" + windAngle +
            ", reference=" + reference +
            ", windSpeed=" + windSpeed +
            ", windSpeedUnit=" + windSpeedUnit;
    }
}
