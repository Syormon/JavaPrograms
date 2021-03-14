import java.io.IOException;
public class Lab1 {
   public static void main(String[] args) throws IOException {
      Turing machine; //instantiate machine of type Turing
      
      machine = new Turing(args); //initalize machine
      
      machine.run(); //run method 
      machine.answer(); //final output
   }
}