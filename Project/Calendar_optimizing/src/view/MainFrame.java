package view;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class MainFrame extends JFrame {
    private JComboBox<String> classSelectComboBox;
    private JTable timetableTable;
    private DefaultTableModel tableModel;

    public MainFrame() {
        setTitle("Student Timetable");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initialize();

        setVisible(true);
    }

    private void initialize() {
        // Thiết lập layout chính cho cửa sổ
        setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel();
        JLabel headerLabel = new JLabel("Student Timetable");
        headerPanel.add(headerLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Tạo phần điều khiển cho việc chọn lớp học
        JPanel controlsPanel = new JPanel();
        controlsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        controlsPanel.add(new JLabel("Select Class:"));

        // Tạo combobox để chọn lớp học
        classSelectComboBox = new JComboBox<>(new String[]{"Class 1", "Class 2", "Class 3", "Class 4", "Class 5"});
        controlsPanel.add(classSelectComboBox);
        add(controlsPanel, BorderLayout.NORTH);

        // Tạo bảng thời khóa biểu
        String[] columns = {"Time Slot", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        // Mỗi dòng sẽ tương ứng với một tiết học, có 10 tiết
        String[][] data = new String[10][8]; // 10 dòng, 8 cột (1 cột "Time Slot" và 7 cột cho các ngày trong tuần)


        // Khởi tạo model cho bảng và dữ liệu
        tableModel = new DefaultTableModel(data, columns);
        timetableTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(timetableTable);
        add(tableScrollPane, BorderLayout.CENTER);

        // Tạo phần nút chức năng
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton logoutButton = new JButton("Logout");
        buttonsPanel.add(logoutButton);

        add(buttonsPanel, BorderLayout.SOUTH);

        // Mở rộng cửa sổ
        setSize(900, 600);
    }

    // Phương thức chính để khởi tạo và chạy ứng dụng
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame());
    }

}
