import java.util.ArrayList;
import java.util.List;

public class Individual {

    private List<Integer> moveList = new ArrayList<>();
    private Game game;

    public Individual(Game game){
        //this.moveList = moveList;
        this.game = game;
        moveList.add(4);
        moveList.add(2);
    }

    //Movement in the movelist is based on numbers.
    //1 = Up; 2 = Left; 3 = Right; 4 = Down
    public void Move(){
        moveList.toArray();
        for(int i = 0; i < moveList.size(); i++){
//            if(moveList.get(i) == 1){
//
//            }
            switch(moveList.get(i)) {
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
