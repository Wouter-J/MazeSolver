import javax.swing.*;
import java.awt.*;

public class Game {



    //Setting up variables
    public Game(){

    }

    //Game start function
    public void startGame(){

    }

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
    }
}
