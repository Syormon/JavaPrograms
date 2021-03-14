/** Manages nodes in a linked list
 *  @author     Simon Spivey
 *  @id         
 *  @course     CSIS 252: Programming II
 *  @assignment Advanced Storage Lab
 *  @related    
 */

public class LLNode {
    //instance variables
    Object item;
    LLNode link;
    
    //constructor
    public LLNode(Object newItem) {
        item = newItem;
        link = null;
    }
    
    //methods
    
    /** Returns info of current node 
      * @param none
      * @return Object item, info of current node
      */
    public Object getItem() {
        return item;
    }
    
    /** Returns link of current node
      * @param none 
      * @return LLNode link, link of current node
      */
    public LLNode getLink() {
        return link;
    }
    
    /** Sets the new item to current item 
      * @param Object newItem, new info to be set on node  
      * @return void
      */
    public void setItem(Object newItem) {
        item = newItem;
    }
    
    /** Sets the link of current node
      * @param LLNode newLink, the link to be set on node 
      * @return void
      */
    public void setLink(LLNode newLink) {
        link = newLink;
    }
}
