package com.example.doctorsappointment;

public class TimeUtil {

    // Convert slot index to appointment time
    public static String getTimeFromSlot(int slot) {
        int totalMinutes;

        if (slot < 6) {
            // 10:00 AM start, 6 slots before lunch
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

    // Convert appointment time string to slot index
    public static int getSlotFromTime(String time) {
        String[] parts = time.split("[: ]"); // e.g., "10:30 AM"
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        String ampm = parts[2];

        if (ampm.equals("PM") && hour != 12) hour += 12;
        if (ampm.equals("AM") && hour == 12) hour = 0;

        int totalMinutes = hour * 60 + minute;

        if (totalMinutes >= 10 * 60 && totalMinutes < 13 * 60) {
            return (totalMinutes - 10 * 60) / 30;
        } else {
            return 6 + (totalMinutes - 15 * 60) / 30;
        }
    }
}
