public class Tape {
   private int[] tapeValues;
   private int position, minPosition, maxPosition;
   private static final int MAX_SIZE = 32767;
   
   public Tape(String value) {
      position = MAX_SIZE/2; //set position
      minPosition = position;
      tapeValues = new int[MAX_SIZE]; // makin an array with MAX_SIZE amount of elements.
      String[] tempArray;
      tempArray = new String[tapeValues.length];
      int i;
      for (i = 0; i < value.length(); i++) {
         tempArray[i] = (Character.toString(value.charAt(i)));
         tapeValues[position + i] = Integer.parseInt(tempArray[i]); //takes the tape and puts it into our array
      }
      maxPosition = (position + (i - 1));
      position = tapeValues.length/2;
   }
   
   public int getCurValue() {
      return tapeValues[position];
   }
   public void setValue(int newValue) {
      tapeValues[position] = newValue;
   }
   private static int stateLogic(char choice) { //helper method that returns an int when given a char
      if (choice == '1') {
         return 1;
      } else if (choice == '0') {
         return 0;
      } else if (choice == ' ') {
         return -1;
      }
      return -1;    
   }
   public void move(int newposition) { //moves the tape in the right direction and then resets max and minposition
      position = position + newposition;
      if (position > maxPosition) {
         maxPosition = position;
      }
      if (position < minPosition) {
         minPosition = position;
      }
   }
   public String toString() {
      char temp;
      String tape = " ";
      for (int i = minPosition; i < maxPosition+1; i++) {
         temp = Character.forDigit(tapeValues[i], 10);
         tape = tape + temp;
      }
      return tape.trim();
   }
}