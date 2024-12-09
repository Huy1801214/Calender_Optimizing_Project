package model;

import java.util.List;

public class TimeSlot {
    String day;
    int period;
    String session;

    public TimeSlot(String day, int period, String session) {
        this.day = day;
        this.period = period;
        this.session = session;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
