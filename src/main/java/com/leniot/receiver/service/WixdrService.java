package com.leniot.receiver.service;

import com.leniot.receiver.model.WixdrModel;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class WixdrService {
    private static final Pattern NMEA_PATTERN = Pattern.compile("^\\$WIXDR,P,(\\d+\\.\\d+),B.*C,(\\d+\\.\\d+),C.*H,(\\d+\\.\\d+),P.*C,(\\d+\\.\\d+),C.*\\*\\w{2}\\r\\n$");

    public WixdrModel encodeNmeaToWixdr(String nmea) {
        Matcher matcher = NMEA_PATTERN.matcher(nmea);
        if (matcher.matches()) {
            return new WixdrModel(
                matcher.group(1), // Air Pressure
                matcher.group(2), // Air Temperature
                matcher.group(3), // Relative Humidity
                matcher.group(4)  // Water Temperature
            );
        } else {
            throw new IllegalArgumentException("Invalid NMEA data");
        }
    }
}
