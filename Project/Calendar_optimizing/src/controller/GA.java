package controller;

import Data.Data;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GA {
    List<Chromosome> population;
    Chromosome chromosome;
    Classroom classroom;
    static final int GENERATIONS = 100;
    static final int POPULATION_SIZE = 50;

    public Chromosome runGA(List<Classroom> classrooms, List<Teacher> teachers,
                            List<Subject> subjects, List<TimeSlot> timeSlots, int targetFitness, int limit) {
        // b1: khoi tao quan the
        population = initializePopulation(classrooms, teachers, subjects, timeSlots);
        // b2: chon ra quan the tot nhat hien tai
        Chromosome bestSolution = getBestSolution(population);
        int bestFitness = caculateFitness(bestSolution);
        // so luong quan the duoc tao ra ma khong co su toi uu nao
        int generationsWithoutImprovement = 0;

        for (int generation = 0; generation < GENERATIONS; generation++) {
            List<Chromosome> newPopulation = new ArrayList<>(population);
            while (newPopulation.size() < POPULATION_SIZE) {
                // b3: chon loc ba me
                Chromosome mom = selectParent(population);
                Chromosome dad = selectParent(population);
                // b4: lai ghep
                Chromosome baby = born(mom, dad);
                // b5: dot bien
                mutate(baby);
                newPopulation.add(baby);
            }
            // b6: tao ra quan the moi
            population = replacePopulation(newPopulation);
            Chromosome newBestSolution = getBestSolution(population);
            int newBestFitness = caculateFitness(newBestSolution);

            if (newBestFitness < bestFitness) {
                bestSolution = newBestSolution;
                bestFitness = newBestFitness;
                generationsWithoutImprovement = 0;
            } else {
                generationsWithoutImprovement++;
            }

            // b7: kiem tra dieu kien dung
            if (generationsWithoutImprovement >= limit) break;
            if (bestFitness <= targetFitness) break;

        }

        return bestSolution;
    }

    private List<Chromosome> replacePopulation(List<Chromosome> newPopulation) {
        return newPopulation;
    }

    private void mutate(Chromosome baby) {
    }

    private Chromosome born(Chromosome mom, Chromosome dad) {
        return mom;
    }

    private Chromosome selectParent(List<Chromosome> population) {
        return null;
    }

    private Chromosome getBestSolution(List<Chromosome> population) {
        Chromosome best = null;
        int bestFitness = caculateFitness(best);
        for (Chromosome chromosome : population) {
            int fitness = caculateFitness(chromosome);
            if (fitness < bestFitness) {
                best = chromosome;
                bestFitness = fitness;
            }
        }
        return best;
    }

    private List<Chromosome> initializePopulation(List<Classroom> classrooms, List<Teacher> teachers, List<Subject> subjects, List<TimeSlot> timeSlots) {
        population = new ArrayList<Chromosome>();
        for (int i = 0; i < POPULATION_SIZE; i++) {
            classroom = classrooms.get(new Random().nextInt(classrooms.size()));

            chromosome = Data.generateRandomSchedule(classroom.getId(), teachers, subjects, timeSlots);
            population.add(chromosome);
        }
        return population;
    }

    private int caculateFitness(Chromosome chromosome) {
        return 0;
    }


}
