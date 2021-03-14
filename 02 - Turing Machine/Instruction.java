public class Instruction {
   private int curState, curValue, newState, outValue, moveTape;
   
   public Instruction(int curState, int curValue, int newState, int outValue, int moveTape) {
      this.curState = curState;
      this.curValue = curValue;
      this.newState = newState;
      this.outValue = outValue;
      this.moveTape = moveTape;
   }
   public boolean equals(int state, int value) {
      //call upon getInstructions and pass state and value
      // return true/false
      if (state == curState && curValue == value) {
         return true;
      } else {
         return false;
      }
   }
   public int getNewState() {
      return newState;
   }
   public int getNewValue() {
      return outValue;
   }

   public int getDirection() {
      return moveTape;
   }
   
   public String toString() {
      String InstructionOutput;
      InstructionOutput = newState + " " + outValue + " " + moveTape;
      return InstructionOutput;
   }
}