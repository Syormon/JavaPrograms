/** This class is used to run move from the robot using lejos compilier
  *  @author	  Simon Spivey
  *  @id			  saspivey
  *  @course	  CSIS 252:	Programming	II
  *  @assignment Maze Lab
  */

import java.io.IOException;
public class Lab2R {
   public static void main(String[] args) throws IOException {
      //creates new Move object called move
      Move move;
      //initializes move using the parameter new RobotNXT()
      move = new Move(new RobotNXT());
      //calls the method move() in the maze class
      move.path();
      //calls the method path() in the maze class
      move.escape();
   }
}