package controller;

import model.QuanThe;
import model.ThoiKhoaBieu;

/*
yêu cầu: không có xung đột 100đ
    ràng buộc cứng :
        x1: giáo viên chỉ được dạy 1 lớp trong 1 tiết nếu xung đột -20đ
        x2: mỗi lớp không được học 2 môn trong 1 tiết xung đột -20đ
        x3: mỗi lớp phải có đủ số tiet học theo quy định xung đột -20đ
        x4: mỗi giáo vien chỉ dạy đủ số luong tiet học trong 1 tuần xung đột -20đ
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
        int score = diemBanDau;

        return score;
    }
}
