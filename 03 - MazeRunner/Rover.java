import lejos.nxt.*;
/* The physical design of the robot makes it look 1 tile "ahead" 
** of its current position. 
** @author William Meitzler
*/
public class Rover{
     static final int DEGREES_PER_TILE = 230;
     static final int DEGREES_PER_TURN = 200;

     public Rover(){
          //Set speed to about half
          Motor.B.setSpeed(500);
          Motor.C.setSpeed(500);
          //Smooth acceleration for accuracy's sake
          Motor.B.setAcceleration(3000);
          Motor.C.setAcceleration(3000);
     }
     
     /* This method drives the robot forward by 1 tile
     ** it will end either braking the motors for a discrete stop
     ** or simply cutting power, allowing for another method call and
     ** smoother movement. 
     ** The method will return AFTER execution is complete
     */
     public void moveForward(boolean endWithBrake){
           
          Motor.B.rotate(DEGREES_PER_TILE, true);//Accesses Motor thread
          Motor.C.rotate(DEGREES_PER_TILE, true);
          while(Motor.B.isMoving() || Motor.C.isMoving())
               ;//wait for motors to be done
          return;
     }
     /* This method drives the robot backward by 1 tile
     ** it will end either braking the motors for a discrete stop
     ** or simply cutting power, allowing for another method call and
     ** smoother movement. 
     ** The method will return AFTER execution is complete
     */
     public void moveBackward(boolean endWithBrake){
           
          Motor.B.rotate(-1*DEGREES_PER_TILE, true);//Accesses Motor thread
          Motor.C.rotate(-1*DEGREES_PER_TILE, true);
          while(Motor.B.isMoving() || Motor.C.isMoving())
               ;//wait for motors to be done
          return;
     }
     /* These metods turn the robot 90 degrees LEFT 
     ** it will end either braking the motors for a discrete stop
     ** or simply cutting power, allowing for another method call and
     ** smoother movement. 
     ** The method will return AFTER execution is complete
     */
     public void turnRight(boolean endWithBrake){
          Motor.B.rotate(DEGREES_PER_TURN, true);//Accesses Motor thread
          Motor.C.rotate(-1*DEGREES_PER_TURN, true);
          while(Motor.B.isMoving() || Motor.C.isMoving())
               ;//wait for motors to be done
          return;
     }
     
     /* These metods turn the robot 90 degrees LEFT 
     ** it will end either braking the motors for a discrete stop
     ** or simply cutting power, allowing for another method call and
     ** smoother movement. 
     ** The method will return AFTER execution is complete
     */
     public void turnLeft(boolean endWithBrake){
          Motor.B.rotate(-1*DEGREES_PER_TURN, true);//Accesses Motor thread
          Motor.C.rotate(DEGREES_PER_TURN, true);
          while(Motor.B.isMoving() || Motor.C.isMoving())
               ;//wait for motors to be done
          return;
     } 
     
}