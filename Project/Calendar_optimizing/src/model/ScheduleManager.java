package model;

import java.util.ArrayList;
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

    // tim tat ca cac giao vien day mon hoc
    public List<Teacher> getTeacherBySubject(Subject subject) {
        List<Teacher> rs = new ArrayList<Teacher>();

        for (Teacher teacher : teachers) {
            if (teacher.getSubjects().contains(subject)) {
                rs.add(teacher);
            }
        }
        return rs;
    }

//    //tim cac tiet hoc trong 1 lop
//    public List<TimeSlot> getTimeSlotForClass(Classroom classroom) {
//        List<TimeSlot> rs = new ArrayList<>();
//
//        for (Gene gene : classroom.getSchedules()) {
//            rs.add(gene.getTimeSlot());
//        }
//        return rs;
//    }
//
//    //tim tat ca cac lop hoc co giao vien day
//    public List<Classroom> getClassroomByTeacher(Teacher teacher) {
//        List<Classroom> rs = new ArrayList<>();
//
//        for (Classroom classroom : classes) {
//            for (Gene gene : classroom.getSchedules()) {
//                if (gene.getTeacher().equals(teacher)) {
//                    rs.add(classroom);
//                }
//            }
//        }
//        return rs;
//    }
//
//    // kiem tra giao vien da duoc phan cong cho 1 tiet hoc chua
//    public boolean isTeacherAvailable(Teacher teacher, TimeSlot timeSlot) {
//        for (Classroom classroom : classes) {
//            for (Gene gene : classroom.getSchedules()) {
//                if (gene.getTeacher().equals(teacher) && gene.getTimeSlot().equals(timeSlot)) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    // kiem tra mot lop da co giao vien nao day trong tiet do chua
//    public boolean isClassroomAvailable(Classroom classroom, TimeSlot timeSlot) {
//        for (Gene gene : classroom.getSchedules()) {
//            if (gene.getTimeSlot().equals(timeSlot)) {
//                return false;
//            }
//        }
//        return true;
//    }

    //tinh toan do phu hop cua thoi khoa bieu
}
