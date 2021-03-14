/**  This class is a robot interface 
  *  @author	  Simon Spivey
  *  @id			  saspivey
  *  @course	  CSIS 252:	Programming	II
  *  @assignment Maze Lab
  */

public interface RobotInterface {
   public int LEFT = -1;
   // creates a variable for move left
   public int RIGHT = 1;
   // creates a variable for move right
   public int FORWARD = 0;
   // creates a variable for move forward
   public int ESCAPE = 2;
   // creates a variable for escape button
   public int getButton();
   // method to get button
   public void moveMotor(int motor) throws Exception;
   // method to move motor
   public void displayString(String str) throws Exception;
   // method to display a string
}