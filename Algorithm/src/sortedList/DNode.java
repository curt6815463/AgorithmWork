package sortedList;

public class DNode<E> implements Position<E> {
	private DNode<E> prev, next;	// References to the nodes before and after
	private E element;	// Element stored in this position
	/** Constructor */
	public DNode(DNode<E> newPrev, DNode<E> newNext, E elem) {
	    prev = newPrev;
	    next = newNext;
	    element = elem;
	}
	  // Method from interface Position
	  public E element() throws Exception{
	    if ((prev == null) && (next == null))
	    {
	    	throw new Exception();
	    }
	    	
	    return element;
	  }
	  // Access methods
	  public DNode<E> getNext() { return next; }
	  public DNode<E> getPrev() { return prev; }
	  // Update methods
	  public void setNext(DNode<E> newNext) { next = newNext; }
	  public void setPrev(DNode<E> newPrev) { prev = newPrev; }
	  public void setElement(E newElement) { element = newElement; }
}


