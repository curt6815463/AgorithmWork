package sortedList;

import java.util.Iterator;

public class ElementIterator<E> implements Iterator<E>{
	protected PositionList<E> list = null; 
	protected Position<E> cursor = null; 

	public ElementIterator(PositionList<E> L) {	
		try {
			list = L;
			cursor = (list.isEmpty())? null : list.first();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean hasNext() { return (cursor != null);  }
	public E next(){
		E toReturn = null;
		try {
			toReturn = cursor.element();
			cursor = (cursor == list.last())? null : list.next(cursor);
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return toReturn;
	}

}
