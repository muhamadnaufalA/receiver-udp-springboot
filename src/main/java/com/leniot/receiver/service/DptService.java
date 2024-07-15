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

            DptModel dptModel = new DptModel(parts[1], parts[2], parts[3]);
            return new DptModel(dptModel.getDepth(), dptModel.getOffset(), dptModel.getMaxLengthScale());
            
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error parsing DPT message: " + e.getMessage(), e);
        }
    }
}
