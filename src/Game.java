import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game {
    private PlayerPosition playerPosition;

    private int[][] mazeArray;

    //Setting up variables
    public Game(){
        this.mazeArray = new int[][]{
                {1, 1, 1, 1,1},
                {1, 2, 1, 9,1},
                {1, 0, 1, 0,1},
                {1, 0, 0, 0,1},
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

        frame.getContentPane().add(new Board(mazeArray));

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
    //To move up we add one to the player's X axis so player {0, 1} becomes player {0, 2}
    //Based on this we can redraw the square that is a player; with this the player seems to move
    public void moveUp(){
        System.out.println(playerPosition.getPlayerX());
        System.out.println(playerPosition.getPlayerY());
        System.out.println(mazeArray[playerPosition.getPlayerY () -1][playerPosition.getPlayerX()]);
        if(!(mazeArray[playerPosition.getPlayerY() -1][playerPosition.getPlayerX()] == 1)){
            System.out.println("YEET");

            mazeArray[playerPosition.getPlayerY()][playerPosition.getPlayerX()] = 0;
            mazeArray[playerPosition.getPlayerY() -1][playerPosition.getPlayerX()] = 2;

            this.playerPosition = getCurrentPos();
            frame.validate();
            frame.repaint();

            try {
                Thread.sleep(300);
            } catch(Exception e){
                System.out.println(e);
            }

        } else {
            System.out.println("Stuck");
        }

    }

    //Code for moving a player left;
    //To move up we extract one to the player's Y axis so player {1, 0} becomes player {0, 0}
    public void moveLeft(){
        if(!(mazeArray[playerPosition.getPlayerY()][playerPosition.getPlayerX() -1] == 1)){
            System.out.println("YEET");

            mazeArray[playerPosition.getPlayerY()][playerPosition.getPlayerX()] = 0;
            mazeArray[playerPosition.getPlayerY()][playerPosition.getPlayerX() -1] = 2;

            this.playerPosition = getCurrentPos();
            frame.validate();
            frame.repaint();

            try {
                Thread.sleep(300);
            } catch(Exception e){
                System.out.println(e);
            }

        } else {
            System.out.println("Stuck");
        }
    }

    //Code for moving a player right;
    //To move up we add one to the player's Y axis so player {1, 0} becomes player {2, 0}
    public void moveRight(){
        if(!(mazeArray[playerPosition.getPlayerY()][playerPosition.getPlayerX() +1] == 1)){
            System.out.println("YEET");

            mazeArray[playerPosition.getPlayerY()][playerPosition.getPlayerX()] = 0;
            mazeArray[playerPosition.getPlayerY()][playerPosition.getPlayerX() +1] = 2;

            this.playerPosition = getCurrentPos();
            frame.validate();
            frame.repaint();

            try {
                Thread.sleep(300);
            } catch(Exception e){
                System.out.println(e);
            }

        } else {
            System.out.println("Stuck");
        }
    }

    //Code for moving a player down;
    //To move up we extract one to the player's X axis so player {0, 1} becomes player {0, 0}
    public void moveDown(){
        if(!(mazeArray[playerPosition.getPlayerY() +1][playerPosition.getPlayerX()] == 1)){
            System.out.println("YEET");

            mazeArray[playerPosition.getPlayerY()][playerPosition.getPlayerX()] = 0;
            mazeArray[playerPosition.getPlayerY() +1][playerPosition.getPlayerX()] = 2;

            this.playerPosition = getCurrentPos();
            frame.validate();
            frame.repaint();

            try {
                Thread.sleep(300);
            } catch(Exception e){
                System.out.println(e);
            }

        } else {
            System.out.println("Stuck");
        }
    }

    public PlayerPosition getCurrentPos() {
        for (int x = 0; x < mazeArray.length; x++) {
            for (int y = 0; y < mazeArray[x].length; y++) {
                if (mazeArray[x][y] == 2) {
                    playerPosition = new PlayerPosition(y, x);

                    System.out.println("Player's at: " + x + ", " + y);
                    //System.out.println("Update playerpos to: " +this.playerPosition);
                }
            }
        }
        return this.playerPosition;
    }

}
