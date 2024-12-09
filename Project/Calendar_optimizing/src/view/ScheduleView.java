package view;

import model.Chromosome;
import model.Classroom;
import model.Gene;
import model.TimeSlot;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class ScheduleView {
    JComboBox<String> classSelectComboBox;
    JTable timetableMorningTable, timetableAfternoonTable;
    DefaultTableModel morningTableModel, afternoonTableModel;
    MainFrame frame;

    public ScheduleView(MainFrame frame) {
        this.frame = frame;
    }
    public void initialize() {
        // Thiết lập layout chính cho cửa sổ
        frame.setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel();
        JLabel headerLabel = new JLabel("Student Timetable");
        headerPanel.add(headerLabel);
        frame.add(headerPanel, BorderLayout.NORTH);

        // Tạo phần điều khiển cho việc chọn lớp học
        JPanel controlsPanel = new JPanel();
        controlsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        controlsPanel.add(new JLabel("Select Class:"));

        // Tạo combobox để chọn lớp học
        String[] classNames = frame.classrooms.stream().map(Classroom::getName).toArray(String[]::new);
        classSelectComboBox = new JComboBox<>(classNames);
        classSelectComboBox.addActionListener(_ -> updateTimetable());
        controlsPanel.add(classSelectComboBox);
        frame.add(controlsPanel, BorderLayout.NORTH);

        // Tạo phần bảng thời khóa biểu cho buổi sáng
        String[] columns = {"Time Slot", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        String[][] morningData = new String[5][7]; // 5 tiết sáng

        morningTableModel = new DefaultTableModel(morningData, columns);
        timetableMorningTable = new JTable(morningTableModel);
        adjustTableAppearance(timetableMorningTable);
        JScrollPane morningScrollPane = new JScrollPane(timetableMorningTable);

        // Tạo phần bảng thời khóa biểu cho buổi chiều
        String[][] afternoonData = new String[5][7]; // 5 tiết chiều

        afternoonTableModel = new DefaultTableModel(afternoonData, columns);
        timetableAfternoonTable = new JTable(afternoonTableModel);
        adjustTableAppearance(timetableAfternoonTable);
        JScrollPane afternoonScrollPane = new JScrollPane(timetableAfternoonTable);

        // Panel chứa cả 2 bảng thời khóa biểu
        JPanel timetablePanel = new JPanel();
        timetablePanel.setLayout(new GridLayout(2, 1)); // Chia ra làm 2 hàng (1 cho sáng, 1 cho chiều)
        timetablePanel.add(morningScrollPane);
        timetablePanel.add(afternoonScrollPane);

        frame.add(timetablePanel, BorderLayout.CENTER);

        // Tạo phần nút chức năng
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton logoutButton = new JButton("Logout");
        buttonsPanel.add(logoutButton);

        frame.add(buttonsPanel, BorderLayout.SOUTH);

        // Mở rộng cửa sổ
        frame.setSize(1600, 800);
    }
    private void updateTimetable() {
        int selectedIndex = classSelectComboBox.getSelectedIndex();
        if (selectedIndex >= 0) {
            Classroom selectedClassroom = frame.classrooms.get(selectedIndex);
            Chromosome schedule = selectedClassroom.getSchedules().getFirst(); // Giả sử mỗi lớp chỉ có 1 lịch học

            // Xóa dữ liệu cũ trong bảng sáng và chiều
            for (int row = 0; row < morningTableModel.getRowCount(); row++) {
                for (int col = 1; col < morningTableModel.getColumnCount(); col++) {
                    morningTableModel.setValueAt("", row, col);
                }
            }
            for (int row = 0; row < afternoonTableModel.getRowCount(); row++) {
                for (int col = 1; col < afternoonTableModel.getColumnCount(); col++) {
                    afternoonTableModel.setValueAt("", row, col);
                }
            }

            // Điền dữ liệu mới vào bảng sáng và chiều
            for (Gene gene : schedule.getGenes()) {
                TimeSlot timeSlot = gene.getTimeSlot();
                int periodIndex = timeSlot.getPeriod() - 1; // Chỉ lấy tiết đầu tiên trong danh sách period
                String day = timeSlot.getDay();
                String subjectTeacher = gene.getSubject().getName() + " (" + gene.getTeacher().getName() + ")";

                // Nếu là tiết sáng (1-5)
                if (periodIndex < 5) {
                    createScheduleDayAndAfternoon(periodIndex, day, subjectTeacher, morningTableModel);
                }
                // Nếu là tiết chiều (6-10)
                else {
                    periodIndex -= 5; // Điều chỉnh lại chỉ số
                    createScheduleDayAndAfternoon(periodIndex, day, subjectTeacher, afternoonTableModel);
                }
            }
        }
    }

    private void createScheduleDayAndAfternoon(int periodIndex, String day, String subjectTeacher, DefaultTableModel morningTableModel) {
        switch (day) {
            case "Monday":
                morningTableModel.setValueAt(subjectTeacher, periodIndex, 1);
                break;
            case "Tuesday":
                morningTableModel.setValueAt(subjectTeacher, periodIndex, 2);
                break;
            case "Wednesday":
                morningTableModel.setValueAt(subjectTeacher, periodIndex, 3);
                break;
            case "Thursday":
                morningTableModel.setValueAt(subjectTeacher, periodIndex, 4);
                break;
            case "Friday":
                morningTableModel.setValueAt(subjectTeacher, periodIndex, 5);
                break;
            case "Saturday":
                morningTableModel.setValueAt(subjectTeacher, periodIndex, 6);
                break;
        }
    }

    // Phương thức để điều chỉnh giao diện của bảng (cỡ chữ, kích thước ô)
    private void adjustTableAppearance(JTable table) {
        table.setRowHeight(40);  // Tăng chiều cao hàng
        table.setFont(new Font("Arial", Font.PLAIN, 14)); // Đặt font chữ cho bảng
        TableColumnModel columnModel = table.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setPreferredWidth(150); // Tăng chiều rộng cột
        }
    }

}
