import java.util.concurrent.ThreadLocalRandom;

//In here we use a Genetic Algorithm to solve our maze
public class Algorithm {

    private Game game;
    private Individual individual;

    public int POP_SIZE = 5;
    public int MAX_MOVES = 10;

    public void setupPop(){

        for(int i = 0; i < POP_SIZE; i++){
            //Create int array of size max moves
            int[] moves = new int[MAX_MOVES];

            //For every move we create a random number.
            for(int x = 0; x < moves.length; x++) {
                //Random between 1 & 4
                moves[x] = ThreadLocalRandom.current().nextInt(1, 4 + 1);
            }
            individual.moveBoi = moves;
        }
            //individual.moveList[i] = 4;
    }


    //TODO: Setup population & generate it
    public Algorithm(Game game){
        this.game = game;
        this.individual = new Individual(game);

        setupPop();
        individual.Move();
        //game.startGame();
    }

    //TODO: Compute fitness
    //TODO: Select fittest
    void selection(){

    }
    //TODO: Crossover fittest from pop
    void crossover(){

    }
    //TODO: Mutate
    void mutate(){

    }
    //TODO: Spawn new pop


}
