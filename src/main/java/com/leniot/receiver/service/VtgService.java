package com.leniot.receiver.service;

import org.springframework.stereotype.Service;
import com.leniot.receiver.model.VtgModel;

@Service
public class VtgService {

    public VtgModel decode(String nmeaMessage) throws IllegalArgumentException {
        if (nmeaMessage == null || !nmeaMessage.startsWith("$--VTG,")) {
            throw new IllegalArgumentException("Invalid VTG message");
        }

        try {
            String[] parts = nmeaMessage.split("[,*]");
            if (parts.length < 9) {
                throw new IllegalArgumentException("Incomplete VTG message");
            }

            VtgModel vtgModel = new VtgModel(parts[1], parts[3], parts[5], parts[7], parts[9]);
            return new VtgModel(vtgModel.getCogTrue(), vtgModel.getCogMagnetic(), vtgModel.getSogKnots(), vtgModel.getSogKmhr(), vtgModel.getModeIndicator());

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error parsing DPT message: " + e.getMessage(), e);
        }
    }
}
