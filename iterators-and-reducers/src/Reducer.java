//ALEXANDRA DAISY PRIEDE
//18 MARCH 2018
//HW6

import java.util.function.Consumer;

public interface Reducer<T,R> extends Consumer<T> {
   R result();
}
