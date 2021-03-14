/** This class is used to run the entirety of the program with SortedList
  *  @author	  Simon Spivey
  *  @id			  saspivey
  *  @course	  CSIS 252:	Programming	II
  *  @assignment Storage Lab
  */

import java.io.IOException;

public class Lab4S {
   public static void main (String args[]) throws IOException {
       //create storage and IOhandler objects
       Storage storage;
       IOHandler IO;
       // initialize Storage with sortedlist, and IOHandler so that 
       // you can either do input through Run I/O or file
       storage = new Storage(new SortedList(), new IOHandler(args));
       // call the run method
       storage.run();
   }
}