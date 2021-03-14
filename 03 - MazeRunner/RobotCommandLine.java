import java.io.*;
import java.util.*;

/** This class does all I/O (either to standard input/output or specified
 *  files depending on what is sent the constructor).  It is designed to aid
 *  in the use of command line arguements to specify input/output files.
 *  @author     Cathy Bareiss
 *  @id         cbareiss
 *  @course     CSIS 252:  Programming II
 *  @assignment Demostration
 *  @related    CountingProblem
 */
public class RobotCommandLine implements RobotInterface {
    /** used to specify the output location */
    PrintStream out;
    /** used to specify the input location */
    Scanner in;

    /** creates the input and output locations based on parameter
      * @param args - an array of file names - first is input, second is output
      *             - if no elements, use System.in and System.out
      *             - if only one, use System.out for output
      */
    public RobotCommandLine(String[] args) throws IOException {
        if (args.length == 0) { // using standard in and out
            in = new Scanner(System.in);
            out = System.out;
        } else if (args.length == 1) { // using standard out
            in = new Scanner(new FileReader(args[0]));
            out = System.out;
        } else { // using specified files
            in = new Scanner(new FileReader(args[0]));
            out = new PrintStream(args[1]);
        }
    
    }
    
    /*
    This method was modified to support the variables LEFT RIGHT FORWARD
    and ESCAPE
    */
    public int getButton() {
        String number;
        if(in.hasNext()){
            number = in.next().toLowerCase();
            if(number.equals("l")) {
               return LEFT;
            } else if (number.equals("r")) {
               return RIGHT;
            } else if (number.equals("f")) {
               return FORWARD;
            } else if (number.equals("e")) {
               return ESCAPE;
            }
        } 
        return 0;
    }
    /*
    This method was modified to support the variables LEFT RIGHT FORWARD
    and ESCAPE
    */
    public void moveMotor(int motor) throws Exception {
        String temp;
        temp = " ";
        if(motor == LEFT) {
            temp = "Left";
         } else if (motor == RIGHT) {
            temp = "Right";
         } else if (motor == FORWARD) {
            temp = "Forward";
         } 
        out.println(temp);
    }
    public void displayString(String str) throws Exception {
        out.println("Displaying "+str);
    }
}
