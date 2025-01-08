package org.classes.idk;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Funct {
    public static String timeNow() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        return timeStamp;
    }

    public static boolean dayPassed(String i) {
        return (Integer.parseInt(timeNow()) > Integer.parseInt(i));
    }

    public static String minuteHourNow() {
        String timeStamp = new SimpleDateFormat("HHmm").format(Calendar.getInstance().getTime());
        return timeStamp;
    }

    public static String numberFormatted(int i) {
        return String.format("%02d", i);
    }

    public static boolean eventCreatorPremission(int temp) {
        try {

            if (temp == 9) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("La selezione può contenere solo numeri interi: 1-5");
        }
    }

}
