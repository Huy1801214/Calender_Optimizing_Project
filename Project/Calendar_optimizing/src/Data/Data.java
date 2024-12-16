package Data;

import model.GiaoVien;
import model.Lop;
import model.MonHoc;

import java.util.ArrayList;
import java.util.List;

public class Data {
    static MonHoc toan = new MonHoc("TOAN12", "Toán 12", 6);
    static MonHoc van = new MonHoc("VAN12", "Văn 12", 6);
    static MonHoc anh = new MonHoc("ANH12", "Anh 12", 6);
    static MonHoc ly = new MonHoc("LY12", "Vật lý 12", 2);
    static MonHoc hoa = new MonHoc("HOA12", "Hóa học 12", 2);
    static MonHoc sinh = new MonHoc("SINH12", "Sinh 12", 2);
    static MonHoc su = new MonHoc("SU12", "Su 12", 2);
    static MonHoc dia = new MonHoc("DIA12", "Địa Lý 12", 2);
    static MonHoc gdcd = new MonHoc("GDCD12", "Giáo dục công dân 12", 2);
    static MonHoc tinHoc = new MonHoc("TIN12", "Tin học 12", 2);


    static GiaoVien gv1 = new GiaoVien("GV001", "Nguyễn Văn A", List.of(toan,ly), 12);
    static GiaoVien gv2 = new GiaoVien("GV004", "Lê Thị D", List.of(van), 10);
    static GiaoVien gv3 = new GiaoVien("GV005", "Lê Thị E", List.of(anh), 12);
    static GiaoVien gv4 = new GiaoVien("GV002", "Nguyễn Văn A", List.of(sinh), 12);
    static GiaoVien gv5 = new GiaoVien("GV003", "Nguyễn Văn B", List.of(hoa), 12);
    static GiaoVien gv6 = new GiaoVien("GV006", "Nguyễn Văn C", List.of(su), 12);
    static GiaoVien gv7 = new GiaoVien("GV007", "Nguyễn Văn D", List.of(dia), 12);
    static GiaoVien gv8 = new GiaoVien("GV008", "Nguyễn Văn E", List.of(gdcd), 12);
    static GiaoVien gv9 = new GiaoVien("GV009", "Nguyễn Văn F", List.of(tinHoc), 12);
    static GiaoVien gv10 = new GiaoVien("GV010", "Nguyễn Văn G", List.of(van), 12);
    static GiaoVien gv11 = new GiaoVien("GV011", "Nguyễn Văn H", List.of(toan), 12);
    static GiaoVien gv12 = new GiaoVien("GV012", "Nguyễn Văn DS", List.of(anh), 12);
    static GiaoVien gv13 = new GiaoVien("GV013", "Nguyễn Văn K", List.of(anh, toan), 12);
    static GiaoVien gv14 = new GiaoVien("GV014", "Nguyễn Văn YU", List.of(hoa, sinh), 12);
    static GiaoVien gv15 = new GiaoVien("GV015", "Nguyễn Văn RE", List.of(van, toan), 12);

    static Lop l1 = new Lop("12A1", "12A1");
    static Lop l2 = new Lop("12A2", "12A2");
    static Lop l3 = new Lop("12A3", "12A3");

    public static List<MonHoc> taoDanhSachMonHoc() {
        List<MonHoc> DanhSachMonHoc = new ArrayList<>();
        DanhSachMonHoc.add(toan);
        DanhSachMonHoc.add(van);
        DanhSachMonHoc.add(anh);
        DanhSachMonHoc.add(ly);
        DanhSachMonHoc.add(hoa);
        DanhSachMonHoc.add(sinh);
        DanhSachMonHoc.add(su);
        DanhSachMonHoc.add(dia);
        DanhSachMonHoc.add(gdcd);
        DanhSachMonHoc.add(tinHoc);
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
        DanhSachGiaoVien.add(gv11);
        DanhSachGiaoVien.add(gv12);
        DanhSachGiaoVien.add(gv13);
        DanhSachGiaoVien.add(gv14);
        DanhSachGiaoVien.add(gv15);
        return DanhSachGiaoVien;
    }

    public static List<Lop> taoDanhSachLop() {
        List<Lop> danhSachLop = new ArrayList<>();
        danhSachLop.add(l1);
        danhSachLop.add(l2);
        danhSachLop.add(l3);
        return danhSachLop;
    }
}
