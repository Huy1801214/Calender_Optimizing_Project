package controller;

import data.Data;
import model.CaThe;
import model.QuanThe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
b1 đánh giá chọn ra 2 cá the cha mẹ
b2 lai ghep
b3 đột bien
b4 danh gia lại sau đó lay 5 cá thể tốt nhất
b5 tạo quần thể mới
 */
public class ChonLocVaLaiGhep {
    QuanThe quanThe;
    TaoCaThe taoCaThe;
    Random rand;
    DanhGia danhGia;
    double tileDotBien = 0.05;

    public ChonLocVaLaiGhep() {
        rand = new Random();
        danhGia = new DanhGia();
        taoCaThe = new TaoCaThe();
    }

    public List<CaThe> chonLocCaTheChaMe(QuanThe quanTheHienTai) {
        List<CaThe> cacCaTheChaMe = new ArrayList<>();
        danhGia.danhGiaCacCaTheTrongQuanThe(quanTheHienTai);

        CaThe caTheCha = null;
        CaThe caTheMe = null;

        for (int i = 0; i < quanTheHienTai.getKichThuocQuanThe(); i++) {
            CaThe caThe = quanTheHienTai.getQuanThe().get(i);
            System.out.println("ca the thu " + i + " trong chon loc va lai ghep la");
            if (caTheCha == null || caTheCha.getFitnessScore() < caThe.getFitnessScore()) {
                /*

                 0 0
                 c1 m1

                 c2 m1

                 */
                caTheMe = caTheCha;
                caTheCha = caThe;
            } else if (caTheMe == null || caTheMe.getFitnessScore() < caThe.getFitnessScore()) {
                caTheMe = caThe;
            }


//            } else {
//                System.err.println("Cha hoac me null");
//            }
        }
        cacCaTheChaMe.add(caTheCha);
        cacCaTheChaMe.add(caTheMe);
        return cacCaTheChaMe;
    }

    public List<CaThe> laiGhep(CaThe cha, CaThe me) {
        List<CaThe> cacCaTheCon = new ArrayList<>();
        int kichThuocCaThe = Data.taoDanhSachLop().size();
        if (kichThuocCaThe > 0) {
            CaThe con1 = new CaThe();
            CaThe con2 = new CaThe();

            int diemGiao = rand.nextInt(kichThuocCaThe);
            for (int i = 0; i < kichThuocCaThe; i++) {
                if (i < diemGiao) {
                    con1.getGenes().add(cha.getGenes().get(i));
                    con2.getGenes().add(me.getGenes().get(i));
                } else {
                    con2.getGenes().add(cha.getGenes().get(i));
                    con1.getGenes().add(me.getGenes().get(i));
                }
            }
            cacCaTheCon.add(con1);
            cacCaTheCon.add(con2);
        } else {
            System.out.println("Kích thước cá thể không hợp lệ: " + kichThuocCaThe);
        }
        return cacCaTheCon;
    }

    public static void main(String[] args) {
        TaoQuanThe taoQuanThe = new TaoQuanThe();
        CaThe caTheTimDuoc = new CaThe();
        QuanThe qt = taoQuanThe.taoQuanThe(Data.taoDanhSachLop());
        System.out.println("Quan the ban dau la ");
        taoQuanThe.printQuanThe(qt);
        System.out.println("--------------------------------------");

        for (int i = 0; i < 10; i++) {
            DanhGia danhGia = new DanhGia();
            danhGia.danhGiaCacCaTheTrongQuanThe(qt);

            for (CaThe caThe : qt.getQuanThe()) {
                // neu tim duoc cá thể tốt thì dừng luôn
                if (caThe.getFitnessScore() >= 800) {
                    caTheTimDuoc = caThe;
                    break;
                }
            }
            ChonLocVaLaiGhep chonLocVaLaiGhep = new ChonLocVaLaiGhep();
            List<CaThe> chaMe = chonLocVaLaiGhep.chonLocCaTheChaMe(qt);
//        for (CaThe caThe : chaMe) {
//            caThe.printCaThe();
//        }
            System.out.println("--------------");
            System.out.println("Quan the moi la : ");

            System.out.println("quan the sau khi swap");
            taoQuanThe.printQuanThe(qt);
        }

        //  taoQuanThe.printQuanThe(qt);
//        CaThe cha = chonLocVaLaiGhep.chonLocCaTheChaMe(qt);
//        System.out.println("Cha hoac me la : ");
//        cha.printCaThe();
    }
}
