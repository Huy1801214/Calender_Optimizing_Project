package model;

import java.util.List;

public class GiaoVien {
    String maGV;
    String tenGV;
    List<MonHoc> dsMonHocGVDay;
    int soTietDayToiDaTrongTuan;

    public GiaoVien(String maGV, String tenGV, List<MonHoc> dsMonHocGVDay, int soTietDayToiDaTrongTuan) {
        this.maGV = maGV;
        this.tenGV = tenGV;
        this.dsMonHocGVDay = dsMonHocGVDay;
        this.soTietDayToiDaTrongTuan = soTietDayToiDaTrongTuan;
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

    public int getSoTietDayToiDaTrongTuan() {
        return soTietDayToiDaTrongTuan;
    }

    public void setSoTietDayToiDaTrongTuan(int soTietDayToiDaTrongTuan) {
        this.soTietDayToiDaTrongTuan = soTietDayToiDaTrongTuan;
    }

    @Override
    public String toString() {
        return tenGV + '\'';
    }
}
