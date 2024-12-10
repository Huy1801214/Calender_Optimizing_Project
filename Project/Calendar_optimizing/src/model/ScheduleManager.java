package model;

import java.util.List;

public class ScheduleManager {
    List<Classroom> classes;
    List<Teacher> teachers;
    List<TimeSlot> timeSlots;

    public ScheduleManager(List<Classroom> classes, List<Teacher> teachers, List<TimeSlot> timeSlots) {
        this.classes = classes;
        this.teachers = teachers;
        this.timeSlots = timeSlots;
    }

    public List<Classroom> getClasses() {
        return classes;
    }

    public void setClasses(List<Classroom> classes) {
        this.classes = classes;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<TimeSlot> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(List<TimeSlot> timeSlots) {
        this.timeSlots = timeSlots;
    }

    public void addClassroom(Classroom classroom) {
        classes.add(classroom);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void addTimeSlot(TimeSlot timeSlot) {
        timeSlots.add(timeSlot);
    }

    public void removeClassroom(Classroom classroom) {
        classes.remove(classroom);
    }

    public void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
    }

    public void removeTimeSlot(TimeSlot timeSlot) {
        timeSlots.remove(timeSlot);
    }

}
