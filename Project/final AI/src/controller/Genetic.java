package controller;

import data.Data;
import model.CaThe;
import model.Lop;
import model.QuanThe;

import java.util.ArrayList;
import java.util.List;
/*
danh giá qt hiện tại (set điểm) -> chọn cha mẹ -> lai ghép và đột biến
-> tao ra qt mới (dừng nếu đủ điểm hoặc hết thế hệ)
 */
public class Genetic {
    TaoQuanThe taoQuanThe;
    TaoGene taoGene;
    TaoCaThe taoCaThe;
    ChonLocVaLaiGhep chonLocVaLaiGhep;
    DanhGia danhGia;
    List<Lop> dsLop;
    CaThe caTheTimDuoc;
    DotBien dotBien;

    final int soTheHeToiDa = 200;
    final int diemDung = 1000;


    public Genetic() {
        taoQuanThe = new TaoQuanThe();
        taoGene = new TaoGene();
        taoCaThe = new TaoCaThe();
        chonLocVaLaiGhep = new ChonLocVaLaiGhep();
        danhGia = new DanhGia();
        dsLop = Data.taoDanhSachLop();
        caTheTimDuoc = new CaThe();
        dotBien = new DotBien();
    }

    public CaThe thuatToanGenetic(QuanThe quanTheHienTai) {
        int soTheHe = 0;
        while (soTheHe < soTheHeToiDa) {
            System.out.println("quan the hien tai trong the he " + (soTheHe + 1) );
            taoQuanThe.printQuanThe(quanTheHienTai);
            danhGia.danhGiaCacCaTheTrongQuanThe(quanTheHienTai);    // danh giá để set điểm cho quần thể hiện tại
            for(CaThe ct : quanTheHienTai.getQuanThe()) {
                System.out.println("Diem cua tung ca the ");
                System.out.println(ct.getFitnessScore());
            }
            for (CaThe caThe : quanTheHienTai.getQuanThe()) {
                if (caThe.getFitnessScore() == diemDung) {      // dừng nhanh
                    return caThe;
                }
            }

            List<CaThe> caTheChaMe = new ArrayList<>(chonLocVaLaiGhep.chonLocCaTheChaMe(quanTheHienTai)); // chọn lọc
            System.out.println("so luong ca the cha me" + caTheChaMe.size());
            for (CaThe chaMe : caTheChaMe) {
                System.out.println("cha hoac me ");
                chaMe.printCaThe();
            }

            CaThe cha = caTheChaMe.getFirst();
            CaThe me = caTheChaMe.getLast();
            List<CaThe> cacCaTheCon = new ArrayList<>(chonLocVaLaiGhep.laiGhep(cha, me));       // lai ghép và đột biến
            List<CaThe> cacCaTheConSauKhiDotBien = new ArrayList<>(dotBien.dotBien(cacCaTheCon));
            CaThe caTheNgauNhien = taoCaThe.taoCaThe(Data.taoDanhSachLop());

            QuanThe quanTheMoi = new QuanThe();
            quanTheMoi.getQuanThe().addAll(caTheChaMe);
            quanTheMoi.getQuanThe().addAll(cacCaTheConSauKhiDotBien);
            quanTheMoi.getQuanThe().add(caTheNgauNhien);                            // tạo ra quần thể mới

            quanTheHienTai.getQuanThe().clear();
            //System.out.println("kich thuoc quan the hien tai sau khi remove " + quanTheHienTai.getQuanThe().size());
            quanTheHienTai.getQuanThe().addAll(quanTheMoi.getQuanThe());        // lặp lại
            caTheChaMe.clear();

            System.out.println("quan the moi la " );
            taoQuanThe.printQuanThe(quanTheMoi);

            soTheHe++;
        }

        System.out.println("Ca the tot nhat tim duoc la ");
        return timCaTheTotNhatTrongQuanTheCuoiCungNeuKhongTimDuoc(quanTheHienTai);
    }

    private CaThe timCaTheTotNhatTrongQuanTheCuoiCungNeuKhongTimDuoc(QuanThe quanThe) {
        danhGia.danhGiaCacCaTheTrongQuanThe(quanThe);
        for(CaThe ct : quanThe.getQuanThe()) {
            System.out.println("Diem cua tung ca the ");
            System.out.println(ct.getFitnessScore());
        }        caTheTimDuoc = quanThe.getQuanThe().getFirst();
        for (CaThe caTheCon : quanThe.getQuanThe()) {
            if (caTheCon.getFitnessScore() >= caTheTimDuoc.getFitnessScore()) {
                caTheTimDuoc = caTheCon;
            }
        }
        return caTheTimDuoc;
    }

    public static void main(String[] args) {
        Genetic genetic = new Genetic();
        TaoQuanThe taoQuanThe = new TaoQuanThe();
        QuanThe quanThe = taoQuanThe.taoQuanThe(Data.taoDanhSachLop());
        CaThe caTheTotNhat = genetic.thuatToanGenetic(quanThe);
        if (caTheTotNhat != null) {
            caTheTotNhat.printCaThe();
        } else {
            System.out.println("ca the tot nhat null");
        }
    }
}
