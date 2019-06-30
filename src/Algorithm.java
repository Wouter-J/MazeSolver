//In here we use a Genetic Algorithm to solve our maze
public class Algorithm {

    private Game game;
    private Individual individual;
    //TODO: Setup population & generate it
    public Algorithm(Game game){
        this.game = game;
        this.individual = new Individual(game);
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
