/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skinconsultationcentre;

/**
 *
 * @author abuba
 */
public class Time {

    private int hour;
    private int minute;

    public Time(int hour, int minute) {

        this.hour = hour;
        this.minute = minute;
    }

    public void setHour(int h) {
        this.hour = h;
    }

    public void setMinute(int min) {
        this.minute = min;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        String dateTime = String.format("%02d:%02d", hour, minute);
        return dateTime;
    }
}
