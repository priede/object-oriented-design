import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class Variable implements Polynomial {
	String s; 
	
	public Variable(String s) {
		this.s = s; 
	}

	public boolean hasNoVariables() {
		return false;
	}

	public int evaluate(Map<String, Integer> m) {
		if(m.containsKey(s)) {
			return m.get(s);
		}
		else {
			throw new IllegalArgumentException(); 
		}
	}

	public Polynomial reduce() {
		Polynomial v = new Variable(s); 
		return v;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Polynomial ) {
			if(obj.toString().equals(s.toString())) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return s.toString();
	}

	public Iterator<Polynomial> childIterator() {
	    return new Iterator<Polynomial>() {
	        public boolean hasNext() { 
	            return false;
	        }
	        public Polynomial next() {
	            throw new NoSuchElementException();
	        }
	    };
	}
}
