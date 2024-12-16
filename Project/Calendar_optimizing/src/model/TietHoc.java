package model;

public class TietHoc {
    int thu, tiet;
    MonHoc monHoc;
    Lop lop;
    GiaoVien giaoVien;

    public TietHoc(int thu, int tiet, MonHoc monHoc, Lop lop, GiaoVien giaoVien) {
        this.thu = thu;
        this.tiet = tiet;
        this.monHoc = monHoc;
        this.lop = lop;
        this.giaoVien = giaoVien;
    }

    public int getThu() {
        return thu;
    }

    public void setThu(int thu) {
        this.thu = thu;
    }

    public int getTiet() {
        return tiet;
    }

    public void setTiet(int tiet) {
        this.tiet = tiet;
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
    public String toString() {
        return "TietHoc " +
                "thu=" + thu +
                ", tiet=" + tiet +
                ", monHoc=" + monHoc +
                ", lop=" + lop +
                ", giaoVien=" + giaoVien +
                '}';
    }
}
