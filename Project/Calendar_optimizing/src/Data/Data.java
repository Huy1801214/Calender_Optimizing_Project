package Data;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Data {
    public static List<Classroom> generateClassrooms() {
        List<Classroom> classrooms = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            String classroomId = "C" + i;
            String classroomName = "12A" + i;

            List<Chromosome> schedules = new ArrayList<>();
            schedules.add(generateRandomSchedule(classroomId, generateTeachers(), generateSubjects(), generateAvailableTimeSlots()));

            classrooms.add(new Classroom(classroomId, classroomName, schedules));
        }
        return classrooms;
    }

    public static List<Teacher> generateTeachers() {
        List<Teacher> teachers = new ArrayList<Teacher>();
        teachers.add(new Teacher("T1", "Nguyễn Văn A", List.of(new Subject("S1", "Ngữ Văn", new ArrayList<>())), generateAvailableTimeSlots()));
        teachers.add(new Teacher("T2", "Trần Thị B", List.of(new Subject("S2", "Toán", new ArrayList<>())), generateAvailableTimeSlots()));
        teachers.add(new Teacher("T3", "Lê Thị C", List.of(new Subject("S3", "Ngoại ngữ", new ArrayList<>())), generateAvailableTimeSlots()));
        teachers.add(new Teacher("T4", "Phạm Quang D", List.of(new Subject("S4", "Lịch sử", new ArrayList<>())), generateAvailableTimeSlots()));
        teachers.add(new Teacher("T5", "Đỗ Thị E", List.of(new Subject("S5", "Địa lí", new ArrayList<>())), generateAvailableTimeSlots()));
        teachers.add(new Teacher("T6", "Vũ Hoàng F", List.of(new Subject("S6", "Vật lí", new ArrayList<>())), generateAvailableTimeSlots()));
        teachers.add(new Teacher("T7", "Nguyễn Hoàng G", List.of(new Subject("S7", "Hóa học", new ArrayList<>())), generateAvailableTimeSlots()));
        teachers.add(new Teacher("T8", "Trần Minh H", List.of(new Subject("S8", "Sinh học", new ArrayList<>())), generateAvailableTimeSlots()));
        teachers.add(new Teacher("T9", "Lê Thiếu I", List.of(new Subject("S9", "Giáo công dân", new ArrayList<>())), generateAvailableTimeSlots()));
        teachers.add(new Teacher("T10", "Phan Thị J", List.of(new Subject("S10", "Giáo dục quốc phòng và an ninh", new ArrayList<>())), generateAvailableTimeSlots()));
        teachers.add(new Teacher("T11", "Bùi Hoàng K", List.of(new Subject("S11", "Công nghệ", new ArrayList<>())), generateAvailableTimeSlots()));
        teachers.add(new Teacher("T12", "Nguyễn Quang L", List.of(new Subject("S12", "Tin học", new ArrayList<>())), generateAvailableTimeSlots()));
        teachers.add(new Teacher("T13", "Vũ Thi M", List.of(new Subject("S1", "Ngữ Văn", new ArrayList<>())), generateAvailableTimeSlots()));
        teachers.add(new Teacher("T14", "Phan Thi N", List.of(new Subject("S2", "Toán", new ArrayList<>())), generateAvailableTimeSlots()));
        teachers.add(new Teacher("T15", "Lê Thị O", List.of(new Subject("S3", "Ngoại ngữ", new ArrayList<>())), generateAvailableTimeSlots()));
        teachers.add(new Teacher("T16", "Nguyễn Thi P", List.of(new Subject("S4", "Lịch sử", new ArrayList<>())), generateAvailableTimeSlots()));
        teachers.add(new Teacher("T17", "Đoàn Minh Q", List.of(new Subject("S5", "Địa lí", new ArrayList<>())), generateAvailableTimeSlots()));
        teachers.add(new Teacher("T18", "Trần Hoàng R", List.of(new Subject("S6", "Vật lí", new ArrayList<>())), generateAvailableTimeSlots()));
        teachers.add(new Teacher("T19", "Nguyễn Thi S", List.of(new Subject("S7", "Hóa học", new ArrayList<>())), generateAvailableTimeSlots()));
        teachers.add(new Teacher("T20", "Lê Minh T", List.of(new Subject("S8", "Sinh học", new ArrayList<>())), generateAvailableTimeSlots()));

        return teachers;
    }

    public static List<Subject> generateSubjects() {
        List<Subject> subjects = new ArrayList<>();

        subjects.add(new Subject("S1", "Ngữ Văn", new ArrayList<>()));
        subjects.add(new Subject("S2", "Toán", new ArrayList<>()));
        subjects.add(new Subject("S3", "Ngoại ngữ", new ArrayList<>()));
        subjects.add(new Subject("S4", "Lịch sử", new ArrayList<>()));
        subjects.add(new Subject("S5", "Địa lí", new ArrayList<>()));
        subjects.add(new Subject("S6", "Vật lí", new ArrayList<>()));
        subjects.add(new Subject("S7", "Hóa học", new ArrayList<>()));
        subjects.add(new Subject("S8", "Sinh học", new ArrayList<>()));
        subjects.add(new Subject("S9", "Giáo công dân", new ArrayList<>()));
        subjects.add(new Subject("S10", "Giáo dục quốc phòng và an ninh", new ArrayList<>()));
        subjects.add(new Subject("S11", "Công nghệ", new ArrayList<>()));
        subjects.add(new Subject("S12", "Tin học", new ArrayList<>()));

        return subjects;
    }

    // dam bao rang giao vien luon co the day moi tiet trong ngay
    public static List<TimeSlot> generateAvailableTimeSlots() {
        List<TimeSlot> timeSlots = new ArrayList<>();

        // Đảm bảo giáo viên có thể dạy tất cả các tiết từ 1 đến 10 trong mỗi ngày
        for (String day : List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")) {
            for (int period = 1; period <= 10; period++) {
                // Thêm một TimeSlot cho mỗi tiết từ 1 đến 10 cho các ngày trong tuần
                String session = period <= 5 ? "Morning" : "Afternoon";
                timeSlots.add(new TimeSlot(day, period, session));
            }
        }
        return timeSlots;
    }

    // random ra 1 thoi khoa bieu cho moi lop
    public static Chromosome generateRandomSchedule(String classroomId, List<Teacher> teachers, List<Subject> subjects, List<TimeSlot> timeSlots) {
        List<Gene> genes = new ArrayList<>();
        Random rand = new Random();

        for (TimeSlot timeSlot : timeSlots) {
            Teacher teacher = teachers.get(rand.nextInt(teachers.size()));
            Subject subject = subjects.get(rand.nextInt(subjects.size()));
            Gene gene = new Gene(new Classroom(classroomId, "Class " + classroomId, new ArrayList<>()), teacher, timeSlot, subject);

            genes.add(gene);
        }
        return new Chromosome(genes);
    }

    public static void main(String[] args) {
        List<Classroom> classrooms = Data.generateClassrooms();

        for(Classroom classroom : classrooms) {
            System.out.println("Class: " + classroom.getName());

            for(Chromosome schedule : classroom.getSchedules() ) {
                System.out.println("Schedule: ");
                for(Gene gene : schedule.getGenes()) {
                    System.out.println("    Teacher: " + gene.getTeacher().getName() +
                            ", Subject: " + gene.getSubject().getName() +
                            ", Time: " + gene.getTimeSlot().getDay() + " " +
                            "Period: " + gene.getTimeSlot().getPeriod());
                }
            }
        }
    }
}
