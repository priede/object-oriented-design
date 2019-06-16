import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;

public interface Polynomial {
       String toString();
       boolean equals(Object obj);
       boolean hasNoVariables();
       int evaluate(Map<String,Integer> m);
       Polynomial reduce();
       Iterator<Polynomial> childIterator();
       
       default void forEach(Consumer<Polynomial> c) { 
    	   		c.accept(this);
    	   		if( this instanceof Polynomial ) {
    	   			Polynomial p = (Polynomial) this; 
    	   			Iterator<Polynomial> i = p.childIterator(); 
    	   			while(i.hasNext()) {
    	   				Polynomial child = i.next();
    	   				child.forEach(c);
    	   			}
    	   		}
       }
}
