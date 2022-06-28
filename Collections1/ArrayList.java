package Collections1;

import java.util.*;

public class ArrayList implements List {

    private Object[] object;
    private int size;
    private int capacity;

    public ArrayList (){
        capacity = 10;
        object = new Object[capacity];
        size = 0;
    }

    public ArrayList (ArrayList list){
        object = list.getObject();
        capacity = list.getCapacity();
        size = list.size();
    }

    @Override
    public boolean isEmptry() {
        if (size == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object item) {
        for (Object element : object){
            if (item.equals(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(Object item) {
        if (size < capacity){
            object[size] = item;
        } else {
            Object[] object2 = copyList();
            object2[size] = item;
            object = object2;
            
        }
        size ++;
        return true;
    }

    @Override
    public boolean remove(Object item) {
        if (size == 0){
            return false;
        }
        int sizeLast = size;
        for (int i = 0; i < size; i++) {
            if (object[i].equals(item)){
                remove(i);
                remove(item);
                break;
            }
        }
        return (sizeLast != size);
    }

    @Override
    public void clear() {
        capacity = 10;
        object = new Object[capacity];
        size = 0;
    }

    @Override
    public void add(int index, Object item) {
        if (size == capacity){
            object = copyList();
        }
        if (index > size || index < 0){
            throw new IndexOutOfBoundsException();
        } else if (index == size){
            object[index] = item;
            size ++;
        } else {
            for (int i = size; i > index; i--) {
                object[i] = object[i-1];
            }
            object[index] = item;
            size ++;
        }
    }

    private Object[] copyList (){
        capacity = (capacity * 3) / 2 + 1;
        Object[] object2 = new Object[capacity];
        for (int i = 0; i < size; i++) {
            object2[i] = object[i];
        }
        return object2;
    }

    @Override
    public void set(int index, Object item) {
        if (index > size || index < 0){
            throw new IndexOutOfBoundsException();
        } else if (index == size) {
            add(item);
        } else {
            object[index] = item;
        }
        
    }

    @Override
    public Object get(int index) {
        if (index > size || index < 0){
            throw new IndexOutOfBoundsException();
        } else {
            return object[index];
        }
    }

    @Override
    public int indexOf(Object item) {
        for (int i = 0; i < size; i++) {
            if (object[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object item) {
        for (int i = size - 1; i >= 0; i--) {
            if (object[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Object remove(int index) {
        if (index > size || index < 0){
            throw new IndexOutOfBoundsException();
        } else {
            Object elment = object[index];
            for (int i = 0; i < size; i++) {
                object[i] = object[i+1];
            }
            size --;
            return elment;
        }
    }

    @Override
    public List subList(int from, int to) {
        if ((to > size || from < 0 || to < from || to < 0)){
            throw new IndexOutOfBoundsException();
        } else {
            ArrayList arrayList = new ArrayList();
            for (int i = from; i < to; i++) {
                arrayList.add(object[i]);
            }
            return arrayList;
        }
    }

    @Override
    public int size() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public Object[] getObject() {
        return object;
    }

    @Override
    public Iterator<Object> iterator() {
        return new ListIterator(this);
    }

}
