package model;

import java.util.List;

/*
Ca the la tkb cua toan truong (tap hop cua nhieu gene)
 */

public class CaThe {
    String tenCaThe;
    int kichThuocCaThe;
    List<Gene> genes;

    public CaThe(List<Gene> genes) {
        this.tenCaThe = "";
        this.genes = genes;
        this.kichThuocCaThe = genes.size();
    }

    public String getTenCaThe() {
        return tenCaThe;
    }

    public void setTenCaThe(String tenCaThe) {
        this.tenCaThe = tenCaThe;
    }

    public int getKichThuocCaThe() {
        return kichThuocCaThe;
    }

    public void setKichThuocCaThe(int kichThuocCaThe) {
        this.kichThuocCaThe = kichThuocCaThe;
    }

    public List<Gene> getGenes() {
        return genes;
    }

    public void setGenes(List<Gene> genes) {
        this.genes = genes;
    }

    public void printCaThe() {
        CaThe caThe = new CaThe(genes);
        System.out.println("TKB toàn trường: ");
        for (Gene gene : caThe.getGenes()) {
            gene.printTKB();
            System.out.println();
        }
    }
}
