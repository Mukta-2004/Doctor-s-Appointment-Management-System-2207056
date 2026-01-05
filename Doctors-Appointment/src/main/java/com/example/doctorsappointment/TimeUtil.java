package com.example.doctorsappointment;

public class TimeUtil {

    public static String getTimeFromSlot(int slot) {
        int totalMinutes;

        if (slot < 6) {
            // 10:00 AM start
            totalMinutes = 10 * 60 + slot * 30;
        } else {
            // After lunch → 3:00 PM
            totalMinutes = 15 * 60 + (slot - 6) * 30;
        }

        int hour = totalMinutes / 60;
        int minute = totalMinutes % 60;

        String ampm = hour >= 12 ? "PM" : "AM";
        if (hour > 12) hour -= 12;

        return String.format("%02d:%02d %s", hour, minute, ampm);
    }
}
