package model;

public class Lop {
    String maLop;
    String tenLop;

    public Lop(String tenLop, String maLop) {
        this.tenLop = tenLop;
        this.maLop = maLop;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    @Override
    public String toString() {
        return "Lop " + tenLop ;
    }
}
