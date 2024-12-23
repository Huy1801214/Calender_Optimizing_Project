package data;

import model.GiaoVien;
import model.Lop;
import model.MonHoc;

import java.util.ArrayList;
import java.util.List;

public class Data {
    static MonHoc toan = new MonHoc("TOAN12", "Toán 12", 1);
    static MonHoc van = new MonHoc("VAN12", "Văn 12", 1);
    static MonHoc anh = new MonHoc("ANH12", "Anh 12", 1);
    static MonHoc ly = new MonHoc("LY12", "Vật lý 12", 1);
    static MonHoc hoa = new MonHoc("HOA12", "Hóa học 12", 1);

    static GiaoVien gv1 = new GiaoVien("GV001", "Giao vien A", List.of(toan), 5);
    static GiaoVien gv2 = new GiaoVien("GV002", "Giao vien B", List.of(toan), 5);
    static GiaoVien gv3 = new GiaoVien("GV003", "Giao vien C", List.of(van), 5);
    static GiaoVien gv4 = new GiaoVien("GV004", "Giao vien D", List.of(van), 5);
    static GiaoVien gv5 = new GiaoVien("GV005", "Giao vien E", List.of(anh), 5);
    static GiaoVien gv6 = new GiaoVien("GV006", "Giao vien F", List.of(anh), 5);
    static GiaoVien gv7 = new GiaoVien("GV007", "Giao vien G", List.of(ly), 5);
    static GiaoVien gv8 = new GiaoVien("GV005", "Giao vien H", List.of(ly), 5);
    static GiaoVien gv9 = new GiaoVien("GV005", "Giao vien I", List.of(hoa), 5);
    static GiaoVien gv10 = new GiaoVien("GV005", "Giao vien J", List.of(hoa), 5);
//    static GiaoVien gv11 = new GiaoVien("GV005", "Giao vien K", List.of(hoa), 5);
//    static GiaoVien gv12 = new GiaoVien("GV005", "Giao vien O", List.of(toan), 5);
//    static GiaoVien gv13 = new GiaoVien("GV005", "Giao vien Z", List.of(anh), 5);
//    static GiaoVien gv14 = new GiaoVien("GV005", "Giao vien X", List.of(van), 5);
//    static GiaoVien gv15 = new GiaoVien("GV005", "Giao vien N", List.of(ly), 5);

    static Lop l1 = new Lop("12A1", "12A1");
    static Lop l2 = new Lop("12A2", "12A2");
    static Lop l3 = new Lop("12A3", "12A3");
    static Lop l4 = new Lop("12A4", "12A4");
    static Lop l5 = new Lop("12A5", "12A5");

    public static List<MonHoc> taoDanhSachMonHoc() {
        List<MonHoc> DanhSachMonHoc = new ArrayList<>();
        DanhSachMonHoc.add(toan);
        DanhSachMonHoc.add(van);
        DanhSachMonHoc.add(anh);
        DanhSachMonHoc.add(ly);
        DanhSachMonHoc.add(hoa);
        return DanhSachMonHoc;
    }
    public static List<GiaoVien> taoDanhSachGiaoVien() {
        List<GiaoVien> DanhSachGiaoVien = new ArrayList<>();
        DanhSachGiaoVien.add(gv1);
        DanhSachGiaoVien.add(gv2);
        DanhSachGiaoVien.add(gv3);
        DanhSachGiaoVien.add(gv4);
        DanhSachGiaoVien.add(gv5);
        DanhSachGiaoVien.add(gv6);
        DanhSachGiaoVien.add(gv7);
        DanhSachGiaoVien.add(gv8);
        DanhSachGiaoVien.add(gv9);
        DanhSachGiaoVien.add(gv10);
//        DanhSachGiaoVien.add(gv11);
//        DanhSachGiaoVien.add(gv12);
//        DanhSachGiaoVien.add(gv13);
//        DanhSachGiaoVien.add(gv14);
//        DanhSachGiaoVien.add(gv15);

        return DanhSachGiaoVien;
    }

    public static List<Lop> taoDanhSachLop() {
        List<Lop> danhSachLop = new ArrayList<>();
        danhSachLop.add(l1);
        danhSachLop.add(l2);
        danhSachLop.add(l3);
        danhSachLop.add(l4);
        danhSachLop.add(l5);
        return danhSachLop;
    }
}
