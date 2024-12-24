package model;

import controller.DanhGia;
import controller.TaoQuanThe;
import data.Data;

import java.util.ArrayList;
import java.util.List;

/*
Ca the la tkb cua toan truong (tap hop cua nhieu gene)
 */

public class CaThe implements Cloneable {
    int kichThuocCaThe;
    List<Gene> genes;
    int fitnessScore;

    public CaThe(List<Gene> genes) {
        this.genes = genes;
        this.kichThuocCaThe = genes.size();
        this.fitnessScore = 0;
    }

    public CaThe() {
        this.fitnessScore = 0;
        this.genes = new ArrayList<>();
    }

    public int getFitnessScore() {
        return fitnessScore;
    }

    public void setFitnessScore(int fitnessScore) {
        this.fitnessScore = fitnessScore;
    }

    public List<Gene> getGenes() {
        return genes;
    }

    public void printCaThe() {
        CaThe caThe = new CaThe(genes);
        for (Gene gene : caThe.getGenes()) {
            gene.printTKB();
            System.out.println();
        }
        //System.out.println("diem " + caThe.getFitnessScore());
    }

    public static void main(String[] args) {
        TaoQuanThe taoQuanThe = new TaoQuanThe();
        QuanThe quanThe = taoQuanThe.taoQuanThe(Data.taoDanhSachLop());
        DanhGia danhGia = new DanhGia();
        danhGia.danhGiaCacCaTheTrongQuanThe(quanThe);
        for(CaThe caThe : quanThe.getQuanThe()) {
            caThe.printCaThe();
        }
    }
}
