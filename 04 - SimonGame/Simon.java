/** This class does all the logic and proccessing for the game.
 *  @author     Simon Spivey
 *  @id         saspivey
 *  @course     CSIS 252:  Programming II
 *  @assignment Simon Lab
 */
 

import java.io.IOException;
import java.util.*;

public class Simon {
   // instaiate queue of type ArrayQueue1
   public ArrayQueue1 queue;
   // instaiate roboInterface
   RobotInterfaceII roboInterface;
   // instaiate random
   Random random = new Random(); 
   //a field variable that counts the amount of elements in the queue
   int colorCounter = 1;    
   
   /* 
   This is the constructor and we use @param roboInterface of RobotInterfaceII
   generically so that we can decide within the lab3 executable file rather to use
   IO or the actually robot. We create a new queue within the constructor and set
   the robotinterface in which we passed equal to what the Simon class will use.
   */
   public Simon(RobotInterfaceII roboInterface) throws IOException { 
      queue = new ArrayQueue1(); 
      this.roboInterface = roboInterface; 
   }
   /*
   This method randomly generates a number between 1-4. It then converts that number
   into a String, and then queues that to our queue. Then after queueing, it adds one
   to our counter.
   */
   public void getPattern() {
      int randvalue = (random.nextInt(4) + 1);
      String next = intToString(randvalue); 
      queue.enqueue(next); 
      colorCounter++; 
   }
   /*
   This method just returns a boolean rather the value the user Inputed is equal to the 
   Simon answer. It uses @param counter to iterate trhough the queue. Within this method,
   it makes a copy of of our current answer queue, and then dequeues both the user's made
   queue and the copy and compares each value.
   */
   public boolean checkSequence(int counter) {
      ArrayQueue1 tempqueue;
      tempqueue = new ArrayQueue1(queue);
      
      String answer;
      String userInputS;
      int userInput;
      int i;
      i = 1;
      boolean success;
      success = true;
      
      while(success && i <= counter) {
         userInput = roboInterface.getButton();
         userInputS = intToString(userInput); 
         answer = ("" + tempqueue.dequeue());
         if (userInputS.equals(answer)) {
            i++;
         }
         else {
            success = false;
         }
      }
      return success;
   }
   
   /*
   This method is the main run function that lab3/lab3R calls upon. It calls
   upon each method and then determines where each value should go. If 
   checkSequence = false it then terminates the program.
   */
   public void run() {
      boolean success;
      int i;
      
      success = true;
      i = 1;
      
      getPattern();

      while (success && i <= colorCounter) {
         try {
            roboInterface.displayString(queue, i);
         }
         catch(Exception e) {
            e.getMessage();
         }
         success = checkSequence(i);
         if (success) {
            i++;
            getPattern();
         }
         else {
            success = false;
            roboInterface.displayScore(colorCounter);
         }
      } 
   }
   /*
   This method is a private helper method that just takes @param integer that must be 
   between 1-4 and converts it the right color. It then returns that color as a String.
   */
   private static String intToString(int n) {
      switch(n) {
         case 1: return ("RED");
         case 2: return ("GREEN");
         case 3: return ("BLUE");
         case 4: return ("YELLOW");
         default: return ("null");
      }
   }
}