package com.leniot.receiver.service;

import org.springframework.stereotype.Service;
import com.leniot.receiver.model.MwvModel;

@Service
public class MwvService {

    public MwvModel decode(String nmeaMessage) throws IllegalArgumentException {
        if (nmeaMessage == null || !nmeaMessage.startsWith("$--MWV,")) {
            throw new IllegalArgumentException("Invalid DPT message");
        }

        try {
            String[] parts = nmeaMessage.split("[,*]");
            if (parts.length < 5) {
                throw new IllegalArgumentException("Incomplete DPT message");
            }

            MwvModel mwvModel = new MwvModel(parts[1], parts[2], parts[3], parts[4], parts[5]);
            return new MwvModel(mwvModel.getWindAngle(), mwvModel.getReference(), mwvModel.getWindSpeed(), mwvModel.getWindSpeedUnit(), mwvModel.getStatus());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error parsing DPT message: " + e.getMessage(), e);
        }
    }
}
