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
}
