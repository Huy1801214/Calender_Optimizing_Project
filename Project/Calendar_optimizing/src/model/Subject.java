package model;

import java.util.List;

public class Subject {
    String id, name;
    List<Teacher> teachers;

    public Subject(String id, String name, List<Teacher> teachers) {
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

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
