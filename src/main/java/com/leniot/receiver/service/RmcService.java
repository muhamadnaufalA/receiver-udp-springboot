package com.leniot.receiver.service;

import org.springframework.stereotype.Service;
import com.leniot.receiver.model.RmcModel;

@Service
public class RmcService {

    public RmcModel decode(String nmeaMessage) throws IllegalArgumentException {
        if (nmeaMessage == null || !nmeaMessage.startsWith("$--RMC,")) {
            throw new IllegalArgumentException("Invalid RMC message");
        }

        try {
            String[] parts = nmeaMessage.split("[,*]");
            if (parts.length < 12) {
                throw new IllegalArgumentException("Incomplete RMC message");
            }

            RmcModel rmcModel = new RmcModel(parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], parts[8], parts[9], parts[10], parts[11], parts[12]);
            return new RmcModel(rmcModel.getUtcTime(), rmcModel.getStatus(), rmcModel.getLatitude(), rmcModel.getLatitudePosition(), rmcModel.getLongitude(), rmcModel.getLongitudePosition(), rmcModel.getSog(), rmcModel.getCog(), rmcModel.getDate(), rmcModel.getMagnetic(), rmcModel.getDegrees(), rmcModel.getModeIndicator());

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error parsing DPT message: " + e.getMessage(), e);
        }
    }
}
