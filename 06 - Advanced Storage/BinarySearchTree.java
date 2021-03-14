/** Creates an sorted list for storing data
 *  @author     Simon Spivey
 *  @id         saspivey
 *  @course     CSIS 252: Programming II
 *  @assignment Advanced Storage Lab    
 */

public class BinarySearchTree implements ListInterface {
	BTNode root;
	private boolean found;
	private BTNode location;
    int compareCounter;
	
    //calls upon the recursive find method
	public boolean find(Object element) {
		found = false;
		location = root;
        compareCounter = 0;
		rec_find((Comparable)element, root);
        return found;
	}
	private void rec_find(Comparable element, BTNode curr) {
		location = curr;
        // set location equal to current node
        compareCounter++;
        // add one to cotuner
		if (location == null) {
        // if location equals null then break
			return;
		}
        // if our item is equal to element return true
		if (((Comparable)location.getItem()).equals(element)) {
			found = true;
			return;
		}
        // if item on our tree is greater than or equal to our 
        // element search the left tree
		if (((Comparable)location.getItem()).compareTo(element) >= 0) {
			rec_find(element, curr.getLeft());
		}
        // if not left, go right
		else {
			rec_find(element, curr.getRight());
		}
	}
    // calls upon the recursive add method
    public void add(Object element) {
        root = recAdd(element, root);
    }
    private BTNode recAdd(Object element, BTNode tree) {
        // if tree equals null make a new node
        if (tree == null) {
            tree = new BTNode(element);
        }
        // if our element is less than or equal to tree node we go left
        else if(((Comparable)element).compareTo(tree.getItem()) <= 0) {
            tree.setLeft(recAdd(element, tree.getLeft()));
        // if not left, go right
        } else {
            tree.setRight(recAdd(element, tree.getRight()));
        }
        // return our BTNode 
        return tree;
    }
    //return the # of compares it took to find      
    public int returnCompare() {
        return compareCounter;
    }
}