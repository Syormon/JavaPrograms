/** This interface is used to define classes to do I/O for the CSIS 252 class
  * All projects should do all I/O (except error reporting) via classes that
  * implement this interface.  Classes may do more depending on the demands
  *  @author     Cathy Bareiss
  *  @id         cbareiss
  *  @course     CSIS 252: Programming II
  *  @assignment class demonstration
  *  @related    any class that implements it
  */
public interface IOInterface {
    public boolean hasNext(); // informs if there is more input
    public String nextLine(); // gets the entire next line, returning a string
    public String next();     // gets the next "word", returning a string
    public void println(String str);  // outputs the string and a <cr>
    public void print(String str);    // outputs a string without a <cr>
}