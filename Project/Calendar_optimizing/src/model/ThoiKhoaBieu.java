package model;

public class ThoiKhoaBieu {
    Lop lop;
    TietHoc[][] tkb;
    int soNgayTrongTuan;
    int soTietHocTrongNgay;
    int soDiemFitness;

    public ThoiKhoaBieu(Lop lop) {
        this.lop = lop;
        this.soNgayTrongTuan = 6;
        this.soTietHocTrongNgay = 7;
        this.tkb = new TietHoc[soNgayTrongTuan][soTietHocTrongNgay];
        this.soDiemFitness = 0;
    }

    public int getSoDiemFitness() {
        return soDiemFitness;
    }

    public void setSoDiemFitness(int soDiemFitness) {
        this.soDiemFitness = soDiemFitness;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    public TietHoc[][] getTkb() {
        return tkb;
    }

    public void setTkb(TietHoc[][] tkb) {
        this.tkb = tkb;
    }

    public int getSoNgayTrongTuan() {
        return soNgayTrongTuan;
    }

    public void setSoNgayTrongTuan(int soNgayTrongTuan) {
        this.soNgayTrongTuan = soNgayTrongTuan;
    }

    public int getSoTietHocTrongNgay() {
        return soTietHocTrongNgay;
    }

    public void setSoTietHocTrongNgay(int soTietHocTrongNgay) {
        this.soTietHocTrongNgay = soTietHocTrongNgay;
    }

    // Thêm phương thức để gán tiết học vào thời khóa biểu
    public void setTietHoc(int ngay, int tiet, TietHoc tietHoc) {
        if (ngay >= 0 && ngay < soNgayTrongTuan && tiet >= 0 && tiet < soTietHocTrongNgay) {
            tkb[ngay][tiet] = tietHoc;
        }
    }

    // Thêm phương thức để lấy tiết học từ thời khóa biểu
    public TietHoc getTietHoc(int ngay, int tiet) {
        if (ngay >= 0 && ngay < soNgayTrongTuan && tiet >= 0 && tiet < soTietHocTrongNgay) {
            return tkb[ngay][tiet];
        }
        return null;
    }

    public void printTKB() {
        System.out.println("TKB cua: " + lop.getTenLop());
        for (int i = 0; i < tkb.length; i++) {
            for (int j = 0; j < tkb[i].length; j++) {
                if (tkb[i][j] != null) {
                    System.out.println(tkb[i][j].toString() + " ");
                } else {
                    System.out.println("--------");
                }
            }
            System.out.println();
        }
    }
}
