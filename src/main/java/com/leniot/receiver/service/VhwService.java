package com.leniot.receiver.service;

import com.leniot.receiver.model.VhwModel;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;

@Service
public class VhwService {
    private static final Pattern NMEA_PATTERN = Pattern.compile("^\\$--VHW,(\\d+\\.\\d+),T,(\\d+\\.\\d+),M,(\\d+\\.\\d+),N,(\\d+\\.\\d+),K\\*\\w{2}\\r\\n$");

    public VhwModel encodeNmeaToVhw(String nmea) {
        Matcher matcher = NMEA_PATTERN.matcher(nmea);
        if (matcher.matches()) {
            VhwModel vhwModel = new VhwModel(matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(4));
            return new VhwModel(vhwModel.getHeadingTrue(), vhwModel.getHeadingMagnetic(), vhwModel.getSpeedKnot(), vhwModel.getSpeedKm());
        } else {
            throw new IllegalArgumentException("Invalid NMEA data");
        }
    }
}
