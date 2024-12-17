package controller;

import Data.Data;
import model.*;

import java.util.*;

/*
yêu cầu: không có xung đột 100đ
    ràng buộc cứng :
        x1: giáo viên chỉ được dạy 1 lớp trong cùng 1 tiết của cùng 1 ngày
        (kiểm tra xem giáo viên có dạy nhiều hơn 1 lớp trong tiết đó không) nếu xung đột -20đ
        x2: mỗi lớp không được học 2 môn trong 1 tiết xung đột -20đ
        x3: mỗi lớp phải có đủ số tiết học theo quy định xung đột -20đ
        x4: mỗi giáo vien chỉ dạy đủ số lượng tiet học trong 1 tuần xung đột -20đ
    ràng buộc mềm :
        ưu tiên các tiết học liên tiếp của cùng một môn +10đ

 */
public class DanhGia {
    final int diemBanDau = 100;
    final int x1 = -20;
    final int x2 = -20;
    final int x3 = -20;
    final int x4 = -20;

    public void danhGiaCacTKBTrongQuanThe(QuanThe quanThe) {
        for(ThoiKhoaBieu tkb : quanThe.getQuanThe()) {
            int fitnessScore = tinhFitnessScore(tkb);
            tkb.setSoDiemFitness(fitnessScore);
        }
    }

    public int tinhFitnessScore(ThoiKhoaBieu tkb) {
        int score = diemBanDau; // Điểm khởi đầu (100 điểm)

        TaoTKB taoTKB = new TaoTKB();
        List<Lop> dsLop = Data.taoDanhSachLop();
        List<ThoiKhoaBieu> dsTKB = taoTKB.taoTKBChoNhieuLop(dsLop);

        // 1. Kiểm tra ràng buộc cứng: Giáo viên dạy nhiều lớp cùng lúc
        score += kiemTraXungDotGiaoVien(tkb, dsTKB);

//        // 2. Kiểm tra ràng buộc cứng: Lớp học nhiều hơn 1 môn trong cùng một tiết
//        score += kiemTraXungDotLop(tkb);
//
//        // 3. Kiểm tra ràng buộc cứng: Số tiết học của lớp có đủ theo quy định không
//        score += kiemTraSoTietLop(tkb);
//
//        // 4. Kiểm tra ràng buộc cứng: Giáo viên dạy vượt quá số tiết tối đa
//        score += kiemTraSoTietGiaoVien(tkb);
//
//        // 5. Tính điểm thưởng cho các tiết học liên tiếp cùng một môn
//        score += tinhDiemUuTienTietLienTiep(tkb);

        return score; // Trả về tổng điểm fitness
    }

    private int kiemTraXungDotGiaoVien(ThoiKhoaBieu tkb, List<ThoiKhoaBieu> dsTKB) {
        int xungDot = 0;
        for (ThoiKhoaBieu tkbKhac : dsTKB) {
            if (!tkb.getLop().equals(tkbKhac.getLop())) {
                for (int ngay = 0; ngay < tkb.getSoNgayTrongTuan(); ngay++) {
                    for (int tiet = 0; tiet < tkb.getSoTietHocTrongNgay(); tiet++) {
                        TietHoc tietHocTKBKhac = tkbKhac.getTietHoc(ngay, tiet);
                        TietHoc tietHocTKB = tkb.getTietHoc(ngay, tiet);



                        if (tietHocTKBKhac.getGiaoVien() == tietHocTKB.getGiaoVien()){
                            tkb.printTKB();
                            tkbKhac.printTKB();
                            xungDot += x1;
                        }
                    }
                }
            }

        }
        return xungDot;
    }

    public static void main(String[] args) {
        DanhGia danhGia = new DanhGia();
        TaoTKB taoTKB = new TaoTKB();
        Lop lop = Data.taoDanhSachLop().get(1);
        ThoiKhoaBieu tkb = taoTKB.taoTKBChoMoiLop(lop);
        System.out.println(danhGia.tinhFitnessScore(tkb));

    }

//
//
//    /**
//     * 2. Kiểm tra lớp học có học 2 môn trong cùng một tiết không.
//     */
//    private int kiemTraXungDotLop(ThoiKhoaBieu tkb) {
//        int penalty = 0;
//
//        for (int ngay = 0; ngay < tkb.getSoNgayTrongTuan(); ngay++) {
//            for (int tiet = 0; tiet < tkb.getSoTietHocTrongNgay(); tiet++) {
//                TietHoc tietHoc = tkb.getTietHoc(ngay, tiet);
//
//                if (tietHoc != null) {
//                    String key = ngay + "-" + tiet; // Key: ngày-tiết
//                    Set<String> monHocSet = new HashSet<>();
//
//                    if (!monHocSet.add(tietHoc.getMonHoc().getTenMon())) {
//                        penalty += x2; // Trừ điểm nếu lớp học nhiều hơn 1 môn cùng tiết
//                    }
//                }
//            }
//        }
//        return penalty;
//    }
//
//
//    /**
//     * 3. Kiểm tra số tiết học của lớp có đủ theo quy định không.
//     */
//    private int kiemTraSoTietLop(ThoiKhoaBieu tkb) {
//        int soTietThucTe = 0;
//
//        for (int ngay = 0; ngay < tkb.getSoNgayTrongTuan(); ngay++) {
//            for (int tiet = 0; tiet < tkb.getSoTietHocTrongNgay(); tiet++) {
//                if (tkb.getTietHoc(ngay, tiet) != null) {
//                    soTietThucTe++;
//                }
//            }
//        }
//
//        int soTietQuyDinh = tkb.getLop().getSoTietHocTuan();
//        return (soTietThucTe < soTietQuyDinh) ? x3 : 0; // Trừ điểm nếu không đủ tiết
//    }
//
//
//    /**
//     * 4.Kiểm tra số tiết dạy của giáo viên có vượt quá giới hạn không.
//     */
//    private int kiemTraSoTietGiaoVien(ThoiKhoaBieu tkb, List<ThoiKhoaBieu> dsTKB) {
//        int penalty = 0;
//        Map<String, Integer> soTietGV = new HashMap<>();
//
//        // Tính tổng số tiết dạy cho từng giáo viên
//        for (ThoiKhoaBieu otherTKB : dsTKB) {
//            for (int ngay = 0; ngay < otherTKB.getSoNgayTrongTuan(); ngay++) {
//                for (int tiet = 0; tiet < otherTKB.getSoTietHocTrongNgay(); tiet++) {
//                    TietHoc tietHoc = otherTKB.getTietHoc(ngay, tiet);
//                    if (tietHoc != null) {
//                        String giaoVien = tietHoc.getGiaoVien().getTenGV();
//                        soTietGV.put(giaoVien, soTietGV.getOrDefault(giaoVien, 0) + 1);
//                    }
//                }
//            }
//        }
//
//        for (String giaoVien : soTietGV.keySet()) {
//            int soTietToiDa = 18; // Giả sử số tiết tối đa là 18
//            if (soTietGV.get(giaoVien) > soTietToiDa) {
//                penalty += x4;
//            }
//        }
//        return penalty;
//    }
//
//
//    /**
//     * 5.Tính điểm thưởng cho các tiết học liên tiếp cùng một môn.
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
