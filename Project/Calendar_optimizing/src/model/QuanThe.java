package model;

import java.util.List;

public class QuanThe {
    Lop lop;
    int size;
    List<ThoiKhoaBieu> quanThe;

    public QuanThe(Lop lop, int size, List<ThoiKhoaBieu> quanThe) {
        this.lop = lop;
        this.size = size;
        this.quanThe = quanThe;
    }

    public QuanThe() {
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<ThoiKhoaBieu> getQuanThe() {
        return quanThe;
    }

    public void setQuanThe(List<ThoiKhoaBieu> quanThe) {
        this.quanThe = quanThe;
    }

    public void inThongTinQuanThe() {
        System.out.println("Thông tin quần thể lớp: " + lop.getTenLop());
        for (int i = 0; i < quanThe.size(); i++) {
            System.out.println("Thời khóa biểu thứ " + (i + 1) + ":");
            quanThe.get(i).printTKB();
            System.out.println("--------------------");
        }
    }
}
