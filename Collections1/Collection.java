package Collections1;

import java.util.*;

public interface Collection extends java.lang.Iterable<Object> {
    int size();
    boolean isEmptry();
    boolean contains(Object item);
    boolean add(Object item);
    boolean remove(Object item);
    void clear();

    Iterator<Object> iterator();
    
}
