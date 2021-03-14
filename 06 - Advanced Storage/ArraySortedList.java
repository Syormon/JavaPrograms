/** Creates an unsorted list for storing data
 *  @author     Simon Spivey
 *  @id         saspivey
 *  @course     CSIS 252: Programming II
 *  @assignment Advanced Storage Lab  
 */

public class ArraySortedList implements ListInterface {
    protected final int DEFCAP = 100; // default capacity
    protected int origCap;            // original capacity
    protected Object[] list;          // array to hold this list’s elements
    protected int numElements;        // number of elements in this list
    protected int currentPos;         // current position for iteration
    protected int compareCounter;

    // set by find method

    protected int location;   // indicates location of element if found

    public ArraySortedList() {
        list = new Object[DEFCAP];
        origCap = DEFCAP;
        numElements = 0;
    }

    public ArraySortedList(int origCap) {
        list = new Object[origCap];
        this.origCap = origCap;
        numElements = 0;
    }

    protected void enlarge()  {// Increments the capacity by an amount 
        // equal to the original capacity.
        // Create the larger array.
        Object[] larger;
      
        larger = new Object[list.length + origCap];
    
        // Copy the contents from the smaller array into the larger array.
        for (int i = 0; i < numElements; i++) {
            larger[i] = list[i];
        }
    
        // Reassign list reference.
        list = larger;
    }

    public boolean find(Object target) {
    // Searches list for an occurrence of an element e such that
    // target.equals(e). If successful, sets instance variables
    // found to true and location to the array index of e. If
    // not successful, sets found to false.
		int first = 0;
        compareCounter = 0;
		int last = numElements - 1;
		int compareResult;
		Comparable targetElement = (Comparable)target;
		
		while (first <= last) {
            compareCounter++;
			location = (first + last) / 2;
			compareResult = targetElement.compareTo(list[location]);
			if (compareResult == 0) {
				return true;
			}
			else if (compareResult < 0) {
				last = location - 1;
			}
			else {
				first = location + 1;
			}
		}
        return false;
	}

    public void add(Object element) {
        // Precondition:  element is Comparable.
        // Adds element to this list.
        Object listElement;
        int location = 0;
    	if (numElements == list.length) {
    		enlarge();
    	}
    	while (location < numElements) {
    		listElement = (Object)list[location];
    		if (((Comparable)listElement).compareTo(element) < 0) {
    			location++;
    		}
    		else {
    			break;
    		}
    	}
    	for (int index = numElements; index > location; index--) {
    		list[index] = list[index - 1];
    	}
    	list[location] = element;
    	numElements++;
    }
    //return the # of compares it took to find
    public int returnCompare() {
        return compareCounter;
    }
}