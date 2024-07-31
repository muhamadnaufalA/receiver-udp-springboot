package com.leniot.receiver.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HdtModel {
    private String headingTrue;

    public HdtModel(String headingTrue) {
        this.headingTrue = headingTrue;
    }

    @Override
    public String toString() {
        return "headingTrue=" + headingTrue;
    }
}
