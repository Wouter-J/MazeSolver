
## MazeSolver
Avans assignment for creating an AI that solves mazes.
Entire Assignment down below

## Research
Waarom punten / pop op deze manier goed of slecht is etc.

## Introduction
In this assignment you will solve a maze using a genetic algorithm. The maze you will solve is a 2D maze that consists of square cells. A cell is either open or a wall. You can move around on the open cells. The goal is to find a path from the starting cell to the end cell.

## Assignment
Write a program that solves a maze as described in the introduction with a genetic algorithm. To help you get started there is a list with hints and points you need to address when writing this program.

1.  ~~First make a way to represent the 2D maze in your program.~~
    
2.  ~~The DNA of an individual is a sequence of moves that it runs over. A sequence of moves could for example be [Right, Right, Right, Up, Up, Up, Right, Right, Down]. Make sure the sequence is long enough to reach the goal cell of your maze! If you try to move to a cell with a wall the move is simply ignored and you stay in the cell you were.~~
    
3.  Think of a fitness function that gives a score to how well an individual is performing. Some ideas are: positive points for the total distance from where you started, negative points for bumping into a wall, negative points for the distance to the goal after the sequence of moves has been executed. Be creative with thinking of scores!
    
4.  ~~In the genetic algorithm you should crossover the DNA of two individuals that score roughly the same on the fitness function. This means that like in the 8 queen example you swap parts of the sequence of moves. After this also some random mutation can be applied to the offspring.~~ Might need some rework
    
5.  Let only the best performing individuals of the offspring live (and don't feel sorry for those who didn't make it...)

## Links used | Maze creation
- https://stackoverflow.com/questions/25798958/iterate-through-2-dimensional-array
- https://stackoverflow.com/questions/49493733/draw-or-paint-a-2d-array-in-java
- https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html
- https://docs.oracle.com/javase/7/docs/api/java/awt/Color.html
- https://www.geeksforgeeks.org/print-2-d-array-matrix-java/
- https://stackoverflow.com/questions/20844144/how-do-i-make-a-rectangle-move-across-the-screen-with-key-bindings
- https://stackoverflow.com/questions/21969954/how-to-detect-a-key-press-in-java
- https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/tuple/Pair.html

## Links used | AI creation
 - https://towardsdatascience.com/introduction-to-genetic-algorithms-including-example-code-e396e98d8bf3
 - https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java
 - https://stackoverflow.com/questions/43206593/how-to-split-an-integer-array-into-two
 - https://stackoverflow.com/questions/33349698/order-one-crossover-in-java-genetic-algorithm