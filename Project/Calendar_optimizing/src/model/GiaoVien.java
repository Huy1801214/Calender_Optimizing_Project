package model;

import java.util.List;

public class GiaoVien {
    String maGV;
    String tenGV;
    List<MonHoc> dsMonHocGVDay;
    int soTietDayTrongTuan;

    public GiaoVien(String maGV, String tenGV, List<MonHoc> dsMonHocGVDay, int soTietDayTrongTuan) {
        this.maGV = maGV;
        this.tenGV = tenGV;
        this.dsMonHocGVDay = dsMonHocGVDay;
        this.soTietDayTrongTuan = soTietDayTrongTuan;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public List<MonHoc> getDsMonHocGVDay() {
        return dsMonHocGVDay;
    }

    public void setDsMonHocGVDay(List<MonHoc> dsMonHocGVDay) {
        this.dsMonHocGVDay = dsMonHocGVDay;
    }

    public int getSoTietDayTrongTuan() {
        return soTietDayTrongTuan;
    }

    public void setSoTietDayTrongTuan(int soTietDayTrongTuan) {
        this.soTietDayTrongTuan = soTietDayTrongTuan;
    }

    @Override
    public String toString() {
        return "GiaoVien" + tenGV + '\'';
    }
}
