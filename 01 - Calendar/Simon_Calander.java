import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Calendar {
   ExtendedDate date;
   Day day;
   
   public Calendar() {
      date = new ExtendedDate();
      day = new Day("Mon");
   }
   public Calendar(int mm, int yyyy) {
      int Month = mm;
      int year = yyyy;
   }  
   public int getMonth() {
      return date.getMonth();
   }
   public int getYear() {
      return date.getYear();
   }
   
   public String getMonthYear() {
      return (getMonth() + " " + getYear());
   } 
   public Day getFirstDayOfMonth() {
      // nneed to figure out how many days are in between default constructor and current date
      // then use date.addDays() to figure out which day of the week the 1'st falls on
      // reverse method of Date.addDays?
   }
   public int getDaysInMonth() {
      return date.daysInMonth();
   }
   public void saveDate(int day, String fileName) throws IOException {
      String textFile = (fileName + ".date");
	   FileOutputStream fileByteStream = null;
	   PrintWriter outFS = null;
		fileByteStream = new FileOutputStream(textFile);
		outFS = new PrintWriter(fileByteStream);
		outFS.println("Calander");
		outFS.println(getFirstDayOfMonth());
		outFS.flush();
		fileByteStream.close();
   }
}