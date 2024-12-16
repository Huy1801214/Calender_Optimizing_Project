package view;

import Data.Data;
import model.Lop;
import model.ThoiKhoaBieu;
import model.TietHoc;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ThoiKhoaBieuView {

    // Phương thức hiển thị bảng thời khóa biểu trong cửa sổ Swing
    public void hienThiBieuDoThoiKhoaBieu(ThoiKhoaBieu thoiKhoaBieu) {
        // Tạo model cho bảng
        DefaultTableModel model = new DefaultTableModel();

        // Thêm cột cho bảng (Tiết học và các ngày trong tuần)
        model.addColumn("Tiết / Ngày");
        for (int ngay = 0; ngay < thoiKhoaBieu.getSoNgayTrongTuan(); ngay++) {
            model.addColumn("Thứ " + (ngay + 2));  // Cột Ngày (Thứ 2, Thứ 3, ..., Thứ 7)
        }

        // Duyệt qua các tiết học trong ngày và các ngày trong tuần để thêm dữ liệu vào bảng
        for (int tiet = 0; tiet < thoiKhoaBieu.getSoTietHocTrongNgay(); tiet++) {
            // Tạo một dòng mới cho mỗi tiết học trong ngày
            Object[] row = new Object[thoiKhoaBieu.getSoNgayTrongTuan() + 1];
            row[0] = "Tiết " + (tiet + 1);  // Cột "Tiết" (Tiết 1, Tiết 2, ..., Tiết 10)

            // Duyệt qua các ngày trong tuần
            for (int ngay = 0; ngay < thoiKhoaBieu.getSoNgayTrongTuan(); ngay++) {
                TietHoc tietHoc = thoiKhoaBieu.getTietHoc(ngay, tiet);
                if (tietHoc != null) {
                    row[ngay + 1] = tietHoc.getMonHoc().getTenMonHoc() + "<br>GV: " + tietHoc.getGiaoVien().getTenGV();
                } else {
                    row[ngay + 1] = "--------";
                }
            }

            // Thêm dòng vào bảng
            model.addRow(row);
        }

        // Tạo bảng với model đã tạo
        JTable table = new JTable(model);
        table.setFillsViewportHeight(true);  // Đảm bảo bảng sẽ kéo dài hết cửa sổ

        // Đặt bảng trong JScrollPane để cuộn được
        JScrollPane scrollPane = new JScrollPane(table);

        // Tạo cửa sổ JFrame để hiển thị
        JFrame frame = new JFrame("Thời Khóa Biểu - Lớp " + thoiKhoaBieu.getLop().getTenLop());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane);  // Thêm bảng vào cửa sổ
        frame.setSize(800, 600); // Kích thước cửa sổ
        frame.setLocationRelativeTo(null);  // Đặt cửa sổ ở giữa màn hình
        frame.setVisible(true);  // Hiển thị cửa sổ
    }

    public static void main(String[] args) {
        // Lấy lớp đầu tiên trong danh sách lớp của Data
        Lop lopDauTien = Data.taoDanhSachLop().get(0); // Lop "12A1"

        // Giả sử đã có thời khóa biểu cho lớp (tạo hoặc tìm kiếm thời khóa biểu trong dữ liệu)
        ThoiKhoaBieu thoiKhoaBieu = new ThoiKhoaBieu(lopDauTien);

        ThoiKhoaBieuView view = new ThoiKhoaBieuView();
        view.hienThiBieuDoThoiKhoaBieu(thoiKhoaBieu);
    }
}
