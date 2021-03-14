/** Creates an sorted list for storing data
 *  @author     Simon Spivey
 *  @id         saspivey
 *  @course     CSIS 252: Programming II
 *  @assignment Advanced Storage Lab    
 */

public class SortedList implements ListInterface {
    protected int numElements;
    protected boolean found;
    protected int currPos;
    protected LLNode location;
    protected LLNode list;
    protected LLNode previous;
    protected int compareCounter;
    
    //constructor
    public SortedList() {
        list = null;
    }
    
    //methods
    /** Searches through list to find element, sets found to true if element is found
      * @param Object element, finds the given element in list  
      * @return void
      */
    public boolean find(Object element) {
        location = list;
        compareCounter = 0;
        Comparable listElement;
        Comparable cElement;
        cElement = (Comparable)element;
        
        while (location != null) {
            listElement = (Comparable)location.getItem();
            compareCounter++; //adding to compare
            if (element.equals(location.getItem())) {
                return true;
            }
            //quit searching if we detect that the element is larger
            else if (listElement.compareTo(cElement) > 0) {
               location = null;
            }
            else {
                previous = location;
                location = location.getLink();
            }
        }
        return false;
    }

    /** Adds a range node to list 
      * @param Object element, adds the given element to list of type Object 
      * @return void
      */    
    public void add(Object element) {
    // Adds element to this list.
        LLNode prevLoc;        // trailing reference
        LLNode location;       // traveling reference
        Comparable listElement;   // current list element being compared      

        // Set up search for insertion point.
        location = list;
        prevLoc = null;
        while (location != null) {
		      listElement = (Comparable)location.getItem();
			   if (listElement.compareTo(element) < 0) {
				    prevLoc = location;
				    location = location.getLink();
			   }
			   else {
				    break;
			   }
		 }
		 LLNode newNode;
		 newNode = new LLNode(element);
		
		 if (prevLoc == null) {
			 newNode.setLink(list);
			 list = newNode;
		 }
		 else {
			newNode.setLink(location);
			prevLoc.setLink(newNode);
		 }
		 numElements++;
    }
    //return the # of compares it took to find
    public int returnCompare() {
        return compareCounter;
    }
}