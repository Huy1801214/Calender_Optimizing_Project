package model;

import java.util.List;

public class Chromosome {
    List<Gene> genes;
    // số điểm đánh giá độ phù hợp
    double fitness;

    public Chromosome(List<Gene> genes) {
        this.genes = genes;
        this.fitness = 0;
    }

    public List<Gene> getGenes() {
        return genes;
    }

    public void setGenes(List<Gene> genes) {
        this.genes = genes;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

}
