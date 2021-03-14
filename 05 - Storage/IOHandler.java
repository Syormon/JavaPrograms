import java.io.*;
import java.util.*;

/** This class does all the I/O (eitehr to standard input/output or specified
 *  Files depending on what is sent to the constructor).  It is designed to
 *  aid in the use of command line arguments to specify files for I/O
 *  @author     Cathy Bareiss
 *  @id         cbareiss
 *  @course     CSIS 252: Programming II
 *  @assignment class demonstration
 *  @related    IOInterface
 */
public class IOHandler implements IOInterface {
    /** Used to specify the output location */
    PrintStream out;
    /** Used to specify the input location */
    Scanner in;
    
    /** creates the input and output locations on the the argument
      * @param args -> an array of filenames.  First is used for input, 
      *                                        Second for output
      *                if the array is empty, standard I/O is used
      *                     (System.in and System.out)
      *                if only one element is in the array,
      *                     System.out is used for output
      */
    public IOHandler(String[] args) throws IOException {
        if (args.length == 0) { // standard input and output
            in = new Scanner(System.in);
            out = System.out;
        } else if (args.length == 1) { // standard output
            in = new Scanner(new FileReader(args[0]));
            out = System.out;
        } else { //uses fiels for both
            in = new Scanner(new FileReader(args[0]));
            out = new PrintStream(args[1]);
        }
    }
    
    /** Checks to see if input is done on a line
      * @return boolean, true if there is more input, false if not
      */
    public boolean hasNext() {
        return in.hasNext();
    }
    
    /** Prints input on next line
      * @return String, input on next line
      */
    public String nextLine() {
        return in.nextLine();
    }
    
    /** Prints next input on line
      * @return String, next input on line
      */
    public String next() {
        return in.next();
    }
    
    /** Prints string with returning to the next line
      * @param String str, string to be printed
      */
    public void println(String str) {
        out.println(str);
    }
    
    /** Prints string
      * @param String str, string to be printed
      */
    public void print(String str) {
        out.print(str);
    }

} 
