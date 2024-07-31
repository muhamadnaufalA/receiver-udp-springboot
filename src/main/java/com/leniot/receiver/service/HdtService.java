package com.leniot.receiver.service;

import com.leniot.receiver.model.HdtModel;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;

@Service
public class HdtService {
    private static final Pattern NMEA_PATTERN = Pattern.compile("^\\$--HDT,(\\d+\\.\\d+),T\\*\\w{2}\\r\\n$");

    public HdtModel encodeNmeaToHdt(String nmea) {
        Matcher matcher = NMEA_PATTERN.matcher(nmea);
        if (matcher.matches()) {
            HdtModel hdtModel = new HdtModel(matcher.group(1));
            return new HdtModel(hdtModel.getHeadingTrue());
        } else {
            throw new IllegalArgumentException("Invalid NMEA data");
        }
    }
}
