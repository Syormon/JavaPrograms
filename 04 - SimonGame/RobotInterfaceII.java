/** This is the interface that IORobot and RobotDevice will use
 *  as a tempelate. It makes each lab commandIO file easy to run.
 *  @author     Simon Spivey
 *  @id         saspivey
 *  @course     CSIS 252:  Programming II
 *  @assignment Simon Lab
 */


public interface RobotInterfaceII {
   public int RED = 1; //Making some delcrations to define which color is what number
   public int GREEN = 2;
   public int BLUE = 3;
   public int YELLOW = 4; 
   // generically declare these methods. 
   // They will be further defined within each seperate class that extends this interface
   public int getButton();
   
   public void displayString(ArrayQueue1 queue, int couter) throws Exception;
   
   public void displayScore(int counter);
}