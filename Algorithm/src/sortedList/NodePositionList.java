package sortedList;

import java.util.Iterator;

public class NodePositionList<E> implements PositionList<E> {
	protected int numElts;            
	protected DNode<E> header, trailer;   
	public NodePositionList() 
	{
	    numElts = 0;
	    header = new DNode<E>(null, null, null);	  
	    trailer = new DNode<E>(header, null, null);	
	    header.setNext(trailer);	
	}

	protected DNode<E> checkPosition(Position<E> p)
			throws Exception {
		if (p == null)
			throw new Exception
		          ("Null position passed to NodeList");
		if (p == header)
			throw new Exception
		          ("The header node is not a valid position");
	    if (p == trailer)
	    	throw new Exception
		          ("The trailer node is not a valid position");
	    try 
	    {
	    	DNode<E> temp = (DNode<E>) p;
	    	if ((temp.getPrev() == null) || (temp.getNext() == null))
	    		throw new Exception
	    		("Position does not belong to a valid NodeList");
	    	return temp;
	    }
	    catch (Exception e) 
	    {
	    	throw new Exception
		         	("Position is of wrong type for this list");
	    }
	}
	  
	
	public int size() { return numElts; }

	public boolean isEmpty() { return (numElts == 0); }
	
	public Position<E> first() throws Exception 
	{
	    if (isEmpty())
	    	throw new Exception("List is empty");
	    return header.getNext();
	}
	
	public Position<E> last() throws Exception
	{
		if (isEmpty())
			throw new Exception("List is empty");
		return trailer.getPrev();
	}
	  
	  
	public Position<E> prev(Position<E> p)	throws Exception
	{
		DNode<E> v = checkPosition(p);
	    DNode<E> prev = v.getPrev();
	    if (prev == header)
	    	throw new Exception
	    	("Cannot advance past the beginning of the list");
	    return prev;
	}
	  
	public Position<E> next(Position<E> p) throws Exception
	{
		DNode<E> v = checkPosition(p);
		DNode<E> next = v.getNext();
		if(next == trailer)
			throw new Exception
			("Cannot advance past the final of the list");
		return next;
		
	}

	 
	public void addFirst(E element) {
		numElts++;
	    DNode<E> newNode = new DNode<E>(header, header.getNext(), element);
	    header.getNext().setPrev(newNode);
	    header.setNext(newNode);
	}
	
	public void addLast(E e) {
		numElts++;
		DNode<E> newNode = new DNode<E>(trailer.getPrev(), trailer, e);
		trailer.getPrev().setNext(newNode);
		trailer.setPrev(newNode);
	}
	
	public E remove(Position<E> p)
			throws Exception {
		DNode<E> v = checkPosition(p);
		numElts--;
	    DNode<E> vPrev = v.getPrev();
	    DNode<E> vNext = v.getNext();
	    vPrev.setNext(vNext);
	    vNext.setPrev(vPrev);
	    E vElem = v.element();
	    // unlink the position from the list and make it invalid
	    v.setNext(null);
	    v.setPrev(null);
	    return vElem;
	}
		
	public void addAfter(DNode<E> p, E e) {
		DNode<E> newNode = new DNode<E>(null,null,null);
		newNode.setElement(e);
		newNode.setPrev(p);
		newNode.setNext(p.getNext());
		p.getNext().setPrev(newNode);
		p.setNext(newNode);
		numElts++;
	}

	
	public void addBefore(DNode<E> p, E e) {
		DNode<E> newNode = new DNode<E>(null,null,null);
		newNode.setElement(e);
		newNode.setNext(p);
		newNode.setPrev(p.getPrev());
		p.getPrev().setNext(newNode);
		p.setPrev(newNode);
		numElts++;
	}

	 
	public E set(Position<E> p, E element)
			throws Exception {
		DNode<E> v = checkPosition(p);
	    E oldElt = v.element();
	    v.setElement(element);
	    return oldElt;
	}

	@Override
	public Iterable<Position<E>> positions() throws Exception {
		PositionList<Position<E>> P = new NodePositionList<Position<E>>();
		if(!isEmpty())
		{
			Position<E> p = first();
			while(true)
			{
				P.addLast(p);
				if(p == last())
					break;
				p = next(p);
			}			
		}
		return P;
	}

	
	public Iterator<E> iterator() {
		return new ElementIterator<E>(this);	
	}
}
