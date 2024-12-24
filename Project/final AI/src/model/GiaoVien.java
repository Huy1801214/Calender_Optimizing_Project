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

    public List<MonHoc> getDsMonHocGVDay() {
        return dsMonHocGVDay;
    }

    public int getSoTietDayToiDaTrongTuan() {
        return soTietDayToiDaTrongTuan;
    }

    @Override
    public String toString() {
        return tenGV + '\'';
    }
}
