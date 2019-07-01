import java.util.ArrayList;
import java.util.List;

public class Individual {

    //public List<Integer> moveList = new ArrayList<>();
    public int[] moveList;
    public List<String> vistedMoves;
    public String playerString;
    private Game game;

    //Variables for fitnessScore
    public int wallHugs;
    public int freedomPoints;
    public int fitnessScore;
    public int vistedPoints;

    public Individual(Game game){
        this.vistedMoves = new ArrayList<>();
        this.game = game;
        this.fitnessScore = 0;
        this.wallHugs = 0;
        this.freedomPoints = 0;
        this.vistedPoints = 0;

        //TODO: Add first and lastpos
    }

    //Movement in the movelist is based on numbers.
    //1 = Up; 2 = Left; 3 = Right; 4 = Down
    public void Move(){
        for(int i = 0; i < moveList.length; i++){
            playerString = "";
            switch(moveList[i]) {
                case 1: {
                    //TODO: Visited points to others
                    System.out.println("Moving up!");
                    //Logic for fitness score might need to be moved
                    if(!(game.mazeArray[game.playerPosition.getPlayerY() -1][game.playerPosition.getPlayerX()] == 1)){
                        playerString.concat("game.playerPosition.getPlayerY() - 1 + game.playerPosition.getPlayerX()");
                        if(vistedMoves.contains(playerString)){
                            vistedPoints += 2;
                        } else {
                            freedomPoints += 5;
                            vistedMoves.add(playerString);
                        }
                    } else {
                        System.out.println("Stuck");
                        wallHugs += 10;
                    }
                    game.moveUp();
                    if(game.checkWin()){
                        freedomPoints += 200;
                    }
                    break;
                }
                case 2: {
                    System.out.println("Moving left!");
                    if(!(game.mazeArray[game.playerPosition.getPlayerY()][game.playerPosition.getPlayerX() -1] == 1)){
                        playerString.concat("game.playerPosition.getPlayerY() + game.playerPosition.getPlayerX() -1");
                        if(vistedMoves.contains(playerString)){
                            vistedPoints += 2;
                        } else {
                            freedomPoints += 5;
                            vistedMoves.add(playerString);
                        }
                    } else {
                        System.out.println("Stuck");
                        wallHugs += 1;
                    }
                    game.moveLeft();
                    if(game.checkWin()){
                        freedomPoints += 200;
                    }
                    break;
                }
                case 3: {
                    System.out.println("Moving right!");
                    if(!(game.mazeArray[game.playerPosition.getPlayerY()][game.playerPosition.getPlayerX() +1] == 1)){
                        playerString.concat("game.playerPosition.getPlayerY() + game.playerPosition.getPlayerX() +1");
                        if(vistedMoves.contains(playerString)){
                            vistedPoints += 2;
                        } else {
                            freedomPoints += 5;
                            vistedMoves.add(playerString);
                        }
                    } else {
                        System.out.println("Stuck");
                        wallHugs += 1;
                    }
                    game.moveRight();
                    if(game.checkWin()){
                        freedomPoints += 200;
                    }
                    break;
                }
                case 4: {
                    System.out.println("Moving down!");
                    if(!(game.mazeArray[game.playerPosition.getPlayerY() +1][game.playerPosition.getPlayerX()] == 1)){
                        playerString.concat("game.playerPosition.getPlayerY() + 1 + game.playerPosition.getPlayerX()");
                        if(vistedMoves.contains(playerString)){
                            vistedPoints += 2;
                        } else {
                            freedomPoints += 5;
                            vistedMoves.add(playerString);
                        }
                        freedomPoints += 1;
                    } else {
                        System.out.println("Stuck");
                        wallHugs += 1;
                    }
                    game.moveDown();
                    if(game.checkWin()){
                        freedomPoints += 200;
                    }
                    break;
                }
                default: {
                    System.out.println("End of line");
                    break;
                    //You shouldn't be here mate.
                }
            }
        }

    }

    //TODO: Compute fitness in a cleaner way
    void calcFittest(){
        System.out.println("Wall hugs");
        System.out.println(this.wallHugs);

        System.out.println("Freedom points");
        System.out.println(this.freedomPoints);

        System.out.println("Visited points");
        System.out.println(this.vistedPoints);

        this.fitnessScore = freedomPoints - wallHugs - vistedPoints;
        System.out.println("Individual fit score: " + fitnessScore);
    }

    @Override
    public String toString(){
        return "Individual fitscore: " + fitnessScore + " Movelist: " + moveList;
    }


}
