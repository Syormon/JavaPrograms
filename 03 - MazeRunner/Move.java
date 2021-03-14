/** This	class	is	used to run	the get the	inputs into	the maze, and reverse
  * the path taken into	the maze	to	return to the start point
  *  @author	  Simon Spivey
  *  @id			  saspivey
  *  @course	  CSIS 252:	Programming	II
  *  @assignment Maze Lab
  */
import java.io.IOException;
public class Move {
	
    //creates a intStack object called stack
	IntStack stack;
    // creates a RobotInterface object called roboInterface
	RobotInterface roboInterface;	

    /*
     Constructor for Move, takes a parameter roboInterface that is a RobotInterface
     it sets the param equal to roboInterface and initializes the stack. This method can
     also throw an IOException
    */   
	public Move(RobotInterface roboInterface) throws IOException	{
        stack = new IntStack();
        this.roboInterface = roboInterface; 
	}

    /*
     This method stores the path that the robot takes. While the program is
     receiving valid input(s) that isn't the escape button, it will push those movements
     onto stack
    */  
    
    public void path() {
        int tempvalue;
        tempvalue = roboInterface.getButton();
        
        while(tempvalue > -2 && tempvalue <= 3) {
            if (tempvalue != roboInterface.ESCAPE && tempvalue != 3) {
                stack.push(tempvalue);
                
                try {
                    roboInterface.moveMotor(tempvalue);
                }
                catch(Exception e) {
                    e.getMessage();
                }

            }
            else if (tempvalue != 3) {
                stack.push(roboInterface.RIGHT);
                stack.push(roboInterface.RIGHT);
                break;
            }
            tempvalue = roboInterface.getButton();
        }
    }
    /*
     This method reverses the path taken into the maze. If the only input
     given was escape, it will just return. If other movements were given, 
     it will output them (if the top is left, it outputs right and if the
     top is right, it outputs left) and pop, bringing you back to where
     you started. It also catches exceptions thrown. It also turns the 
     robot around before it starts unstacking.
    */
	public void escape() {
		  int tempvalue;
		  
		  while (!stack.isEmpty())	{
				tempvalue =	stack.top() * -1;
                try {
				    roboInterface.moveMotor(tempvalue);
                    stack.pop();
                } catch(Exception e) {
                    e.getMessage();
                }
		  }
		  
	}
	 
}