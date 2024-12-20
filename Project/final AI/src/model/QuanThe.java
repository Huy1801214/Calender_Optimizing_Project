package model;

import data.Data;

import java.util.ArrayList;
import java.util.List;

/*
Quan The la tap hop nhieu ca the
 */
public class QuanThe {
    List<CaThe> quanThe;
    int kichThuocQuanThe;

    public QuanThe(List<CaThe> quanThe) {
        this.quanThe = quanThe;
        this.kichThuocQuanThe = Data.taoDanhSachLop().size();
    }

    public QuanThe() {
        quanThe = new ArrayList<>();
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

}
