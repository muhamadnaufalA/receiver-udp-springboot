package com.leniot.receiver.service;

import org.springframework.stereotype.Service;
import com.leniot.receiver.model.GllModel;

@Service
public class GllService {

    public GllModel decode(String nmeaMessage) throws IllegalArgumentException {
        if (nmeaMessage == null || !nmeaMessage.startsWith("$--GLL,")) {
            throw new IllegalArgumentException("Invalid GLL message");
        }

        try {
            String[] parts = nmeaMessage.split("[,*]");
            if (parts.length < 7) {
                throw new IllegalArgumentException("Incomplete GLL message");
            }

            GllModel gllModel = new GllModel(parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7]);
            return new GllModel(gllModel.getLatitude(), gllModel.getLatitudePosition(), gllModel.getLongitude(), gllModel.getLongitudePosition(), gllModel.getUtcOfPosition(), gllModel.getStatus(), gllModel.getModeIndicator());

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error parsing DPT message: " + e.getMessage(), e);
        }
    }
}
