/** Creates and compares different ranges
 *  @author     Simon Spivey
 *  @id         
 *  @course     CSIS 252: Programming II
 *  @assignment Storage Lab
 *  @related    
 */
public class Range {

    Object currRange;
    int range;
    double decimal;;
    // creates a Range Object using an int @param and converts it so 
    // that 1-5 is 1 and 6-10 is 2 and so on
    public Range(int element) {
        decimal = Math.ceil((double)element/5.0);
        range = (int)Math.round(decimal);
        currRange = (Object) range;
    }
    // returns the range as an int
    public int asInt() {
        return range;
    }
    // checks to see if our range object has already occured
    public boolean equals(Object object) {
        return (((Range)object).range == this.range);
    }
}