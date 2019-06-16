import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;

public class SimpleHW9Test {
	
	public static void main(String[] args) {
		Polynomial x = new Variable("x");
		Polynomial y = new Variable("y");
		Polynomial three = new Number(3);
		Polynomial xPlusThree = new PlusOp(x,three);
		Polynomial xx = new PlusOp(xPlusThree, x); 

		Map<String, Integer> m = new HashMap<String, Integer>(); 
		m.put("x", 3);
		System.out.println(xx.toString());
		System.out.println(xx.evaluate(m));

	}
 
	public static Set<Variable> getVarsExternal(Polynomial p){
		Iterator<Polynomial> i = p.childIterator(); 
		Set<Variable> s = new HashSet(); 
		
		if( p instanceof Variable ) {
			Variable a = new Variable(p.toString()); 
			s.add(a);
			return s; 
		}
		
		if(!i.hasNext()) {
			return s; 
		}
		
		while(i.hasNext()) {
			Polynomial j = i.next(); 
			System.out.println(j);
			if(j instanceof Variable ) {
				s.add((Variable) j); 
			}
			return getVarsExternal(j);
		}
		return s; 
	}

	public static Set<Variable> getVarsInternal(Polynomial p){
		Set<Variable> s = new HashSet(); 
		 Consumer<Polynomial> action =
                 v -> s.add((Variable) v);
		p.forEach(action);
		return s; 
	}
	
	public void testcase() {
//		((x * 1) + 3) * ((y + 0) + (z * 0))
//		((x + 3) * y) + ((z + x) – (x + z))
		
//		That code creates an object corresponding 
//		to the polynomial (x+3)*y and prints it.
	}
}
