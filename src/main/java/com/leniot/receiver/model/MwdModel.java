package com.leniot.receiver.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MwdModel {
    private String windTrue;
    private String windMagnetic;
    private String speedKnot;
    private String speedMs;
    
    public MwdModel(String windTrue, String windMagnetic, String speedKnot, String speedMs) {
        this.windTrue = windTrue;
        this.windMagnetic = windMagnetic;
        this.speedKnot = speedKnot;
        this.speedMs = speedMs;
    }
    
    @Override
    public String toString() {
        return "windTrue=" + windTrue + " " + 
               "windMagnetic=" + windMagnetic + " " +
               "speedKnot=" + speedKnot + " " +
               "speedMs=" + speedMs + " ";
    }
}
