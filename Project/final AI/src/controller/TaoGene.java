package controller;

import data.Data;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaoGene {
    Random rand = new Random();
    Gene gene;
    List<MonHoc> dsMonHoc;
    List<GiaoVien> dsGiaoVien;
    Data data;

    public TaoGene() {
    }

    public Gene taoTKBChoMoiLop(Lop lop) {
        gene = new Gene(lop);
        dsGiaoVien = data.taoDanhSachGiaoVien();
        dsMonHoc = data.taoDanhSachMonHoc();
        boolean[][] daXuatHienMonHoc = new boolean[gene.getSoNgayTrongTuan()][gene.getSoTietHocTrongNgay()];

        int thu = 1;
        int soTiet = 0;
        for (MonHoc monHoc : dsMonHoc) {
            while (daXuatHienMonHoc[thu][soTiet]) {
                thu = rand.nextInt(gene.getSoNgayTrongTuan());
                soTiet = rand.nextInt(gene.getSoTietHocTrongNgay());
            }
            daXuatHienMonHoc[thu][soTiet] = true;

            GiaoVien giaoVien = chonGiaoVienThichHop(monHoc);
            NgayHoc ngayHoc = new NgayHoc(thu, monHoc, lop, giaoVien);
            gene.setNgayHoc(thu, soTiet, ngayHoc);
        }
        return gene;
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
        TaoGene taoGene = new TaoGene();
        Lop lop = Data.taoDanhSachLop().get(0);
        Gene t = taoGene.taoTKBChoMoiLop(lop);
        t.printTKB();
    }
}
