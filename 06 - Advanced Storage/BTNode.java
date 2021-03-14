public class BTNode {
    Object item;
    BTNode left, right;
    
    public BTNode(Object element) {
        item = element;
        left = null;
        right = null;
    }
    
    public Object getItem() {
        return item;
    }
    
    public BTNode getLeft() {
        return left;
    }
    
    public BTNode getRight() {
        return right;
    }
    
    public void setItem(Object element) {
        item = element;
    }
    
    public void setLeft(BTNode newGal) {
        left = newGal;
    }
    
    public void setRight(BTNode newGal) {
        right = newGal;
    }
}