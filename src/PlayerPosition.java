//This class is a pair class; similiar to a tuple in scala
// https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/tuple/Pair.html

public class PlayerPosition {
    private int playerX;
    private int playerY;

    public PlayerPosition(int playerX, int playerY){
        this.playerX = playerX;
        this.playerY = playerY;
    }

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }
}

