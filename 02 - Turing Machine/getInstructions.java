
public class getInstructions {
   private Instruction[] myInstruction;
   private int container;
   private static final int MAX_VALUE = 200;
   
   public getInstructions() {
      container = 0;
      myInstruction = new Instruction[MAX_VALUE];
   }
   public void addInstruction(String getInstruction) { //get instructions in the form of a string and add it to the myinstructions object array
      int[] tempInstructions;
      tempInstructions = new int[5];
      
      String[] stringTemp = getInstruction.split(" "); //formating of the string
      
      for (int i = 0; i < 5; i++) {
         tempInstructions[i] = Integer.parseInt(stringTemp[i]); //formatting of the string beofre putting them to a temporary Array
      }
      
      
      myInstruction[container] = new Instruction(tempInstructions[0], tempInstructions[1], tempInstructions[2], tempInstructions[3], tempInstructions[4]);
      container++; //creates an object with each of the 5 values it got into the array
   }
   public Instruction find(int state, int value) {
      for (int i = 0; i < myInstruction.length; i++) {
         if (myInstruction[i].equals(state, value)) {  // return the 3 values
            return myInstruction[i];
         }
      }
      return null; //if you reach here, throw an error
   }
}