package model;


public class MonHoc {
    String maMonHoc;
    String tenMonHoc;
    int soTietTrongTuan;

    public MonHoc(String maMonHoc, String tenMonHoc, int soTietTrongTuan) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.soTietTrongTuan = soTietTrongTuan;
    }

    @Override
    public String toString() {
        return tenMonHoc ;
    }
}
