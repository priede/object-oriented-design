//ALEXANDRA DAISY PRIEDE
//18 MARCH 2018
//HW6

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MergedIterator<T> implements Iterator{
	private Iterator<T> i1;
	private Iterator<T> i2;
	private Comparator<T> comp;
	
	private T current1;
	private T current2; 
	
	public MergedIterator(Iterator<T> i1, Iterator<T> i2, Comparator<T> comp) {
		this.i1 = i1;
		this.i2 = i2; 
		current1 = i1.next();
		current2 = i2.next();
		this.comp = comp;
	}

	public boolean hasNext() {
		while(i1.hasNext() || i2.hasNext()) {
			return true; 
		}
		return false;
	}
	
	public T next() {	
		T f; 
		if(current1 == null) {
			if(i2.hasNext()) {
				current2 = i2.next(); 
			}
			f = current2; 
			return f; 
		}
		if(current2 == null) {
			if(i1.hasNext()) {
				current1 = i1.next(); 
			}
			f = current1; 
			return f; 
		}
		if(isBigger(current1, current2)) {
			f = current1; 
			try{
				current1 = i1.next();
			}catch(NoSuchElementException e) {
				current1 = null;
				return current2; 
			}
		}
		else {
			f = current2; 
			try{
				current2 = i2.next();
			}catch(NoSuchElementException e) {
				current2 = null;
				return current1; 
			}
		}
		return f; 
	}
	
	private Boolean isBigger(T one, T two) {
		if ( comp.compare(one, two) > 0 ) {
				return false;
		} 
		return true; 
	}
}
