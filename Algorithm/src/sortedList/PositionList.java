package sortedList;

public interface PositionList<E> extends Iterable<E>{
	/** Returns the number of elements in this list. */
	public int size();
	/** Returns whether the list is empty. */
	public boolean isEmpty();
	/** Returns the first node in the list. 
	 * @throws Exception */
	public Position<E> first() throws Exception;
	/** Returns the last node in the list. 
	 * @throws Exception */
	public Position<E> last() throws Exception;
	/** Returns the node after a given node in the list. 
	 * @throws Exception */
	public Position<E> next(Position<E> p) throws Exception;
	/** Returns the node before a given node in the list. 
	 * @throws Exception */
	public Position<E> prev(Position<E> p) throws Exception;
	/** Inserts an element at the front of the list, returning new position. */
	public void addFirst(E e);
	/** Inserts and element at the back of the list, returning new position. */
	public void addLast(E e);
	/** Inserts an element after the given node in the list. */
	public void addAfter(DNode<E> p, E e);
	/** Inserts an element before the given node in the list. */
	public void addBefore(DNode<E> p, E e);
	/** Removes a node from the list, returning the element stored there. 
	 * @throws Exception */
	public E remove(Position<E> p) throws Exception;
	/** Replaces the element stored at the given node, returning old element. 
	 * @throws Exception */
	public E set(Position<E> p, E e) throws Exception;
	public Iterable<Position<E>> positions() throws Exception;

}
