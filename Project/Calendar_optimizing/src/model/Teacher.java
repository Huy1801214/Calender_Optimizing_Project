package model;

import java.util.List;

public class Teacher {
    String id, name;
    List<Subject> subjects;
    List<TimeSlot> availableTimeSlots;

    public Teacher(String id, String name, List<Subject> subjects, List<TimeSlot> availableTimeSlots) {
        this.id = id;
        this.name = name;
        this.subjects = subjects;
        this.availableTimeSlots = availableTimeSlots;
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

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<TimeSlot> getAvailableTimeSlots() {
        return availableTimeSlots;
    }

    public void setAvailableTimeSlots(List<TimeSlot> availableTimeSlots) {
        this.availableTimeSlots = availableTimeSlots;
    }
}
