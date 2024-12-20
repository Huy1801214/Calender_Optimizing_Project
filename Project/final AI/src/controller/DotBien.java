package controller;

import data.Data;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//- B4: Đột biến: 2 đột biến(khi giáo viên phải dạy 2 lớp trong cùng 1 tiết)
//	+ Đổi môn học
//	+ Đổi giáo viên
public class DotBien {
    int tiLeDotBien = 50;

    public List<CaThe> dotBien(List<CaThe> dsCaThe) {
        List<CaThe> dsCaTheMoi = new ArrayList<>();
        CaThe caThe = null;
        Random rand = new Random();
        int tiLeNgauNhien = rand.nextInt(101);
        //System.out.println("Ti le ngau nhien: " + tiLeNgauNhien);
        if (tiLeNgauNhien > tiLeDotBien) {
            int viTriCaTheNgauNhien = rand.nextInt(dsCaThe.size());
            //System.out.println("Vi tri ca the ngau nhien: " + viTriCaTheNgauNhien);
            if (viTriCaTheNgauNhien == 0) {
                dsCaTheMoi.add(dsCaThe.get(1));
            } else {
                dsCaTheMoi.add(dsCaThe.get(0));
            }
            caThe = dsCaThe.get(viTriCaTheNgauNhien);

            List<Gene> dsGene = caThe.getGenes();
            for (int genPre = 0; genPre < dsGene.size(); genPre++) {
                for (int genNext = genPre + 1; genNext < rand.nextInt(2, dsGene.size()); genNext++) {
//                    dsGene.get(genPre).printTKB();
//                    dsGene.get(genNext).printTKB();
                    for (int ngay = 0; ngay < dsGene.get(1).getSoNgayTrongTuan(); ngay++) {
                        for (int tiet = 0; tiet < dsGene.get(1).getSoTietHocTrongNgay(); tiet++) {
                            NgayHoc ngayHocGenPre = dsGene.get(genPre).getNgayHoc(ngay, tiet);
                            NgayHoc ngayHocGenNext = dsGene.get(genNext).getNgayHoc(ngay, tiet);
                            if (ngayHocGenPre.getGiaoVien()
                                    == ngayHocGenNext.getGiaoVien()) {
                                List<GiaoVien> dsGiaoViens = Data.taoDanhSachGiaoVien();
                                for (GiaoVien gv : dsGiaoViens) {
                                    if (ngayHocGenPre.getGiaoVien() != gv) {
                                        ngayHocGenPre.setGiaoVien(gv);
                                        ngayHocGenPre.setMonHoc(gv.getDsMonHocGVDay().getFirst());
                                    }
                                }
//                                System.out.println("-------------------------------");
//                                System.out.println(ngayHocGenPre.toString());
//                                System.out.println(ngayHocGenNext.toString());
                            }
                        }
                    }
//                    System.out.println("------------------------------------");
                }
            }
            dsCaTheMoi.add(caThe);
        }
//        System.out.println("So luong ca the moi: " + dsCaTheMoi.size());
        if (dsCaTheMoi.size() == 2) {
//            dsCaTheMoi.get(0).printCaThe();
//            dsCaTheMoi.get(1).printCaThe();
            return dsCaTheMoi;
        }
        return dsCaThe;
    }

    public static void main(String[] args) {
        List<Lop> dsLop = Data.taoDanhSachLop();
        TaoCaThe taoCaThe = new TaoCaThe();
        CaThe caThe1 = taoCaThe.taoCaThe(dsLop);
        CaThe caThe2 = taoCaThe.taoCaThe(dsLop);
        List<CaThe> dsCaThe = new ArrayList<>();
        dsCaThe.add(caThe1);
        dsCaThe.add(caThe2);
        dsCaThe.get(0).printCaThe();
        dsCaThe.get(1).printCaThe();

        DotBien dotBien = new DotBien();
        List<CaThe> dsCaTheMoi = new ArrayList<>();
        dsCaTheMoi.addAll(dotBien.dotBien(dsCaThe));
        dsCaTheMoi.get(0).printCaThe();
        dsCaTheMoi.get(1).printCaThe();
    }
}
