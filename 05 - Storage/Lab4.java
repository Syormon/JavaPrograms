/** This class is used to run the entirety of the program with unsortedList
  *  @author	  Simon Spivey
  *  @id			  saspivey
  *  @course	  CSIS 252:	Programming	II
  *  @assignment Storage Lab
  */
import java.io.IOException;

public class Lab4 {
   public static void main (String args[]) throws IOException {
       //create storage and IOhandler objects
       Storage storage;
       IOHandler IO;
       // initialize Storage with unsortedlist, and IOHandler so that 
       // you can either do input through Run I/O or file
       storage = new Storage(new UnsortedList(), new IOHandler(args));
       // call the run method
       storage.run();
   }
}