import java.io.IOException;

public class Turing {
   Tape myTape;
   getInstructions myInstructions;
   Instruction instruction;
   IOHandler myIO; //instantiating
   
   int state;
   
   public Turing(String[] args) throws IOException {
      myIO = new IOHandler (args);
      state = 0; 
      String tape1;
      tape1 = myIO.nextLine();
      myTape = new Tape(tape1);
      myInstructions = new getInstructions();
      while (myIO.hasNext()) { //keeps adding instructions to myInstructions from myIO
         myInstructions.addInstruction(myIO.nextLine());
      }
   }
   
   public void run () {
      while (state >= 0) { //will keep moving as long as state >= 0
         Instruction instruction;
         instruction = myInstructions.find(state, myTape.getCurValue());
         state = instruction.getNewState();
         myTape.setValue(instruction.getNewValue());
         myTape.move(instruction.getDirection());
      }
      if ((myTape.getCurValue() == -1) || (myTape.getCurValue() == -2)) { // if state is less than 0 go to toString
         toString();
      }
   }
   public String toString() { //determines if you should keep accepting or rejecting
      if (state == -1) {
         return myTape.toString() + " accepting";
      } else if (state == -2) {
         return myTape.toString() + " rejecting";
      } else {
         return myTape.toString() + state;
      }
   }
   public void answer() { //final string to be outputted here
      myIO.println(this.toString());
   }
}