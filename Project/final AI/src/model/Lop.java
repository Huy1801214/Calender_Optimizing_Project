package model;

public class Lop {
    String maLop;
    String tenLop;

    public Lop(String tenLop, String maLop) {
        this.tenLop = tenLop;
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    @Override
    public String toString() {
        return tenLop;
    }
}
