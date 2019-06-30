import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

//In here we use a Genetic Algorithm to solve our maze
public class Algorithm {

    private Game game;
    private Individual individual;

    public int POP_SIZE = 5;
    public int MAX_MOVES = 2;

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

    //TODO: Setup population & generate it
    public Algorithm(Game game){
        this.game = game;
        this.individual = new Individual(game);

        setupPop();

        for(int i = 0; i < POP_SIZE; i++){
            individuals[i].Move();
            individuals[i].calcFittest();
        }
        Individual fittestBoi = selection();
        Individual secondFittest = getSecondFittest();

        crossover(fittestBoi, secondFittest);
        //game.startGame();
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

    //TODO: Crossover fittest from pop
    //During a crossover we create a new individual by combining aspects of selected individuals.
    //Mimicking reproduction from nature
    public int[] crossover(Individual individual1, Individual individual2){
            Individual child = new Individual(game);
            int[] tmp;

//            int crossoverPoint = rn.nextInt(individual1.moveList.length);

//            for(int i = 0; i < individual1.moveList.length; i++){
//                int temp = individual1.moveList[i];
//                individual1.moveList[i] = individual2.moveList[i];
//                individual2.moveList[i] = temp;
//
////                Undefined since move list does not exist yet
////                child.moveList[i] = temp
//            }


//        for (int z = 0; z < individuals.length; z++){
//            individuals[z] = new Individual(game);
//        }
//
//        for(int i = 0; i < POP_SIZE; i++){
//            //Create int array of size max moves
//            int[] moves = new int[MAX_MOVES];
//
//            //For every move we create a random number.
//            for(int x = 0; x < moves.length; x++) {
//                //Random between 1 & 4
//                moves[x] = ThreadLocalRandom.current().nextInt(1, 4 + 1);
//            }
//            individuals[i].moveList = moves;
//        }

            //Uniform crossover; we randomly copy numbers from the first or second parent
            for(int i = 0; i < individual1.moveList.length; i++){
                int a = individual1.moveList[i];

                if(new Random().nextInt(2) == 0){
                    individual1.moveList[i] = individual2.moveList[i];
                    individual2.moveList[i] = a;
                }
                
            }
        return child.moveList;
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
    //TODO: Spawn new pop


}
