//ALEXANDRA DAISY PRIEDE
//18 MARCH 2018
//HW6

import java.util.function.Predicate;

public class CountReducer<T> implements Reducer {
	Predicate<T> p;
	int count = 0; 
	
	public CountReducer(Predicate<T> p) {
		this.p = p;
	}

	public void accept(Object t) {
		if(p.test((T) t)) {
			count++;
		}
	}

	public Object result() {
		return count;
	}

}
