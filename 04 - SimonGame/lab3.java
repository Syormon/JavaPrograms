/** This class is used to run the entirety of the program with the general jdk compilier
  *  @author	  Simon Spivey
  *  @id			  saspivey
  *  @course	  CSIS 252:	Programming	II
  *  @assignment Simon Lab
  */

import java.io.IOException;
public class lab3 {
   public static void main(String[] args) throws IOException {
      //creates new simon object called simon
      Simon simon; 
      // initializes simon with Run I/O using @param IORobot
      simon = new Simon(new IORobot(args));  
      //calls run method to execute the program
      simon.run(); 
   }

}