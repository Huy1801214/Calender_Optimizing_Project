package model;

import java.util.ArrayList;
import java.util.Objects;

public class Classes {
    private String id;
    private String name;
    private ArrayList<Teacher> teachers;

    public Classes() {
    }

    public Classes(String id, String name, ArrayList<Teacher> teachers) {
        this.id = id;
        this.name = name;
        this.teachers = teachers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Teacher> getTeacher() {
        return teachers;
    }

    public void setTeacher(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classes classes = (Classes) o;
        return id == classes.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
