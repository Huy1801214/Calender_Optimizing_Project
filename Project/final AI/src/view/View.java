package view;

import controller.Genetic;
import controller.TaoQuanThe;
import data.Data;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {
    CaThe caThe;
    JTable tkbTable;
    DefaultTableModel tableModel;
    JButton exitBtn;

    public View(CaThe caThe) throws HeadlessException {
        this.caThe = caThe;
        this.inIt();
    }

    private void inIt() {
        setTitle("Thời khóa biểu của các lớp");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new String[]{"Lớp", "Thứ Hai", "Thứ Ba", "Thứ Tư", "Thứ Năm", "Thứ Sáu"}, 0);
        tkbTable = new JTable(tableModel);

        themDuLieu(caThe);

        exitBtn = new JButton("Exit");
        exitBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(new JScrollPane(tkbTable), BorderLayout.CENTER);
        add(exitBtn, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void themDuLieu(CaThe caThe) {
        tableModel.setRowCount(0);

        for (Gene gene : caThe.getGenes()) {
            String[] duLieuTungLop = new String[Data.taoDanhSachLop().size() + 1];
            Lop lop = gene.getLop();
            duLieuTungLop[0] = lop.getTenLop().toString();
            for (int i = 0; i < Data.taoDanhSachLop().size(); i++) {
                NgayHoc ngayHoc = gene.getNgayHoc(i, 0);
                if (ngayHoc != null) {
                    duLieuTungLop[i + 1] = ngayHoc.toString();
                } else {
                    duLieuTungLop[i] = "----------";
                }
            }
            tableModel.addRow(duLieuTungLop);
        }
    }

    public static void main(String[] args) {
        Genetic genetic = new Genetic();
        TaoQuanThe taoQuanThe = new TaoQuanThe();
        QuanThe quanThe = taoQuanThe.taoQuanThe(Data.taoDanhSachLop());
        CaThe caTheTotNhat = genetic.thuatToanGenetic(quanThe);

        new View(caTheTotNhat);
    }
}
