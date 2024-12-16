package controller;

import Data.Data;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaoTKB {
    Random rand = new Random();
    ThoiKhoaBieu tkb;
    List<MonHoc> dsMonHoc;
    List<GiaoVien> dsGiaoVien;
    Data data;

    public TaoTKB() {
    }

    public ThoiKhoaBieu taoTKBChoMoiLop(Lop lop) {
        tkb = new ThoiKhoaBieu(lop);
        dsGiaoVien = data.taoDanhSachGiaoVien();
        dsMonHoc = data.taoDanhSachMonHoc();

        for (int i = 0; i < tkb.getSoNgayTrongTuan(); i++) {
            for (int j = 0; j < tkb.getSoTietHocTrongNgay(); j++) {
                MonHoc monHoc = dsMonHoc.get(rand.nextInt(dsMonHoc.size()));
                GiaoVien giaoVien = chonGiaoVienThichHop(monHoc);
                TietHoc tietHoc = new TietHoc(i, j, monHoc, lop, giaoVien);
                tkb.setTietHoc(i, j, tietHoc);
            }
        }
        return tkb;
    }

    private GiaoVien chonGiaoVienThichHop(MonHoc monHoc) {
        List<GiaoVien> dsGiaoVienThichHopChoMonHoc = new ArrayList<>();

        for (GiaoVien giaoVien : dsGiaoVien) {
            if (giaoVien.getDsMonHocGVDay().contains(monHoc)) {
                dsGiaoVienThichHopChoMonHoc.add(giaoVien);
            }
        }
        GiaoVien giaoVienThichHop = dsGiaoVienThichHopChoMonHoc.get(rand.nextInt(dsGiaoVienThichHopChoMonHoc.size()));
        return giaoVienThichHop;
    }

    public static void main(String[] args) {
        TaoTKB taoTKB = new TaoTKB();
        Lop lop = Data.taoDanhSachLop().get(1);
        ThoiKhoaBieu t = taoTKB.taoTKBChoMoiLop(lop);
        t.printTKB();
    }
}
