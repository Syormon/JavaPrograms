/** This class is used to run the entirety of the program with the lejos compilier - for the robot
  *  @author	  Simon Spivey
  *  @id			  saspivey
  *  @course	  CSIS 252:	Programming	II
  *  @assignment Simon Lab
  */
import java.io.IOException;
public class lab3R {
   public static void main(String[] args) throws IOException {
      //creates new simon object called simon
      Simon simon;
      // initializes simon with the Robot
      simon = new Simon(new RobotDevice());
      //calls run method to execute the program
      simon.run();
   }

}