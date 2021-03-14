/** This class does all I/O (either to standard input/output or specified
 *  files depending on what is sent the constructor).  It is designed to aid
 *  in the use of command line arguements to specify input/output files. It also
 *  serves as the text based IO for the robot. It is the direct interaction 
 *  between the user and the robot.
 *  @author     Simon Spivey
 *  @id         saspivey
 *  @course     CSIS 252:  Programming II
 *  @assignment Simon Lab
 */
import java.io.*;
import java.util.*;
import java.io.IOException;

public class IORobot implements RobotInterfaceII {

    /** used to specify the output location */
    PrintStream out;
    /** used to specify the input location */
    Scanner in;
    
    /** creates the input and output locations based on parameter
      * @param args - an array of file names - first is input, second is output
      *             - if no elements, use System.in and System.out
      *             - if only one, use System.out for output
      */
     
    public IORobot(String[] args) throws IOException {
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
    This method is used to get what color the user pressed. It uses 
    generic System.in to get the string, and then return a converted
    string to int.
    */
    public int getButton() {
        String userInput = (in.nextLine());
        int converted = strToInt(userInput);
        return (converted); //gets a random integer between 1 and 4
    }
    
    /*
    This method displays to the user what they need to remember. It
    takes the answer queue as a @param and counter of how many elements
    are in the queue as a @param.
    */
    public void displayString(ArrayQueue1 queue, int counter) {
        ArrayQueue1 tempqueue;
        tempqueue = new ArrayQueue1(queue);
        for (int i = 1; i <= counter; i++) { 
            out.println("" + tempqueue.dequeue());
        }
    }
    /*
    This is a private helper method, that directly helps the getButton method
    convert the @param userInput of a String to an Integer.
    */
    private int strToInt(String str) {
        switch(str.toUpperCase()) {
            case "RED": return 1;
            case "GREEN": return 2;
            case "BLUE": return 3;
            case "YELLOW": return 4;
            default: return 0;
        }
    }
    /*
    This method displays the final score to the user in the Run I/O. 
    */
    public void displayScore(int counter) {
        out.println("only " + (counter - 2) + " correct");
    }
}