/** This class is the direct translator from the robot to 
 *  the user. It instantiates the SensorPorts and then figures
 *  out what the user pressed. This class is basically for the 
 *  actual robot itself, and just passes the important information.
 *  @author     Simon Spivey
 *  @id         saspivey
 *  @course     CSIS 252:  Programming II
 *  @assignment Simon Lab
 */

import lejos.nxt.*;

public class RobotDevice implements RobotInterfaceII {
    //declaring the touchsensors.
    TouchSensor Red, Blue, Yellow, Green; 
    
    /*
    The constructor for the class, just instantiates the touchSenors.
    */
    
    public RobotDevice() {
        Red = new TouchSensor(SensorPort.S1);
        Green = new TouchSensor(SensorPort.S2);
        Blue = new TouchSensor(SensorPort.S3);
        Yellow = new TouchSensor(SensorPort.S4);
    }
    /*
    This method is to read the input of what button the user pressed on
    the robot. Its a little confusing so I'll walk you through it with the program
    line by line :)
    */
    public int getButton() {
        int n = 0;
        // Due to the nature of the robot, we first check to make sure each button is pressed down before procceding.
        while(Red.isPressed() && Blue.isPressed() && Yellow.isPressed() && Green.isPressed()) {} 
        // if all the buttons are pressed down, we precede to wait until one of the buttons is unpressed, and record it.
        if (!Red.isPressed()) {
            n = 1;
        }
        if (!Green.isPressed()) {
            n = 2;
        }
        if (!Blue.isPressed()) {
            n = 3;
        }
        if (!Yellow.isPressed()) {
            n = 4;
        }  
        // After a button has gone unpressed, we then wait for a single button to become unpressed so that we can then return our value
        while(!Red.isPressed() || !Blue.isPressed() || !Green.isPressed() || !Yellow.isPressed()) {} // while any button is unpressed
        return n;
    }
    /*
    This method displays to the user what they need to remember. It
    takes the answer queue as a @param and counter of how many elements
    are in the queue as a @param.
    */
    public void displayString(ArrayQueue1 queue, int counter) throws Exception {
        ArrayQueue1 tempqueue;
        tempqueue = new ArrayQueue1(queue);
        for (int i = 1; i <= counter; i++) {
            LCD.clear(); 
            LCD.drawString(("" + tempqueue.dequeue()), 0, 0);
            Thread.sleep(1000);
        }
    }
    /*
    This method isn't exactly finished, but it very simply just displays on 
    the LCD how many you got correct.
    */
    public void displayScore(int counter) {
        LCD.drawString(("You got " + counter + "correct."), 0, 0);
    }

}