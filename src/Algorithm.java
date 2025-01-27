import javax.swing.*;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

//In here we use a Genetic Algorithm to solve our maze
public class Algorithm {

    private Game game;
    private Individual individual;

    public int POP_SIZE = 30; //Max size of each population
    public int MAX_MOVES = 25; //Max amount of moves a player is allowed to take
    public int genCount = 10; //current max amount of generations

    Individual[] individuals = new Individual[POP_SIZE];

    public void setupPop(){

        //For each individual create an object
        for (int z = 0; z < individuals.length; z++){
            individuals[z] = new Individual(game);
        }

        for(int i = 0; i < POP_SIZE; i++){
            //Create int array of size max moves
            int[] moves = new int[MAX_MOVES];

            //For every move we create a random number.
            for(int x = 0; x < moves.length; x++) {
                //Random between 1 & 4
                moves[x] = ThreadLocalRandom.current().nextInt(1, 4 + 1);
            }
            individuals[i].moveList = moves;
        }

    }

    //Setup population & generate it
    public Algorithm(Game game){
        this.game = game;
        this.individual = new Individual(game);

        for(int z = 0; z < genCount; z++){
            setupPop();

            for(int i = 0; i < POP_SIZE; i++){
                individuals[i].Move();
                individuals[i].calcFittest();
            }
            Individual fittestBoi = selection();
            Individual secondFittest = getSecondFittest();

            Individual child = crossover(fittestBoi, secondFittest);
            mutate(child);
            evolve(child);


            System.out.println("Generation: " + genCount + " Fittest: " + fittestBoi + " Moves" + fittestBoi.moveList);
            //TODO: Extra: Add a path for every individual and a best of replay function
            //TODO: Extra: Add visual representation for generations etc
        }

        genCount++;
    }

    //Get the fittest individual
    public Individual selection(){
        int maxFit = Integer.MIN_VALUE;
        int maxFitIndex = 0;
        for(int i = 0; i < POP_SIZE; i++){
            if(maxFit <= individuals[i].fitnessScore){
                maxFit = individuals[i].fitnessScore;
                maxFitIndex = i;
            }
        }
        int fittest = individuals[maxFitIndex].fitnessScore;
        System.out.println("Fittest boi of all: " + fittest);
        return individuals[maxFitIndex];
    }

    //Get the second most fittest
    //TODO: Cleanup
    public Individual getSecondFittest() {
        int maxFit1 = 0;
        int maxFit2 = 0;
        for (int i = 0; i < individuals.length; i++) {
            if (individuals[i].fitnessScore > individuals[maxFit1].fitnessScore) {
                maxFit2 = maxFit1;
                maxFit1 = i;
            } else if (individuals[i].fitnessScore > individuals[maxFit2].fitnessScore) {
                maxFit2 = i;
            }
        }
        return individuals[maxFit2];
    }

    public int leastFittest(){
        int minFit = Integer.MAX_VALUE;
        int minFitIndex = 0;
        for(int i = 0; i < POP_SIZE; i++){
            if(minFit >= individuals[i].fitnessScore){
                minFit = individuals[i].fitnessScore;
                minFitIndex = i;
            }
        }
//        int leastFittest = individuals[minFitIndex].fitnessScore;
        System.out.println("Least fittest: " + individuals[minFitIndex]);
        return minFitIndex;
    }

    //Crossover fittest from pop
    //During a crossover we create a new individual by combining aspects of selected individuals.
    //Mimicking reproduction from nature

    /**
     * This function performs a crossover
     * Must be of the same lenght
     * @param parent1 provides the first int array
     * @param parent2 provides the second int array
     * @return returns the child as individual
     */
    public Individual crossover(Individual parent1, Individual parent2){
            Individual child = new Individual(game);
            int[] childMoves = new int[MAX_MOVES];
            System.out.println(childMoves);

        //Uniform crossover; we randomly copy numbers from the first or second parent
            for(int i = 0; i < parent1.moveList.length; i++){
                int rand = new Random().nextInt(2);
                if(rand == 0){
                    childMoves[i] = parent1.moveList[i];
                }else{
                    childMoves[i] = parent2.moveList[i];
                }
                System.out.println(childMoves[i]);
            }

            child.moveList = childMoves;
            return child;
    }

    //TODO: Mutate; should probably clear this up
    public void mutate(Individual individual){
        int[] moves = individual.moveList;
        Random rn = new Random();

        for(int i = 0; i < moves.length; i++){
            if (0.6 > Math.random()){
                moves[i] = rn.nextInt(4);
            }
        }
    }

    //Replaces weakest pop with better pop
    public Individual[] evolve(Individual child){
        int leastIndex = leastFittest();
        individuals[leastIndex] = child;
        return this.individuals;
    }

}
