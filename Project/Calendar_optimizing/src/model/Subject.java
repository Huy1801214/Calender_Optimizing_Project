package model;

import java.util.Objects;

public class Subject {
    private int id;
    private String name;
    private int periodNumInWeek;
    private String classType;

    public Subject() {
    }

    public Subject(int id, String name, int periodNumInWeek, String classType) {
        this.id = id;
        this.name = name;
        this.periodNumInWeek = periodNumInWeek;
        this.classType = classType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPeriodNumInWeek() {
        return periodNumInWeek;
    }

    public void setPeriodNumInWeek(int periodNumInWeek) {
        this.periodNumInWeek = periodNumInWeek;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return id == subject.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
