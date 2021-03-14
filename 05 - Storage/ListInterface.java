/** This is the interface that sorted and unsortedlist will use
 *  as a tempelate. It makes each lab commandIO file easy to run.
 *  @author     Simon Spivey
 *  @id         saspivey
 *  @course     CSIS 252:  Programming II
 *  @assignment Simon Lab
 */

public interface ListInterface {
    int returnCompare();
    
    void add(Object element);
    
    boolean find (Object element);
    
}