package controller;

import model.Lop;
import model.QuanThe;
import model.ThoiKhoaBieu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
phương pháp chọn lọc theo tournament
    b1: chọn random 1 nhóm cá thể (tkb) trong quần thể (dstkb)
    b2: so sanh diem cac cá thể
    b3: chọn ra cá thể tốt nhất
    b4: lặp lại cho đến khi tạo ra được quần thể mới
phương pháp lai ghép (lai ghép 1 điểm)
    b1: chon 1 diem bat ki từ cha hoặc mẹ
    b2: swap các cá thể cua cha và mẹ
đột biến

Tạo ra quần thể mới
 */
public class ChonLocVaLaiGhep {
    ThoiKhoaBieu tkbBest, caThe;
    Random rand = new Random();
    DanhGia danhGia;
    double tiLeDotBien = 0.05;

    public ChonLocVaLaiGhep() {
    }

    // chọn loc
    public ThoiKhoaBieu chonLocChaMeCuaMoiLop(Lop lop, QuanThe quanThe) {
        return chonLocTKBTheoTournament(quanThe);
    }

    // lai ghép
    public ThoiKhoaBieu[] laiGhep(Lop lop, ThoiKhoaBieu cha, ThoiKhoaBieu me) {
        ThoiKhoaBieu con1 = new ThoiKhoaBieu(lop);
        ThoiKhoaBieu con2 = new ThoiKhoaBieu(lop);

        int diemGiaoTheoNgay = rand.nextInt(cha.getSoNgayTrongTuan());
        int diemGiaoTheoTiet = rand.nextInt(cha.getSoTietHocTrongNgay());
        for (int i = 0; i < cha.getSoNgayTrongTuan(); i++) {
            for (int j = 0; j < cha.getSoTietHocTrongNgay(); j++) {
                if (i < diemGiaoTheoNgay || (i == diemGiaoTheoNgay && j < diemGiaoTheoTiet)) {
                    con1.setTietHoc(i, j, cha.getTietHoc(i, j));
                    con2.setTietHoc(i, j, me.getTietHoc(i, j));
                } else {
                    con1.setTietHoc(i, j, me.getTietHoc(i, j));
                    con2.setTietHoc(i, j, cha.getTietHoc(i, j));
                }
            }
        }
        return new ThoiKhoaBieu[]{con1, con2};
    }

    // đột biến
    public ThoiKhoaBieu dotBien(Lop lop, ThoiKhoaBieu thoiKhoaBieu) {
        return thoiKhoaBieu;
    }

    // tạo ra quan thể mới
    public QuanThe taoQuanTheMoiSauKhiChonLocVaLaiGhep(Lop lop, QuanThe quanTheHienTai) {
        QuanThe quanTheMoi = new QuanThe();

        while (quanTheMoi.getQuanThe().size() < quanTheHienTai.getQuanThe().size()) {
            ThoiKhoaBieu cha = chonLocChaMeCuaMoiLop(lop, quanTheHienTai);
            ThoiKhoaBieu me = chonLocChaMeCuaMoiLop(lop, quanTheHienTai);

            ThoiKhoaBieu[] cacCaTheCon = laiGhep(lop, cha, me);
            dotBien(lop, cacCaTheCon[rand.nextInt(cacCaTheCon.length)]);
            quanTheMoi.getQuanThe().add(cacCaTheCon[0]);
            quanTheMoi.getQuanThe().add(cacCaTheCon[1]);
        }
        return quanTheMoi;
    }

    private ThoiKhoaBieu chonLocTKBTheoTournament(QuanThe quanThe) {
        tkbBest = null;
        for (int i = 0; i < quanThe.getSize(); i++) {
            caThe = quanThe.getQuanThe().get(rand.nextInt(quanThe.getQuanThe().size()));
            if (tkbBest == null || danhGia.tinhFitnessScore(caThe) > danhGia.tinhFitnessScore(tkbBest)) {
                tkbBest = caThe;
            }
        }
        return tkbBest;
    }
}
