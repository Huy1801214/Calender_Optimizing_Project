package controller;

import data.Data;
import model.*;

import java.util.List;

//- Gen: TKB 1 lớp
//- Cá thể: TKB cả trường(5 lớp)
//- Quần thể: Tập hợp nhiều cá thể
//- Yêu cầu về TKB:
//        + 1 ngày 1 môn
//   + 5 ngày dạy trong tuần
//   + 1 môn 2 người dạy
//   + 5 lớp
//- B1: Random ra nhiều TKB cả trường(cá thể)
//- B2: Đánh giá các TKB cả trường(cá thể)
//- B3: Chọn lọc và lai ghép các TKB cả trường với nhau
//- B4: Đột biến: 2 đột biến(khi giáo viên phải dạy 2 lớp trong cùng 1 tiết)
//	+ Đổi môn học
//	+ Đổi giáo viên
/*
yêu cầu: không có xung đột 100đ
    ràng buộc cứng :
        x1: giáo viên chỉ được dạy 1 lớp trong cùng 1 tiết của cùng 1 ngày
        (kiểm tra xem giáo viên có dạy nhiều hơn 1 lớp trong tiết đó không) nếu xung đột -20đ
        x2: mỗi giáo vien chỉ dạy đủ số lượng tiet học trong 1 tuần xung đột -20đ
    ràng buộc mềm :
        x3: ưu tiên các tiết học liên tiếp của cùng một môn +10đ

 */
public class DanhGia {
    final int diemBanDau = 1000;
    final int diemPhat = -20;

    public void danhGiaCacCaTheTrongQuanThe(QuanThe quanThe) {
        for (CaThe caThe : quanThe.getQuanThe()) {
            int fitnessScore = tinhFitnessScore(caThe);
            caThe.setFitnessScore(fitnessScore);
        }
    }
    public int tinhFitnessScore(CaThe caThe) {
        int score = diemBanDau;

        // 1. Kiểm tra ràng buộc cứng: Giáo viên dạy nhiều lớp cùng lúc
        score += kiemTraXungDotGiaoVien(caThe);

        // 2. Kiểm tra ràng buộc cứng: Giáo viên dạy vượt quá số tiết tối đa
        score += kiemTraSoTietGiaoVien(caThe);

        // 4. Tính điểm thưởng cho các tiết học liên tiếp cùng một môn
//        score += tinhDiemUuTienTietLienTiep(caThe);
        return score;
    }

    // 1. Kiểm tra ràng buộc cứng: Giáo viên dạy nhiều lớp cùng lúc
    private int kiemTraXungDotGiaoVien(CaThe caThe) {
        int xungDot = 0;
        List<Gene> dsGene = caThe.getGenes();
        for (int genPre = 0; genPre < dsGene.size(); genPre++) {
            for (int genNext = genPre + 1; genNext < dsGene.size(); genNext++) {
//                dsGene.get(genPre).printTKB();
//                dsGene.get(genNext).printTKB();
                for (int ngay = 0; ngay < dsGene.get(1).getSoNgayTrongTuan(); ngay++) {
                    for (int tiet = 0; tiet < dsGene.get(1).getSoTietHocTrongNgay(); tiet++) {
                        if (dsGene.get(genPre).getNgayHoc(ngay, tiet).getGiaoVien()
                                == dsGene.get(genNext).getNgayHoc(ngay, tiet).getGiaoVien()) {
                            xungDot += diemPhat;
//                            System.out.println("-------------------------------");
//                            System.out.println(dsGene.get(genPre).getNgayHoc(ngay, tiet).toString());
//                            System.out.println(dsGene.get(genNext).getNgayHoc(ngay, tiet).toString());
//                            System.out.println("Xung dot: " + xungDot);
                        }
                    }
                }
//                System.out.println("------------------------------------");
            }
        }
//        System.out.println("Rang buoc 1: " + xungDot);
        return xungDot;
    }

    // 2. Kiểm tra ràng buộc cứng: Giáo viên dạy vượt quá số tiết tối đa
    private int kiemTraSoTietGiaoVien(CaThe caThe) {
        int xungDot = 0;
        int soTietThucTe = 0;
        List<GiaoVien> dsGiaoVien = Data.taoDanhSachGiaoVien();
        List<Gene> dsGene = caThe.getGenes();
        for (GiaoVien gv : dsGiaoVien) {
            int soTietDayToiDaTrongTuan = gv.getSoTietDayToiDaTrongTuan();
//            System.out.println(gv.toString());
//            System.out.println("So tiet day toi da: " + soTietDayToiDaTrongTuan);
            for (Gene g : dsGene) {
//                g.printTKB();
                for (int ngay = 0; ngay < g.getSoNgayTrongTuan(); ngay++) {
                    for (int tiet = 0; tiet < g.getSoTietHocTrongNgay(); tiet++) {
                        if (g.getNgayHoc(ngay, tiet).getGiaoVien() == gv) {
                            soTietThucTe++;
//                            System.out.println("-----------------------");
//                            System.out.println(g.getNgayHoc(ngay, tiet).toString());
//                            System.out.println("So tiet thuc te: " + soTietThucTe);
                        }
                    }
                }
            }
            xungDot += (soTietThucTe != soTietDayToiDaTrongTuan) ? diemPhat : 0;
            soTietThucTe = 0;
//            System.out.println("Xung dot: " + xungDot);
        }
//        System.out.println("Rang buoc 2: " + xungDot);
        return xungDot;
    }

    public static void main(String[] args) {
        List<Lop> dsLop = Data.taoDanhSachLop();
        TaoCaThe taoCaThe = new TaoCaThe();
        CaThe caThe = taoCaThe.taoCaThe(dsLop);
        DanhGia danhGia = new DanhGia();
        System.out.println(danhGia.tinhFitnessScore(caThe));
    }


//    /**
//     * 4.Tính điểm thưởng cho các tiết học liên tiếp cùng một môn.
//     */
//    private int tinhDiemUuTienTietLienTiep(ThoiKhoaBieu tkb) {
//        int bonus = 0;
//
//        for (int ngay = 0; ngay < tkb.getSoNgayTrongTuan(); ngay++) {
//            String monTruoc = null;
//
//            for (int tiet = 0; tiet < tkb.getSoTietHocTrongNgay(); tiet++) {
//                TietHoc tietHoc = tkb.getTietHoc(ngay, tiet);
//
//                if (tietHoc != null) {
//                    String monHienTai = tietHoc.getMonHoc().getTenMon();
//                    if (monHienTai.equals(monTruoc)) {
//                        bonus += diemThuongTietLienTiep; // Cộng điểm nếu môn học liên tiếp
//                    }
//                    monTruoc = monHienTai;
//                } else {
//                    monTruoc = null;
//                }
//            }
//        }
//        return bonus;
//    }
}
