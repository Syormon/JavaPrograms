/** Creates an unsorted list for storing data
 *  @author     Simon Spivey
 *  @id         
 *  @course     CSIS 252: Programming II
 *  @assignment Storage Lab
 *  @related    
 */

public class UnsortedList implements ListInterface{
    //instance variables
    protected int numElements;
    protected boolean found;
    protected LLNode location;
    protected LLNode list;
    protected LLNode previous;
    protected Range currRange;
    protected int compareCounter;
    
    //constructor
    public UnsortedList() {
        list = null;
    }
    
    //methods
    
    /** Adds a range node to list 
      * @param Object element, adds the given element to list of type Object 
      * @return void
      */
    public void add(Object element) {
        LLNode newNode = new LLNode (element);
        newNode.setLink(list);
        list = newNode;
        numElements++;
    }
    
    /** Searches through list to find element, sets found to true if element is found
      * @param Object element, finds the given element in list  
      * @return void
      */
    public boolean find(Object element) {
        location = list;
        compareCounter = 0;
        while (location != null) {
            compareCounter++; //adding to compare
            if (element.equals(location.getItem())) {
                return true;
            }
            else {
                previous = location;
                location = location.getLink();
            }
        }
        return false;
    }
    public int returnCompare() {
        return compareCounter;
    }
}
