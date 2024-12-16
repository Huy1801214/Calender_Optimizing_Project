package controller;

import model.Lop;
import model.QuanThe;
import model.ThoiKhoaBieu;

public class Genetic {
    TaoTKB taoTKB;
    TaoQuanThe taoQuanThe;
    DanhGia danhGia;
    ChonLocVaLaiGhep chonLocVaLaiGhep;
    QuanThe quanThe, quanTheMoi;
    ThoiKhoaBieu tkbTimDuoc;

    // input
    final int kichThuocQuanThe = 5;
    final int soTheHeToiDa = 100;
    final int diemDung = 80;

    public ThoiKhoaBieu thuatToanGenetic(Lop lop) {
        taoTKB = new TaoTKB();
        taoQuanThe = new TaoQuanThe();
        danhGia = new DanhGia();
        chonLocVaLaiGhep = new ChonLocVaLaiGhep();

        quanThe = taoQuanThe.taoQuanTheChoMoiLop(lop, kichThuocQuanThe);
        for (int i = 0; i < soTheHeToiDa; i++) {
            danhGia.danhGiaCacTKBTrongQuanThe(quanThe);
            for (ThoiKhoaBieu tkb : quanThe.getQuanThe()) {
                if (tkb.getSoDiemFitness() >= diemDung) {
                    tkbTimDuoc = tkb;
                    break;
                }
            }
            quanTheMoi = chonLocVaLaiGhep.taoQuanTheMoiSauKhiChonLocVaLaiGhep(lop, quanThe);
            quanThe = quanTheMoi;
        }
        tkbTimDuoc = timTkbTotNhatTrongQuanTheCuoiCungNeuKhTimDuoc(quanThe);
        return tkbTimDuoc;
    }

    private ThoiKhoaBieu timTkbTotNhatTrongQuanTheCuoiCungNeuKhTimDuoc(QuanThe quanThe) {
        danhGia.danhGiaCacTKBTrongQuanThe(quanThe);
        tkbTimDuoc = quanThe.getQuanThe().get(0);
        for (ThoiKhoaBieu tkb : quanThe.getQuanThe()) {
            if (tkb.getSoDiemFitness() >= tkbTimDuoc.getSoDiemFitness()) {
                tkbTimDuoc = tkb;
            }
        }
        return tkbTimDuoc;
    }
}
