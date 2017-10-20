package com.gmaslowski.async.serviuce;

import java.util.List;

import static org.hibernate.validator.internal.util.CollectionHelper.newArrayList;

public class LongRunningButActuallySleepingService {

    public static List<String> longRunning() {
        try {
            Thread.sleep(15000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return newArrayList();
    }

    public static String longRunning(String req) {
        try {
            Thread.sleep(15000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello " + req;
    }

}
