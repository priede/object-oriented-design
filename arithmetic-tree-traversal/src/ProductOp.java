import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class ProductOp implements Polynomial{
	String full; 
	Polynomial one; 
	Polynomial two; 
	
	public ProductOp(Polynomial v, Polynomial n) {
		this.full = "(" + v.toString() + " * " + n.toString() + ")"; 
		this.one = v; 
		this.two = n; 
	}
	
	public boolean hasNoVariables() {
		if(one instanceof Variable || two instanceof Variable) {
			return false; 
		}
		return true; 
	}

	public int evaluate(Map<String, Integer> m) {
		int result = 0; 
		Iterator<Polynomial> onei = one.childIterator(); 
		Iterator<Polynomial> twoi = two.childIterator();
		
		while(onei.hasNext()) {
			result = (onei.next().evaluate(m)) * result; 
		}
		while(twoi.hasNext()) {
			result = (twoi.next().evaluate(m)) * result; 
		}
		
		if(m.containsKey(one.toString())) {
			result = m.get(one.toString()) + result;
			result = result * Integer.parseInt(two.toString());
		}
		else if (m.containsKey(one.toString())) {
			result = m.get(two) + result;
			result = result * Integer.parseInt(one.toString());
		}
		else if(two.hasNoVariables()) {
			result = result * Integer.parseInt(two.toString()); 
		}
		else if(one.hasNoVariables()) {
			result = result * Integer.parseInt(one.toString()); 
		}

		return result;
	}

	public Polynomial reduce() {
		Polynomial n = null; 
		Polynomial m = null; 
		Iterator<Polynomial> onei = one.childIterator(); 
		Iterator<Polynomial> twoi = two.childIterator(); 
		
		//VARIABLE EQUALITY PROPERTY 
		
		if(one.hasNoVariables() && two.hasNoVariables() && !onei.hasNext() && !twoi.hasNext()) {
			int res = Integer.parseInt(one.toString()) + Integer.parseInt(two.toString()); 
			n = new Number(res); 
			return n; 
		}
		else {
			//ZERO CONDITION PROPERTY 
			Polynomial zero = new Number(0);
			
			if(one.equals(zero)) {
				n = two; 
			}
			if(two.equals(zero)) {
				n = one; 
			}
			
			while(onei.hasNext()) {
				m = onei.next().reduce(); 
				n = new PlusOp(m, two);
				n = n.reduce();
			}
			while(twoi.hasNext()) {
				m = twoi.next().reduce(); 
				n = new PlusOp(one, m);
				n = n.reduce();
			}
		}
		
		if(n == null) {
			n = new ProductOp(one,two); 
		}
		
		return n;
	}
	
	public boolean equals(Object obj) {
		boolean res = false; 
		if(obj instanceof Polynomial ) {
			if(obj.toString().equals(full.toString())) {
				return true;
			}
			
			ArrayList<Character> chars = new ArrayList<Character>();
			for (char c : full.toCharArray()) {
			  chars.add(c);
			}
			
			for(char i : obj.toString().toCharArray()) {
				if(!chars.contains(i)) {
					res = false; 
				}
				else {
					res = true; 
				}
			}
		}
		return res; 
	}

	public String toString() {
		return full.toString();
	}

	public Iterator<Polynomial> childIterator() {
		ArrayList<Polynomial> ss = new ArrayList<Polynomial>();
		
//		Polynomial f = new ProductOp(one, two); 
//		ss.add(f);
		ss.add(one);
		ss.add(two);

	    return new Iterator<Polynomial>() {
			int pos = -1;
	        public boolean hasNext() { 
	            return pos < ss.size()-1;	        
	        }
	        public Polynomial next() {
	        		pos++; 
	        		return ss.get(pos); 
	        }
	    };
	}
}
