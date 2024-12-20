package controller;

import data.Data;
import model.CaThe;
import model.Gene;
import model.Lop;

import java.util.ArrayList;
import java.util.List;

public class TaoCaThe {
    TaoGene taoGene;
    CaThe caThe;

    public TaoCaThe() {
        taoGene = new TaoGene();
    }

    public CaThe taoCaThe(List<Lop> dsLop) {
        List<Gene> genes = taoDsGenes(dsLop);
        caThe = new CaThe(genes);
        return caThe;
    }

    public List<Gene> taoDsGenes(List<Lop> dsLop) {
        List<Gene> genes = new ArrayList<>();
        for (Lop lop : dsLop) {
            Gene gene = taoGene.taoTKBChoMoiLop(lop);
            genes.add(gene);
        }
        return genes;
    }

//    public void printCaThe() {
//        for (Gene gene : caThe.getGenes()) {
//            gene.printTKB();
//            System.out.println();
//        }
//    }

    public static void main(String[] args) {
        List<Lop> dsLop = Data.taoDanhSachLop();
        TaoCaThe taoCaThe = new TaoCaThe();
        CaThe caThe1 = taoCaThe.taoCaThe(dsLop);
        caThe1.printCaThe();
    }
}
