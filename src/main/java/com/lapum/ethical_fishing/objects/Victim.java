package com.lapum.ethical_fishing.objects;

import net.thegreshams.firebase4j.model.FirebaseResponse;
import sun.awt.OSInfo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

public class Victim {
    private final static String TIMESTAMP_KEY = "timestamp";
    private final static String USERNAME_KEY = "user";
    private final static String OS_KEY = "operating_system";

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
    private String timestamp = dtf.format(LocalDateTime.now());
    private String userName = System.getProperty("user.name");
    private String os = OSInfo.getOSType().name();

    public Map<String, Object> toData() {
        Map<String, Object> data = new LinkedHashMap<>();

        data.put(TIMESTAMP_KEY, timestamp);
        data.put(USERNAME_KEY, userName);
        data.put(OS_KEY, os);

        return data;
    }

    public void fromData(FirebaseResponse response) {
        this.timestamp = (String) response.getBody().get(TIMESTAMP_KEY);
        this.userName = (String) response.getBody().get(USERNAME_KEY);
        this.os = (String) response.getBody().get(OS_KEY);
    }
}
