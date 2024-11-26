package model;

public class Calendar {
    private int periodNumInWeek;
    private Classes classes;

    public Calendar() {
    }

    public Calendar(int periodNumInWeek, Classes classes) {
        this.periodNumInWeek = periodNumInWeek;
        this.classes = classes;
    }

    public int getPeriodNumInWeek() {
        return periodNumInWeek;
    }

    public void setPeriodNumInWeek(int periodNumInWeek) {
        this.periodNumInWeek = periodNumInWeek;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }


}
