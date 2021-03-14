import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class ExtendedDateTest {


   @Before public void setUp() {
   }

   @Test
   public void defaultContructorTest(){
      ExtendedDate d = new ExtendedDate();
      Assert.assertEquals("January 1, 1500", d.toString());      
   }
   
   @Test
   public void otherContructorTest(){
      ExtendedDate d = new ExtendedDate(3, 24, 2015);
      Assert.assertEquals("March 24, 2015", d.toString());      
      d = new ExtendedDate(2, 28, 2017);
      Assert.assertEquals("February 28, 2017", d.toString());      
   }
   
   @Test (expected = IllegalArgumentException.class)
   public void otherConstructorIllegalArgumentExceptionTest() {
      ExtendedDate d = new ExtendedDate(2, 29, 2017);
      Assert.fail("Expected IllegalArgumentException for 2/29/2017, but did not.");
   }
   
   @Test
   public void copyContructorTest(){
      ExtendedDate d = new ExtendedDate(3, 24, 2015);
      ExtendedDate d2 = new ExtendedDate(d);
      Assert.assertEquals("March 24, 2015", d2.toString());      
   }
  
   @Test
   public void toStringLongTest(){
      ExtendedDate d = new ExtendedDate(3, 24, 2015);
      Assert.assertEquals("March 24, 2015", d.toStringLong());      
      d = new ExtendedDate(2, 28, 2017);
      Assert.assertEquals("February 28, 2017", d.toString());      
   }

   @Test
   public void toStringShortTest(){
      ExtendedDate d = new ExtendedDate(3, 24, 2015);
      Assert.assertEquals("3/24/2015", d.toStringShort());      
      d = new ExtendedDate(2, 28, 2017);
      Assert.assertEquals("2/28/2017", d.toStringShort());      
   }
   @Test
   public void toStringMonthYearTest(){
      ExtendedDate d = new ExtendedDate(3, 24, 2015);
      Assert.assertEquals("March 2015", d.toStringMonthYear());      
      d = new ExtendedDate(2, 28, 2017);
      Assert.assertEquals("February 2017", d.toStringMonthYear());      
   }
   @Test
   public void toStringTest(){
      ExtendedDate d = new ExtendedDate(3, 24, 2015);
      Assert.assertEquals("March 24, 2015", d.toString());      
      d = new ExtendedDate(2, 28, 2017);
      Assert.assertEquals("February 28, 2017", d.toString());      
   }          
}