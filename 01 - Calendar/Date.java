/**
CSIS 251 Principles of Programming I
Fall 2017

Project (pr4) Date and ExtendedDate classes using inheritance
A class to store a date.

@author Alexander Meyers
@date Nov. 16, 2017
*/

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.util.Scanner;

public class Date {

   /**
   Initializing the private variables, month, day, and  year
   */
   protected int month;
   protected int day;
   protected int year;
    
   /**
   returns true if the year argument is a leap year, otherwise returns false
   @param, an int yyyy used as a year
   */
   private boolean isLeapYear(int yyyy){
      boolean leapYear = ((yyyy % 4 == 0) && (yyyy % 100 != 0) || (yyyy % 400 == 0));
      return leapYear;
   }
   
   /**
   Returns the number of days in each month for the specified year, it will throw an IllegalArgumentException if the month is invalid.
   @param: mm is the corresponding integer for the month, yyyy is the integer for the year
   */
   private int daysInMonth(int mm, int yyyy) throws IllegalArgumentException {
      switch (mm){
         case 1:
         case 3:
         case 5:
         case 7:
         case 8:
         case 10:
         case 12:
            return 31;
         case 4:
         case 6:
         case 9:
         case 11:
            return 30;
         case 2:
            if(isLeapYear(yyyy)){
               return 29;
            } else {
               return 28;
            }
        default:
            throw new IllegalArgumentException(); 
        }
   }
   
   /**
   Returns true if the given date is valid, false if it is invalid. For a date to be valid, the month must be greater than 0 and less that 13. For the day to be valid, it must be
   greater than 0 and less than or equal to the number of days in the month. For the year to be valid it must be greater than or equal to 1500 and less than or equal to 3000. If
   the month, day, and year are all valid, it is a valid date, and the function will return true.
   @param: int mm is the corresponding number to the month, int dd is the integer for the day, and int yyyy is the integer for the year.
   @return: false if invalid date, true if valid date
   */
   private boolean isValidDate(int mm, int dd, int yyyy) {
      if((mm > 0) && (mm <= 12) && (dd > 0) && (dd <= daysInMonth(mm, yyyy)) && (yyyy >= 1500) && (yyyy <= 3000)) {
         return true;
      } else {
         return false;
      }   
   }

   /**
   Default constructor, intitializes month to 1, day to 1, and year to 1500.
   */
   public Date() {
      month = 1;
      day = 1;
      year = 1500;
   }

   /**
   Constructor initializes the parameter mm to the month, the parameter dd to the day, and the parameter yyyy to the year. It uses the function setDate to acomplish this
   @param: int mm is the corresponding number to the month, int dd is the integer for the day, and int yyyy is the integer for the year.
   */
   public Date(int mm, int dd, int yyyy) {
      setDate(mm, dd, yyyy);
   }
   
   /**
   This function sets the variables to whatever is put in the parameters. It also checks if the date given is a valid date using the isValidDate function, otherwise it will
   throw an IllegalArgumentException.
   @param: int mm is the corresponding number to the month, int dd is the integer for the day, and int yyyy is the integer for the year.
   */
   public void setDate(int mm, int dd, int yyyy) {
      if (isValidDate(mm, dd, yyyy)) {
         month = mm;
         day = dd;
         year = yyyy;
      } else {
         throw new IllegalArgumentException("Invalid date");
      }
   }

   
   /**
   Gets the month when called
   @return month
   */
   public int getMonth() {
      return month;
   }

   /**
   Gets the day when called
   @return day 
   */
   public int getDay() {
        return day;
   }
   
   /**
   Gets the year when called
   @return year 
   */
   public int getYear() {
      return year;
   }

   /**
   Returns the date in mm/dd/yyyy format
   @return date in a string format
   */
   public String toString() {
      return (getMonth() + "/" + getDay() + "/" + getYear());
   }
   
   /**
   Checks to see if it is a leap year using the private isLeapYear funciton
   @return true if it is a leap year, false if it isn't a leap year 
   */
   public boolean isLeapYear() {
      return isLeapYear(getYear()); 
   }
   
   /**
   Gets the number of days in the current month and year. it uses the private daysInMonth function to acomplish this
   @return the number of days in the month 
   */
   public int daysInMonth() {
      return daysInMonth(getMonth(), getYear());
   }
   
   /**
   It counts up all the days of the months that have passed so far, and adds the current days of the month to that variable. It then returns this number
   @return the number of days that has passed so far in the year 
   */
   public int daysPassedThisYear() {
      int currentMonth = getMonth();
      int counter = 0;
      for (int i = 1; i < currentMonth; i++) {
         counter = counter + daysInMonth(i, getYear());
      }
      return counter + getDay();
   }
   
   /**
   It starts at the total number of days in the year (366 if leap year) and it counts backwards to the current date. It keeps track of how many days this is, and returns that number
   @return the number of days remaining in the year 
   */
   public int daysRemainingThisYear() {
      int currentMonth = getMonth();
      int counter = 0;
      if(isLeapYear(getYear())) {
         counter = 366;
      } else {
         counter = 365;
      }
      for (int i = 1; i < currentMonth; i++) {
         counter = counter - daysInMonth(i, getYear());
      }
      return counter - getDay();
   }
   
   /**
   This function adds "int days" to the current date, incrementing the month and year where appropriate, and returning the new date as a new date object
   @param "int days" the number of days you wish to add to the current date
   @return a new date "int days" after the current date 
   */
   public Date addDays(int days) {
      int day = getDay()+days;
      int month = getMonth();
      int year = getYear();
      while(day > daysInMonth(month, year)) {
         day = day - daysInMonth(month, year);
         month = month + 1;
         if(month == 13) {
            year = year + 1;
            month = 1;
         }
      }
      return new Date(month, day, year);
   }
 
    /**
    This is a copy constructor, taking the current date and making a copied object out of it
    @param date, the current date object 
    */
    public Date(Date date) {
      month = date.getMonth();
      day = date.getDay();
      year = date.getYear();
   }
   
   /**
   This method takes a string and adds .date to the end. It adds "Date" to the first line of
   file that is created. It adds the date as a string to the second line then flushes and closes
   the file. 
   @param a String named fileName.
   */   
   public void save(String fileName)throws IOException {
      String textFile = (fileName + ".date");
      FileOutputStream fileByteStream = null;
      PrintWriter outFS = null;
      fileByteStream = new FileOutputStream(textFile);
      outFS = new PrintWriter(fileByteStream);
      outFS.println("Date");
      outFS.println(toString());
      outFS.flush();
      fileByteStream.close();  
   }
   
   /**
   This method takes the String fileName and adds .date to the end. It opens the file
   It reads the first line of the file, and if the first line is "Date", it will create and 
   return new date object from the String on line 2.
   @return a new date object
   @param a String named fileName.
   */
   public Date load(String fileName)throws IOException {
      String textFile = (fileName + ".date");
      FileInputStream fileByteStream = null; 
      fileByteStream = new FileInputStream(textFile);
      Scanner inFS = new Scanner(fileByteStream);
      String line1 = inFS.nextLine();
      if(line1.equals("Date")){
         String [] date = inFS.nextLine().split("/");
         int month = Integer.parseInt(date[0]);
         int day = Integer.parseInt(date[1]);
         int year = Integer.parseInt(date[2]);
         return new Date(month, day, year);
      } else {
         throw new IOException("Could not load file");
      }
   }
}