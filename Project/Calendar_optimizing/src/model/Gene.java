package model;

public class Gene {
    Classroom classroom;
    Teacher teacher;
    TimeSlot timeSlot;
    Subject subject;

    public Gene(Classroom classroom, Teacher teacher, TimeSlot timeSlot, Subject subject) {
        this.classroom = classroom;
        this.teacher = teacher;
        this.timeSlot = timeSlot;
        this.subject = subject;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
