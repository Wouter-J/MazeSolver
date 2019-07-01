import javax.swing.*;
import java.awt.*;

//Class for the actual drawing of our board
public class Board extends JPanel {

    private int[][] mazeArray;

    public Board(int[][] mazeArray){
        this.mazeArray = mazeArray;
    }

    public int[][] getMaze(){
        return this.mazeArray;
    }

    @Override
    public void paintComponent(Graphics g){
        System.out.println("PAINT CALLED");
        super.paintComponent(g);
        int blockHeight = 30;
        int blockWidth = 30;

        int xPos = 0;
        int yPos = 0;

        //x = row
        //y = col

        int boxWidth = 30;
        int boxHeight = 30;

        for (int currentX = 0;
             currentX < mazeArray.length * boxWidth;
             currentX += boxWidth) {
            for (int currentY = 0;
                 currentY < mazeArray[0].length * boxHeight;
                 currentY += boxHeight) {
                 if(mazeArray[xPos][yPos] == 1) {
                     //System.out.println("WALL");
                     g.setColor(Color.BLACK);
                     g.fillRect(currentY, currentX, blockWidth, blockHeight);
                 } else if(mazeArray[xPos][yPos] == 2) {
                    //System.out.println("PLAYER");
                    g.setColor(Color.MAGENTA);
                    g.fillRect(currentY, currentX, blockWidth, blockHeight );
                } else if(mazeArray[xPos][yPos] == 9) {
                    //System.out.println("ENDGAME");
                    g.setColor(Color.GREEN);
                    g.fillRect(currentY, currentX, blockWidth, blockHeight );
                }
                //Here we draw square's it's a visual thing.
                g.drawRect(currentY, currentX, blockWidth, blockHeight );
                 //Move our pointer along to the next column
                System.out.println();
                yPos++;
            }
            //reset our colomnPointer
            yPos = 0;
            //Up our row pointer
            xPos++;
        }
    }

}
