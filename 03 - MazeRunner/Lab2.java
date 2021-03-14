/** This class is used to run move.java with the general jdk compilier
  *  @author	  Simon Spivey
  *  @id			  saspivey
  *  @course	  CSIS 252:	Programming	II
  *  @assignment Maze Lab
  */

import java.io.IOException;
public class Lab2 {
   public static void main(String[] args) throws IOException {
      //creates new Move object called move
      Move move;
      //initializes move using the parameter new RobotCommandLine(args)
      move = new Move(new RobotCommandLine(args));
      //calls the method move() in the maze class
      move.path();
      //calls the method path() in the maze class
      move.escape();
   }
}