package com.leniot.receiver.service;

import com.leniot.receiver.model.MwdModel;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MwdService {
    private static final Pattern NMEA_PATTERN = Pattern.compile("^\\$--MWD,(\\d+\\.\\d+),T,(\\d+\\.\\d+),M,(\\d+\\.\\d+),N,(\\d+\\.\\d+),M\\*\\w{2}\\r\\n$");

    public MwdModel encodeNmeaToMwd(String nmea) {
        Matcher matcher = NMEA_PATTERN.matcher(nmea);
        if (matcher.matches()) {
            return new MwdModel(matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(4));
        } else {
            throw new IllegalArgumentException("Invalid NMEA data");
        }
    }
}
