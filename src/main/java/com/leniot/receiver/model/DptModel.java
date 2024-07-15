package com.leniot.receiver.model;

public class DptModel {
    private final String depth;
    private final String offset;
    private final String maxLengthScale;

    public DptModel(String depth, String offset, String maxLengthScale) {
        this.depth = depth;
        this.offset = offset;
        this.maxLengthScale = maxLengthScale;
    }

    public String getDepth() {
        return depth;
    }

    public String getOffset() {
        return offset;
    }

    public String getMaxLengthScale() {
        return maxLengthScale;
    }

    @Override
    public String toString() {
        return 
            "depth=" + depth +
            ", offset=" + offset +
            ", maxLengthScale=" + maxLengthScale;
    }
}
