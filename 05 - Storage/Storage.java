/** Uses input to add to an list and display 
 *  @author     Simon Spivey
 *  @id         
 *  @course     CSIS 252: Programming II
 *  @assignment Storage Lab
 *  @related    
 */

import java.util.*;

public class Storage {
   // initialzing variables
   ListInterface list;
   Range range;
   IOHandler IO;
   int numRanges;
   boolean run;
   
   // we have these @params so that we can use the command IO to chose which
   // type of list to use and we have IOHandler so that we can do either
   // Run I/O or a text file
   public Storage(ListInterface list, IOHandler IO) {
      this.list = list;
      this.IO = IO;
      numRanges = 0;
      run = true; 
   }
   // private method that just gets the input and converts it to an int
   private int getInput() {
      String nextInput;
      int curInput;
      
      nextInput = IO.next();
      curInput = Integer.parseInt(nextInput);
      if (curInput > 5000 || curInput < 0) {
          getInput();
      }
      return curInput;
   }

   // main run file 
   public void run() {
      while(run) {
         range = new Range(getInput());
      
         if (!list.find(range)) {
            list.add(range);
            numRanges++; 
         }
         
         // numRanges is the Amount of Ranges we have and 
         // returnCompare is the amount of compares we do 
         System.out.println(numRanges + "\t" + list.returnCompare());
         
         // only quits if we have a text file where we get to the end
         if (!IO.hasNext()) {
            run = false;
         }
      }

   }

}