//ALEXANDRA DAISY PRIEDE
//18 MARCH 2018
//HW6

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class HW6Test {
   public static void main(String[] args) {
      Comparator<String> comp = (s1,s2)->s1.compareTo(s2);
      
      Collection<String> c1 = new TreeSet<>(comp);
      c1.addAll(Arrays.asList("a", "c", "d", "e", "g", "h", "j"));
      Collection<String> c2 = new TreeSet<>(comp);
      c2.addAll(Arrays.asList("b", "f", "m", "n", "p"));
      
      Collection<String> c3 = new MergedCollection(c1, c2, comp);
      c3.forEach(s->System.out.print(s + " ")); 
      System.out.println();
      
      //Generate random number 0 - 100 and sort 
      Comparator<Integer> comp2 = (s1,s2)->s2.compareTo(s1);
      Collection<Integer> c4 = new TreeSet(comp2);
      Collection<Integer> c5 = new TreeSet(comp2); 
      
      for(int i = 0; i < 11; i++) {
    	  	Random rand = new Random();
    	  	c4.add(rand.nextInt(100));
    	  	c5.add(rand.nextInt(100));
      }
      
      Collection<Integer> c6 = new MergedCollection(c4, c5, comp2);
      for(Integer s : c6) 
          System.out.print(s + " ");
       System.out.println();
       
      c6.forEach(s->System.out.print(s + " ")); 
      System.out.println();

      Predicate<Integer> isEven = new Predicate<Integer>() {
  	    public boolean test(Integer number) {
  	    		return (number % 2) == 0;
  	  }};
  	  System.out.println("There are " + howMany(c6, isEven) + " even values.");

  	  CountReducer cr = new CountReducer(isEven); 
  	  for(Integer s : c6){
  		  cr.accept(s);
  	  }
  	  System.out.println("There are " + cr.result() + " even values.");
   }
   
   //implement as for each
   public static <T> int howMany(Iterable<T> c,
           Predicate<T> pred) {
	   
	   int count = 0; 

	   Iterator<T> iter = c.iterator();
	   for(T t : c) {
		   if(pred.test((iter.next()))) {
			   count++; 
		   }
	   }
//	   while(iter.hasNext()) {
//		   if(pred.test((iter.next()))) {
//			   count++; 
//		   }
//	   }
	   return count;
   }
   
}
