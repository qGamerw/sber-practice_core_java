package Generics1;

import java.util.*;

public class ListIterator<E> implements Iterator<Object>{
    private List<E> arr;
    private int index;

    public ListIterator(List<E> arr){
        this.arr = arr;
        this.index = 0;
    }
    @Override
    public boolean hasNext() {
        if (index + 1 <= arr.size()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public E next() {
        if (hasNext()) {
            index++;
            return arr.get(index - 1);
        } else {
            throw new NoSuchElementException("Not element in ArrayList");
        }
    }
    
}
