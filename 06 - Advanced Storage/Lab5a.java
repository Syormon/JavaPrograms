/** This class is used to run the entirety of the program with ArraySortedList
  *  @author	  Simon Spivey
  *  @id		  saspivey
  *  @course	  CSIS 252:	Programming	II
  *  @assignment  Advanced Storage Lab
  */
import java.io.IOException;

public class Lab5a {
   public static void main (String args[]) throws IOException {
       //create storage and IOhandler objects
       Storage storage;
       IOHandler IO;
       // initialize Storage with ArraySortedList, and IOHandler so that 
       // you can either do input through Run I/O or file
       storage = new Storage(new ArraySortedList(), new IOHandler(args));
       // call the run method
       storage.run();
   }
}