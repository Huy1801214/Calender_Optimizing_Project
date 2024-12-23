package controller;

import data.Data;
import model.CaThe;
import model.Gene;
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
    TaoCaThe taoCaThe;
    Random rand;
    DanhGia danhGia;

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
            if (checkTrungLap(cha)) {
                laiGhepNeuTrung(cha, me, kichThuocCaThe, con1, con2, cha.getGenes(), me.getGenes());
            } else if (checkTrungLap(me)) {
                laiGhepNeuTrung(me, cha, kichThuocCaThe, con1, con2, cha.getGenes(), me.getGenes());
            } else {
                int diemGiaoNeuKhongTrung = rand.nextInt(kichThuocCaThe);
                for (int i = 0; i < kichThuocCaThe; i++) {
                    if (i < diemGiaoNeuKhongTrung) {
                        con1.getGenes().add(cha.getGenes().get(i));
                        con2.getGenes().add(me.getGenes().get(i));
                    } else {
                        con2.getGenes().add(cha.getGenes().get(i));
                        con1.getGenes().add(me.getGenes().get(i));
                    }
                }
            }
            cacCaTheCon.add(con1);
            cacCaTheCon.add(con2);
        } else {
            System.out.println("Kích thước cá thể không hợp lệ: " + kichThuocCaThe);
        }
        return cacCaTheCon;
    }

    private void laiGhepNeuTrung(CaThe cha, CaThe me, int kichThuocCaThe, CaThe con1, CaThe con2, List<Gene> genes, List<Gene> genes2) {
        int diemTrungCha = geneTrungLap(cha);
        int diemGiaoBatKyCuaCaTheMe = rand.nextInt(kichThuocCaThe);
        Gene geneTrungCuaMe = me.getGenes().get(diemGiaoBatKyCuaCaTheMe);
        for (Gene gene : genes) {
            con1.getGenes().add(gene);
        }
        con1.getGenes().set(diemTrungCha, geneTrungCuaMe);

        Gene geneTrungCuaCha = cha.getGenes().get(diemTrungCha);
        for (Gene gene : genes2) {
            con2.getGenes().add(gene);
        }
        con2.getGenes().set(diemGiaoBatKyCuaCaTheMe, geneTrungCuaCha);
    }

    private boolean checkTrungLap(CaThe caThe) {
        List<Gene> dsGene = caThe.getGenes();
        for (int genPre = 0; genPre < dsGene.size(); genPre++) {
            for (int genNext = genPre + 1; genNext < dsGene.size(); genNext++) {
                for (int ngay = 0; ngay < dsGene.get(1).getSoNgayTrongTuan(); ngay++) {
                    for (int tiet = 0; tiet < dsGene.get(1).getSoTietHocTrongNgay(); tiet++) {
                        if (dsGene.get(genPre).getNgayHoc(ngay, tiet).getGiaoVien() == dsGene.get(genNext).getNgayHoc(ngay, tiet).getGiaoVien()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private int geneTrungLap(CaThe caThe) {
        List<Gene> dsGene = caThe.getGenes();
        int viTri = 0;
        for (int genPre = 0; genPre < dsGene.size(); genPre++) {
            for (int genNext = genPre + 1; genNext < dsGene.size(); genNext++) {
                for (int ngay = 0; ngay < dsGene.get(1).getSoNgayTrongTuan(); ngay++) {
                    for (int tiet = 0; tiet < dsGene.get(1).getSoTietHocTrongNgay(); tiet++) {
                        if (dsGene.get(genPre).getNgayHoc(ngay, tiet).getGiaoVien() == dsGene.get(genNext).getNgayHoc(ngay, tiet).getGiaoVien()) {
                            viTri = genPre;
                        }
                    }
                }
            }
        }
        return viTri;
    }

    public static void main(String[] args) {
        TaoQuanThe taoQuanThe = new TaoQuanThe();
        CaThe caTheTimDuoc = new CaThe();
        QuanThe qt = taoQuanThe.taoQuanThe(Data.taoDanhSachLop());
        System.out.println("Quan the ban dau la ");
        taoQuanThe.printQuanThe(qt);
        System.out.println("--------------------------------------");

        ChonLocVaLaiGhep chonLocVaLaiGhep = new ChonLocVaLaiGhep();
        List<CaThe> caTheChaMe = chonLocVaLaiGhep.chonLocCaTheChaMe(qt);
        for(CaThe chaMe : caTheChaMe) {
            System.out.println("ca the cha hoac me la ");
            chaMe.printCaThe();
        }
        List<CaThe> cacCaTheCon = chonLocVaLaiGhep.laiGhep(caTheChaMe.getFirst(), caTheChaMe.getLast());
        for(CaThe con1 : cacCaTheCon) {
            System.out.println("cac ca the con la ");
            con1.printCaThe();
        }
    }
}
