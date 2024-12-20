package controller;

import Data.Data;
import model.*;

import java.util.ArrayList;
import java.util.List;

public class TaoQuanThe {
    TaoTKB tkb;

    public TaoQuanThe() {
    }

    public List<QuanThe> taoQuanThe(List<Lop> dsLop, int kichThuocQuanThe) {
        List<QuanThe> quanTheList = new ArrayList<>();

        for (Lop lop : dsLop) {
            quanTheList.add(taoQuanTheChoMoiLop(lop, kichThuocQuanThe));
        }
        return quanTheList;
    }

    public QuanThe taoQuanTheChoMoiLop(Lop lop, int kichThuocQuanThe) {
        List<ThoiKhoaBieu> dsTKB = new ArrayList<>();
        tkb = new TaoTKB();

        for (int i = 0; i < kichThuocQuanThe; i++) {
            ThoiKhoaBieu thoiKhoaBieu = tkb.taoTKBChoMoiLop(lop);
            dsTKB.add(thoiKhoaBieu);
        }
        return new QuanThe(lop, kichThuocQuanThe, dsTKB);
    }

    public static void main(String[] args) {
        List<Lop> dsLop = Data.taoDanhSachLop();
        TaoQuanThe taoQuanThe = new TaoQuanThe();

        int kichThuocQuanThe = 5; // Kích thước quần thể

        List<QuanThe> dsQuanThe;
        dsQuanThe = taoQuanThe.taoQuanThe(dsLop,kichThuocQuanThe);

        for(QuanThe qt : dsQuanThe){
            qt.inThongTinQuanThe();
            System.out.println("===================================================");
        }
    }
}
