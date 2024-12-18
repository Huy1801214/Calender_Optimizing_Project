package model;

import java.util.List;

/*
Quan The la tap hop nhieu ca the
 */
public class QuanThe {
    List<CaThe> quanThe;
    int kichThuocQuanThe;

    public QuanThe(List<CaThe> quanThe, int kichThuocQuanThe) {
        this.quanThe = quanThe;
        this.kichThuocQuanThe = kichThuocQuanThe;
    }

    public List<CaThe> getQuanThe() {
        return quanThe;
    }

    public void setQuanThe(List<CaThe> quanThe) {
        this.quanThe = quanThe;
    }

    public int getKichThuocQuanThe() {
        return kichThuocQuanThe;
    }

    public void setKichThuocQuanThe(int kichThuocQuanThe) {
        this.kichThuocQuanThe = kichThuocQuanThe;
    }

    public void printQuanThe() {
        for (int i = 0; i < quanThe.size(); i++) {
            for (CaThe caThe : quanThe) {
                System.out.println("ca the thu " + (i + 1));
                caThe.printCaThe();
                System.out.println();
            }
        }
    }
}
