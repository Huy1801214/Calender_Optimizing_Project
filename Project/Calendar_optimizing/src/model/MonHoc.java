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

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public int getSoTietTrongTuan() {
        return soTietTrongTuan;
    }

    public void setSoTietTrongTuan(int soTietTrongTuan) {
        this.soTietTrongTuan = soTietTrongTuan;
    }

    @Override
    public String toString() {
        return "MonHoc{" +
                ", tenMonHoc='" + tenMonHoc + '\'' +
                '}';
    }
}
