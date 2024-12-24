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

    public TaoGene() {
    }

    public Gene taoTKBChoMoiLop(Lop lop) {
        gene = new Gene(lop);
        dsGiaoVien = Data.taoDanhSachGiaoVien();
        dsMonHoc = Data.taoDanhSachMonHoc();
        boolean[][] daXuatHienMonHoc = new boolean[gene.getSoNgayTrongTuan()][gene.getSoTietHocTrongNgay()];

        int ngay = 0;
        int soTiet = 0;
        for (MonHoc monHoc : dsMonHoc) {
            while (daXuatHienMonHoc[ngay][soTiet]) {
                ngay = rand.nextInt(gene.getSoNgayTrongTuan());
                soTiet = rand.nextInt(gene.getSoTietHocTrongNgay());
            }
            daXuatHienMonHoc[ngay][soTiet] = true;

            GiaoVien giaoVien = chonGiaoVienThichHop(monHoc);
            NgayHoc ngayHoc = new NgayHoc(ngay, monHoc, lop, giaoVien);
            gene.setNgayHoc(ngay, soTiet, ngayHoc);
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
        return dsGiaoVienThichHopChoMonHoc.get(rand.nextInt(dsGiaoVienThichHopChoMonHoc.size()));
    }

    public static void main(String[] args) {
        TaoGene taoGene = new TaoGene();
        Lop lop = Data.taoDanhSachLop().get(0);
        Gene t = taoGene.taoTKBChoMoiLop(lop);
        t.printTKB();
    }
}
