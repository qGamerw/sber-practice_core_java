package Generics1;

import java.util.*;

public interface Collection<E> extends java.lang.Iterable<Object> {
    int size();
    boolean isEmptry();
    boolean contains(E item);
    boolean add(E item);
    boolean remove(E item);
    void clear();

    Iterator<Object> iterator();
}
