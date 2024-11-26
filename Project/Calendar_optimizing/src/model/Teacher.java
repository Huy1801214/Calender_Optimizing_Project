package model;

import java.util.ArrayList;
import java.util.Objects;

public class Teacher {
    private int id;
    private String name;
    private int periodNumInWeek;
    private String classType;
    private int subjectId;
    private ArrayList<Classes> classes;

    public Teacher() {
    }

    public Teacher(int id, String name, int periodNumInWeek, String classType, int subjectId, ArrayList<Classes> classes) {
        this.id = id;
        this.name = name;
        this.periodNumInWeek = periodNumInWeek;
        this.classType = classType;
        this.subjectId = subjectId;
        this.classes = classes;
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

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public ArrayList<Classes> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<Classes> classes) {
        this.classes = classes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
