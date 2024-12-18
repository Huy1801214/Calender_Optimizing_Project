package model;

/*
1 gene la 1 tkb cua 1 lop
 */
public class Gene {
    Lop lop;
    NgayHoc[][] tkb;
    int soNgayTrongTuan;
    int soTietHocTrongNgay;
    int soDiemFitness;

    final int soNgayHocTrongTuan = 5;
    final int sotietHocTrongNgay = 1;

    public Gene(Lop lop) {
        this.lop = lop;
        this.soNgayTrongTuan = soNgayHocTrongTuan;
        this.soTietHocTrongNgay = sotietHocTrongNgay;
        this.tkb = new NgayHoc[soNgayTrongTuan][soTietHocTrongNgay];
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

    public NgayHoc[][] getTkb() {
        return tkb;
    }

    public void setTkb(NgayHoc[][] tkb) {
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
    public void setNgayHoc(int ngay, int tiet, NgayHoc ngayHoc) {
        if (ngay >= 0 && ngay < soNgayTrongTuan && tiet >= 0 && tiet < soTietHocTrongNgay) {
            tkb[ngay][tiet] = ngayHoc;
        }
    }



    // Thêm phương thức để lấy tiết học từ thời khóa biểu
    public NgayHoc getNgayHoc(int ngay, int tiet) {
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
                    //ThoiKhoaBieu thoiKhoaBieu = new ThoiKhoaBieu(lop);
                    System.out.println(tkb[i][j].toString() + " ");
                    //System.out.println(thoiKhoaBieu.getSoDiemFitness());
                } else {
                    System.out.println("--------");
                }
            }
        }
    }
}
