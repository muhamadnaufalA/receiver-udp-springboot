package com.leniot.receiver.service;

import com.leniot.receiver.model.PanzhrpModel;
import org.springframework.stereotype.Service;

@Service
public class PanzhrpService {

    public PanzhrpModel encodeNmeaToPanzhrp(String nmea) {
        String[] parts = nmea.split(",");
        if (parts.length == 10 && parts[0].equals("$PANZHRP") && parts[9].startsWith("*")) {
            return new PanzhrpModel(
                    parts[2],   // True Heading
                    parts[3],   // Roll
                    parts[4],   // Pitch
                    parts[5],   // Heading Rate
                    parts[6],   // Roll Rate
                    parts[7],   // Pitch Rate
                    parts[8].substring(0, 1)  // Status
            );
        } else {
            throw new IllegalArgumentException("Invalid NMEA data: " + nmea);
        }
    }
}
