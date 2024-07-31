package com.leniot.receiver.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VhwModel{
    private String headingTrue;
    private String headingMagnetic;
    private String speedKnot;
    private String speedKm;
    
    public VhwModel(String headingTrue, String headingMagnetic, String speedKnot, String speedKm){
        this.headingTrue = headingTrue;
        this.headingMagnetic = headingMagnetic;
        this.speedKnot = speedKnot;
        this.speedKm = speedKm;
    }

    @Override
    public String toString() {
        return "headingTrue=" + headingTrue + " " + 
               "headingMagnetic=" + headingMagnetic + " " +
               "speedKnot=" + speedKnot + " " +
               "speedKm=" + speedKm + " ";
    }
}
