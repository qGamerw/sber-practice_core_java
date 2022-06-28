package Collections1;

import java.util.*;

public class ListIterator implements Iterator<Object>{
    private List arr;
    private int index;

    public ListIterator(List arr){
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
    public Object next() {
        if (hasNext()) {
            index++;
            return arr.get(index - 1);
        } else {
            throw new NoSuchElementException("Not element in ArrayList");
        }
    }
    
}
