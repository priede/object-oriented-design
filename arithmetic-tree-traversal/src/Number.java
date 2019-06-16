import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class Number implements Polynomial{
	Integer num; 
	
	public Number(Integer i) {
		this.num = i; 
	}
	
	public boolean hasNoVariables() {
		return true;
	}

	public int evaluate(Map<String, Integer> m) {
		return this.num;
	}

	public Polynomial reduce() {
		Polynomial n = new Number(this.num);
		return n;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Polynomial ) {
			if(obj.toString().equals(num.toString())) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		return num.toString();
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
