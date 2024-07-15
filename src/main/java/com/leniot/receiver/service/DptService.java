package com.leniot.receiver.service;

import org.springframework.stereotype.Service;
import com.leniot.receiver.model.DptModel;

@Service
public class DptService {

    public DptModel decode(String nmeaMessage) throws IllegalArgumentException {
        if (nmeaMessage == null || !nmeaMessage.startsWith("$--DPT,")) {
            throw new IllegalArgumentException("Invalid DPT message");
        }

        try {
            String[] parts = nmeaMessage.split("[,*]");
            if (parts.length < 3) {
                throw new IllegalArgumentException("Incomplete DPT message");
            }

            String depth = parts[1];
            String offset = parts[2];
            String maxLengthScale = parts[3];

            return new DptModel(depth, offset, maxLengthScale);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error parsing DPT message: " + e.getMessage(), e);
        }
    }
}
