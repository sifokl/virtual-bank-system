package com.banking.system.vsbank.api.utils;

import java.time.Instant;

public class Utils {

    public static long generateID(){

        long longFromEpoch = Instant.now().toEpochMilli();
        return longFromEpoch;
    }

}
