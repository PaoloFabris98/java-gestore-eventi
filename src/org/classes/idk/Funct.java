package org.classes.idk;

import java.text.SimpleDateFormat;

import java.util.Calendar;

public class Funct {
    public static String timeNow() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        return timeStamp;
    }

    public static String numberFormatted(int i) {
        return String.format("%02d", i);
    }

    public static boolean eventCreatorPremission(int temp) {
        if (temp == 5) {
            return false;
        } else {
            return true;
        }
    }

}
