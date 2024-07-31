package com.leniot.receiver.model;

public class VtgModel {
    private String cogTrue;
    private String cogMagnetic;
    private String sogKnots;
    private String sogKmhr;
    private String modeIndicator;

    public VtgModel(String cogTrue, String cogMagnetic, String sogKnots, String sogKmhr, String modeIndicator) {
        this.cogTrue = cogTrue;
        this.cogMagnetic = cogMagnetic;
        this.sogKnots = sogKnots;
        this.sogKmhr = sogKmhr;
        this.modeIndicator = modeIndicator;
    }

    public String getCogTrue() {
        return cogTrue;
    }

    public String getCogMagnetic() {
        return cogMagnetic;
    }

    public String getSogKnots() {
        return sogKnots;
    }

    public String getSogKmhr() {
        return sogKmhr;
    }

    public String getModeIndicator() {
        return modeIndicator;
    }

    @Override
    public String toString() {
        return 
            "cogTrue=" + cogTrue +
            ", cogMagnetic=" + cogMagnetic +
            ", sogKnots=" + sogKnots +
            ", sogKmhr=" + sogKmhr +
            ", modeIndicator=" + modeIndicator;
    }
}
