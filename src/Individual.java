import java.util.ArrayList;
import java.util.List;

public class Individual {

    //public List<Integer> moveList = new ArrayList<>();
    public int[] moveList;
    private Game game;

    public Individual(Game game){
        this.game = game;
    }

    //Movement in the movelist is based on numbers.
    //1 = Up; 2 = Left; 3 = Right; 4 = Down
    public void Move(){
        for(int i = 0; i < moveList.length; i++){
            switch(moveList[i]) {
                case 1: {
                    System.out.println("Moving up!");
                    game.moveUp();
                    break;
                }
                case 2: {
                    System.out.println("Moving left!");
                    game.moveLeft();
                    break;
                }
                case 3: {
                    System.out.println("Moving right!");
                    game.moveRight();
                    break;
                }
                case 4: {
                    System.out.println("Moving down!");
                    game.moveDown();
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
}
