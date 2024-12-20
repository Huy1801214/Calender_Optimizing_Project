package controller;

import data.Data;
import model.CaThe;
import model.Lop;
import model.QuanThe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaoQuanThe {
    Random rand;
    TaoCaThe taoCaThe;

    final int kichThuocQuanThe = Data.taoDanhSachLop().size();

    public TaoQuanThe() {
        taoCaThe = new TaoCaThe();
        rand = new Random();
    }

    public QuanThe taoQuanThe(List<Lop> dsLop) {
        List<CaThe> quanThe = new ArrayList<>();
        for (int i = 0; i < kichThuocQuanThe; i++) {
            CaThe caThe = taoCaThe.taoCaThe(dsLop);
            quanThe.add(caThe);
        }
        return new QuanThe(quanThe);
    }

    public void printQuanThe(QuanThe quanThe1) {
        DanhGia danhGia = new DanhGia();
        danhGia.danhGiaCacCaTheTrongQuanThe(quanThe1);
        for (int i = 0; i < quanThe1.getQuanThe().size(); i++) {
            System.out.println("Ca The thu " + (i + 1));
            quanThe1.getQuanThe().get(i).printCaThe();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<Lop> dsLop = Data.taoDanhSachLop();
        TaoQuanThe taoQuanThe = new TaoQuanThe();
        QuanThe quanThe = taoQuanThe.taoQuanThe(dsLop);
        taoQuanThe.printQuanThe(quanThe);
    }
}
