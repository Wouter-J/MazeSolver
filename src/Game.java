import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game {

    private int[][] mazeArray;
    private PlayerPosition playerPosition;

    //Setting up variables
    public Game(){

        //TODO: Get variable from one point in solution
        mazeArray  = new int[][]{
                {1, 1, 1, 1,1},
                {1, 0, 0, 2,1},
                {1, 0, 1, 1,1},
                {1, 0, 0, 9,1},
                {1, 1, 1, 1,1}
        };

    }

    //Game start function
    public void startGame(){

    }

    //TODO: Perhaps move this to a separate class
    public JFrame frame;
    public void createBoard(){
        frame = new JFrame();
        frame.setTitle("MazeSolver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new Board());

        //frame.setSize(800, 800);
        frame.setBounds(0, 0, 900, 900);
        frame.setResizable(false);
        frame.setVisible(true);
        //frame.add(maze);

        //frame.getContentPane().validate();
        //frame.getContentPane().repaint();
        frame.repaint();

        playerPosition = this.getCurrentPos();

        //Controls for player / AI
        //TODO: Perhaps move
            frame.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                    //Register a single press
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    //Register a constant press
                    System.out.println("KEY PRESS" + e.getKeyCode()+ ", char=" + e.getKeyChar());
                    char key = e.getKeyChar();
                    if(key == 'w'){
                        System.out.println("W pressed");
                        moveUp();
                    } else if(key == 'a'){
                        System.out.println("A pressed");
                        moveLeft();
                    } else if(key == 'd'){
                        System.out.println("D pressed");
                        moveRight();
                    } else if(key == 's') {
                        System.out.println("S pressed");
                        moveDown();
                    }

                }

                @Override
                public void keyReleased(KeyEvent e) {
                    //Register a release
                }
            });
    }

    //Code for moving a player up;
    private void moveUp(){

        frame.repaint();
    }

    //Code for moving a player up;
    private void moveLeft(){

    }

    //Code for moving a player up;
    private void moveRight(){

    }

    //Code for moving a player up;
    private void moveDown(){

    }

    public PlayerPosition getCurrentPos() {
        for (int x = 0; x < mazeArray.length; x++) {
            for (int y = 0; y < mazeArray.length; y++) {
                if (mazeArray[x][y] == 2) {
                    System.out.println("Player pos found!");
                    this.playerPosition = new PlayerPosition(x, y);

                    System.out.println("Player's at" + x + ", " + y);
                    System.out.println("Update playerpos to: " +this.playerPosition);
                }
            }
        }
        return this.playerPosition;
    }

}
