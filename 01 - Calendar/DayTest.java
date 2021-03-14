import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

/**
FIXME - change the comments to indicate that you modified the code

DayTest - is a JUnit test suite for the Day class.
CSIS 251 Principles of Programming I
Part of semester project
Template code provided to students

@author Dr. Larry Vail
*/
public class DayTest {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {

   }

   @Test public void defaultConstructorTest() {
      Day day1;
      day1 = new Day(Day.SUN);
      Assert.assertEquals(Day.SUN, day1.toString());
   }

   @Test public void otherConstructorTest() {
      Day day1;
      day1 = new Day(Day.MON);
      Assert.assertEquals(Day.MON, day1.toString());
      day1 = new Day(Day.TUE);
      Assert.assertEquals(Day.TUE, day1.toString());
      day1 = new Day(Day.WED);
      Assert.assertEquals(Day.WED, day1.toString());
      day1 = new Day(Day.THU);
      Assert.assertEquals(Day.THU, day1.toString());
      day1 = new Day(Day.FRI);
      Assert.assertEquals(Day.FRI, day1.toString());

   }

   @Test public void setDayTest() {
      Day day1;
      day1 = new Day();
      day1.setDay(Day.FRI);
      Assert.assertEquals(Day.FRI, day1.toString());
      day1.setDay(Day.SAT);
      Assert.assertEquals(Day.SAT, day1.toString());
      day1.setDay(Day.MON);
      Assert.assertEquals(Day.MON, day1.toString());
      day1.setDay(Day.SUN);
      Assert.assertEquals(Day.SUN, day1.toString());
   }

   @Test public void getDayTest() {
      Day day1;
      day1 = new Day();
      day1.getDay();
      Assert.assertEquals(Day.SUN, day1.toString());
   }

   @Test public void nextDayTest() {
      Day day1;
      day1 = new Day();
      day1 = day1.nextDay();
      Assert.assertEquals(Day.MON, day1.toString());
      day1 = day1.nextDay();
      Assert.assertEquals(Day.TUE, day1.toString());
      day1 = day1.nextDay();
      day1 = day1.nextDay();
      Assert.assertEquals(Day.THU, day1.toString());
   }

   @Test public void previousDayTest() {
      Day day1;
      day1 = new Day();
      day1 = day1.previousDay();
      Assert.assertEquals(Day.SAT, day1.toString());
      day1 = day1.previousDay();
      Assert.assertEquals(Day.FRI, day1.toString());
      day1 = new Day(Day.WED);
      day1 = day1.previousDay();
      day1 = day1.previousDay();
      Assert.assertEquals(Day.MON, day1.toString());
   }

   @Test public void addDayTest() {
      Day day1;
      day1 = new Day();
      day1 = day1.addDays(1);
      Assert.assertEquals(Day.MON, day1.toString());
      day1 = day1.addDays(8);
      Assert.assertEquals(Day.TUE, day1.toString());
      day1 = new Day(Day.WED);
      day1 = day1.addDays(14);
      Assert.assertEquals(Day.WED, day1.toString());
   }
   @Test public void saveAndLoadTest() throws IOException {
	   Day day1;
	   Day day2;
      
	   day1 = new Day();
	   day1.save("test");
	   day2 = day1.load("test");
	   Assert.assertEquals(Day.SUN, day2.toString());
	   
	   day1 = new Day(Day.MON);
	   day1.save("test");
	   day2 = day1.load("test");
	   Assert.assertEquals(Day.MON, day2.toString());
	   
	   day1 = new Day(Day.TUE);
	   day1.save("test");
	   day2 = day1.load("test");
	   Assert.assertEquals(Day.TUE, day2.toString());
	   
	   day1 = new Day(Day.WED);
      day1.save("testy");
	   day2 = day1.load("testy");
	   Assert.assertEquals(Day.WED, day2.toString());
   }
   @Test (expected = IOException.class)public void saveIOExceptionTest() throws IOException {
      String fileName = "Meow?cat?%#@";
      Day day1 = new Day();
      day1.save(fileName);
         Assert.fail("File name \"Meow?cat?%#@\" should throw an exception.");
   }
   @Test (expected = IllegalArgumentException.class) public void setDayIllegalArgumentExceptionTest() throws IllegalArgumentException {
      Day day1;
      day1 = new Day();
      day1.setDay("zTest");
      Assert.fail("zTest should throw an exception");
   }
   @Test (expected = IllegalArgumentException.class) public void otherConstructorIllegalArgumentExceptionTest() throws IllegalArgumentException {
      Day day1;
      day1 = new Day("zTest");
      Assert.fail("zTest should throw an exception");
   }
   
   @Test (expected = IOException.class) public void loadIOExceptionTest() throws IOException {
      String fileName = "fileMissing";
      Day day1 = Day.load(fileName);
         Assert.fail(fileName + " should throw IOException, but did not.");
   }
}