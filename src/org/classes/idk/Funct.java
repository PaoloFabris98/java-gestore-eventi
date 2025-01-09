package org.classes.idk;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

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

            if (temp == 8) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("La selezione può contenere solo numeri interi: 1-5");
        }
    }

    public static int randomDay() {
        Random rand = new Random();
        return (rand.nextInt(30) + 1);

    }

    public static int randomMonth() {
        Random rand = new Random();
        return (rand.nextInt(11) + 1);
    }

    public static int postiRandom() {
        Random rand = new Random();
        return (rand.nextInt(5000) + 100);
    }

    public static int minutiRandom() {
        Random rand = new Random();
        return (rand.nextInt(58) + 1);
    }

    public static int oreRandom() {
        Random rand = new Random();
        return (rand.nextInt(22) + 1);
    }

    public static Double costoRandom() {
        Double temp = Math.random() * 500 + 1;
        return (double) Math.round(temp * 100) / 100;
    }

}
