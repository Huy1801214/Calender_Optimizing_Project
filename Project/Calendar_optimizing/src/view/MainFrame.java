package view;

import Data.Data;
import model.Classroom;


import javax.swing.*;
import java.util.List;


public class MainFrame extends JFrame {
    List<Classroom> classrooms;
    ScheduleView scheduleView;

    public MainFrame() {
        setTitle("Student Timetable");
        setSize(1600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        scheduleView = new ScheduleView(this);
        classrooms = Data.generateClassrooms();
        scheduleView.initialize();

        setVisible(true);
    }

    // Phương thức chính để khởi tạo và chạy ứng dụng
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }

}
