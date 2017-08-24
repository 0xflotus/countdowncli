package de.zerox.flotus.util;

public class TimeConverter {

    private static String DEFAULT_TIME = "0:00";

    private String time;
    private int hours, minutes;

    public TimeConverter() {
        this.time = DEFAULT_TIME;
    }

    public TimeConverter(String time) {
        this.time = time;
        convertStringToMinutes();
    }

    public String convertMinutesToString(int allMinutes){
        if (allMinutes < 0) {
            return "Zeit ist abgelaufen.";
        }
        int tHours = allMinutes / 60;
        int tMinutes = allMinutes % 60;
        return String.format("%d:%02d", tHours, tMinutes);
    }

    public Integer convertStringToMinutes() {
        return convertStringToMinutes(this.time);
    }

    public Integer convertStringToMinutes(String time) {
        String[] arrayOfTime = time.split(":");
        this.hours = Integer.parseInt(arrayOfTime[0]);
        this.minutes = Integer.parseInt(arrayOfTime[1]);
        return this.hours * 60 + this.minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }
}
