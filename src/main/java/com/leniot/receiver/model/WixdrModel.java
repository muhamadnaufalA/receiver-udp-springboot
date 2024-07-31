package com.leniot.receiver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WixdrModel {
    private String airPressure;
    private String airTemperature;
    private String relativeHumadity;
    private String waterTemperature;
    
    @Override
    public String toString() {
        return "airPressure=" + airPressure + " " + 
               "airTemperature=" + airTemperature + " " +
               "relativeHumadity=" + relativeHumadity + " " +
               "waterTemperature=" + waterTemperature + " ";
    }
}
