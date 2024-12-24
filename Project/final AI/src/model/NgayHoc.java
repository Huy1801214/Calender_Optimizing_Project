package model;

public class NgayHoc {
    int thu;
    MonHoc monHoc;
    Lop lop;
    GiaoVien giaoVien;

    public NgayHoc(int thu, MonHoc monHoc, Lop lop, GiaoVien giaoVien) {
        this.thu = thu;
        this.monHoc = monHoc;
        this.lop = lop;
        this.giaoVien = giaoVien;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    public GiaoVien getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(GiaoVien giaoVien) {
        this.giaoVien = giaoVien;
    }

    @Override
//    public String toString() {
//        return  "thu: " + (thu + 2) +
//                ", monHoc: " + monHoc +
//                ", lop: " + lop +
//                ", giaoVien: " + giaoVien;
//    }
    public String toString() {
        return monHoc + " " + giaoVien;
    }
}
