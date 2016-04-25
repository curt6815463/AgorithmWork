package sortedList;



public class FavoriteList<E> 
{
	protected PositionList<Entry<E>> fList;
	public FavoriteList() {fList = new NodePositionList<Entry<E>>();}
	public int size(){return fList.size();}
	public boolean isEmpty(){return fList.isEmpty();}
	
	
	public void remove(E obj) throws Exception {
		Position<Entry<E>> p = find(obj);	
		if (p != null) fList.remove(p);       
	}
	

	
	public void addElement(E item)
	{
		fList.addLast(new Entry<E>(item));
	}
	public void access(E obj) throws Exception {
		Position<Entry<E>> p = find(obj);	
		if (p != null)
			p.element().incrementCount();	
		else {
			fList.addLast(new Entry<E>(obj));	
			p = fList.last();
		}
		moveUp(p); 		
	}
	protected Position<Entry<E>> find(E obj) throws Exception {
	    for (Position<Entry<E>> p: fList.positions())
	    	if (value(p).equals(obj)) 
	    		return p;	// fount at position p
	    return null;	// not found
	 }
	
	protected void moveUp(Position<Entry<E>> cur) throws Exception {
	    Entry<E> e = cur.element();
	    int c = count(cur);
	    while (cur != fList.first()) {
	      Position<Entry<E>> prev = fList.prev(cur);	// previous position
	      if (c <=  count(prev)) break;	// entry is at correct position
	      fList.set(cur, prev.element());	// move down previous entry
	      cur = prev;
	    }
	    fList.set(cur, e);	// store the entry in its final position
	}
	
	  public Iterable<E> top(int k) {
		    if (k < 0 || k > size())
		    	throw new IllegalArgumentException("Invalid argument");
		    PositionList<E> T = new NodePositionList<E>(); // top-k list
		    int i = 0;	// counter of the entries added to the list
		    for (Entry<E> e: fList) {
		    	if (i++ >= k)
		    		break;		// all the k entries have been added
		    	T.addLast(e.value());	// add one entry to the list
		    }
		    return T;
	  }

	
	
	
	public String toString(){return fList.toString();}
	protected E value(Position<Entry<E>> p) throws Exception{return (p.element()).value();}
	protected int count(Position<Entry<E>> p) throws Exception {return (p.element()).count();}
	
	
	protected static class Entry<E>
	{
		private E value;
		private int count;
		
		Entry(E v){count = 1 ; value = v;}
		public E value(){return value;}
		public int count(){return count;}
		public int incrementCount(){return ++count;}
		public String toString(){return "["+count+","+value+"]";}
		
	}
	
	
	
}
