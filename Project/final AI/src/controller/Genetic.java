package controller;

import data.Data;
import model.CaThe;
import model.Lop;
import model.QuanThe;

import java.util.ArrayList;
import java.util.List;

public class Genetic {
    TaoQuanThe taoQuanThe;
    TaoGene taoGene;
    TaoCaThe taoCaThe;
    ChonLocVaLaiGhep chonLocVaLaiGhep;
    DanhGia danhGia;
    List<Lop> dsLop;
    CaThe caTheTimDuoc;
    DotBien dotBien;

    final int kichThuocQuanThe = Data.taoDanhSachLop().size();
    final int soTheHeToiDa = 100;
    final int diemDung = 800;


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
            danhGia.danhGiaCacCaTheTrongQuanThe(quanTheHienTai);
            for (CaThe caThe : quanTheHienTai.getQuanThe()) {
                if (caThe.getFitnessScore() >= diemDung) {
                    return caThe;
                }
            }

            List<CaThe> caTheChaMe = new ArrayList<>(chonLocVaLaiGhep.chonLocCaTheChaMe(quanTheHienTai));
            System.out.println("so luong ca the cha me" + caTheChaMe.size());
            for (CaThe chaMe : caTheChaMe) {
                System.out.println("cha hoac me ");
                chaMe.printCaThe();
            }

            QuanThe quanTheMoi = new QuanThe();
            quanTheMoi.getQuanThe().addAll(caTheChaMe);

            CaThe cha = caTheChaMe.getFirst();
            CaThe me = caTheChaMe.getLast();
            List<CaThe> cacCaTheCon = new ArrayList<>(chonLocVaLaiGhep.laiGhep(cha, me));
            List<CaThe> cacCaTheConSauKhiDotBien = new ArrayList<>(dotBien.dotBien(cacCaTheCon));

            quanTheMoi.getQuanThe().addAll(cacCaTheConSauKhiDotBien);
//            cacCaTheCon.clear();
//            cacCaTheConSauKhiDotBien.clear();
            CaThe caTheNgauNhien = taoCaThe.taoCaThe(Data.taoDanhSachLop());
            quanTheMoi.getQuanThe().add(caTheNgauNhien);

            quanTheHienTai.getQuanThe().clear();
            System.out.println("kich thuoc quan the hien tai sau khi remove " + quanTheHienTai.getQuanThe().size());
            quanTheHienTai.getQuanThe().addAll(quanTheMoi.getQuanThe());
            caTheChaMe.clear();

            System.out.println("quan the moi la " );
            taoQuanThe.printQuanThe(quanTheMoi);

            soTheHe++;
        }
        System.out.println("quan the tot nhat tim duoc la ");
        return timCaTheTotNhatTrongQuanTheCuoiCungNeuKhongTimDuoc(quanTheHienTai);
    }

    private CaThe timCaTheTotNhatTrongQuanTheCuoiCungNeuKhongTimDuoc(QuanThe quanThe) {
        danhGia.danhGiaCacCaTheTrongQuanThe(quanThe);
        caTheTimDuoc = quanThe.getQuanThe().getFirst();
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
            System.out.println("da het");
        }
    }
}
