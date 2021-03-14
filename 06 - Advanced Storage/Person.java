/** Creates and compares different people
 *  @author     Simon Spivey
 *  @id         
 *  @course     CSIS 252: Programming II
 *  @assignment Advanced Storage Lab
 *  @related    
 */
public class Person implements Comparable<Person> {

    //declaring local variables
    private String name, email;
    private int ssn;
    
    //constructor that makes the person object
    public Person(String name, int ssn, String email) {
        this.name = name;
        this.ssn = ssn;
        this.email = email;
    }

    //checks to see if a person is equal to the object given
    public boolean equals(Person object) {
        if ((this.name.equals(object.name)) &&
           (this.ssn == object.ssn) &&
           (this.email.equals(object.email))) {
           
           return true;
        }
        else {
            return false;
        }
    }
    // we compare People by just subtracting their ssns'
    public int compareTo(Person element) {
        return (this.ssn - element.ssn);
    }
}