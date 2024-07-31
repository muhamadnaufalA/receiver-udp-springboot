package com.leniot.receiver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PanzhrpModel {
    private String trueHeading;
    private String roll;
    private String pitch;
    private String headingRate;
    private String rollRate;
    private String pitchRate;
    private String status;

    @Override
    public String toString() {
        return "trueHeading=" + trueHeading + " " + 
               "roll=" + roll + " " +
               "pitch=" + pitch + " " +
               "headingRate=" + headingRate + " " +
               "rollRate=" + rollRate + " " +
               "pitchRate=" + pitchRate + " " +
               "status=" + status + " ";
    }
}
