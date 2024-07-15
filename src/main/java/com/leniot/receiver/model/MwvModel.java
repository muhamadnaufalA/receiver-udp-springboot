package com.leniot.receiver.model;

public class MwvModel {
    private String windAngle;
    private String reference;
    private String windSpeed;
    private String windSpeedUnit;
    private String status;

    public MwvModel(String windAngle, String reference, String windSpeed, String windSpeedUnit, String status) {
        this.windAngle = windAngle;
        this.reference = reference;
        this.windSpeed = windSpeed;
        this.windSpeedUnit = windSpeedUnit;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return 
            "windAngle=" + windAngle +
            ", reference=" + reference +
            ", windSpeed=" + windSpeed +
            ", windSpeedUnit=" + windSpeedUnit +
            ", status=" + status;
    }
}
