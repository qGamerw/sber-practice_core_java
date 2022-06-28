package Collections1;

import java.util.*;

public class LinkedList implements List, Deque {

    private Node begin;
    private Node end;
    private int size;

    public LinkedList () {
        begin = new Node();
        end = new Node();
        begin.next = end;
        end.prev = begin;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmptry() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object item) {
        Node node = begin.next;
        while (node.item != item){
            if (node.next == null){
                return false;
            }
            node = node.next;
        }
        return true;
    }

    @Override
    public boolean add(Object item) {
        addLast(item);
        return true;
    }

    @Override
    public boolean remove(Object item) {
        Node node = begin.next;
        while(node != null){
            if (node.item == item){
                deleteElement(node);
                return true;
            }
            node = node.next;
        }
        return false;
    }

    private Object deleteElement (Node node){
        Object resul = null;
        if (node.next != null && node.prev != null) {
            resul = node.item;
            node.next.prev = node.prev;
            node.prev.next = node.next;
        } else if (node.next == null) {
            resul = node.item;
            end.prev = node.prev;
            node.prev.next = end;
        } else if (node.prev == null) {
            resul = node.item;
            begin.next = node.next;
            node.next.prev = begin;
        }
        size--;
        return resul;
    }

    @Override
    public void clear() {
        Node node = begin.next;
        while (node != null) {
            deleteElement(node);
            node = node.next;
        }
    }

    @Override
    public void addFirst(Object item) {
        if (begin.next.equals(end)){
            Node node = new Node(item, end, begin);
            begin.next = node;
            end.prev = node;
        } else {
            Node node = new Node(item, begin.next, null);
            begin.next.prev = node;
            begin.next = node;
        }
        size ++;
    }

    @Override
    public void addLast(Object item) {
        if (end.prev.equals(begin)){
            Node node = new Node(item, end, begin);
            begin.next = node;
            end.prev = node;
        } else {
            Node node = new Node(item, null, end.prev);
            end.prev.next = node;
            end.prev = node;
        }
        size ++;
    }

    @Override
    public Object getFirst() throws NoSuchElementException {
        if (size == 0){
             throw new NoSuchElementException();
        }
        return begin.next.item;
    }

    @Override
    public Object getLast() throws NoSuchElementException {
        if (size == 0){
            throw new NoSuchElementException();
        }
        return end.prev.item;
    }

    @Override
    public Object pollFirst() {
        if (size == 0){
            return null;
        } else {
            Object element = begin.next.item;
            begin.next.prev = begin;
            begin.next = begin.next.next;
            size --;
            return element;
        }
    }

    @Override
    public Object pollLast() {
        if (size == 0){
            return null;
        } else {
            Object element = end.prev.item;
            end.prev.next = end;
            end.prev = end.prev.prev;
            size --;
            return element;
        }
    }

    @Override
    public Object removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            Object element = begin.next.item;
            begin.next.next.prev = begin;
            begin.next = begin.next.next;
            size --;
            return element;
        }
    }

    @Override
    public Object removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            Object element = end.prev.item;
            end.prev.prev.next = end;
            end.prev = end.prev.prev;
            size--;
            return element;
        }
    }

    @Override
    public void add(int index, Object item) {
        
        if (index > size || index < 0){
            throw new IndexOutOfBoundsException();
        } else if (index == size){
            addLast(item);
        } else if (index == 0){
            addFirst(item);
        } else{
            Node node = begin.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            Node node2 = new Node(item, node, node.prev);
            node.prev = node2;
            node.next = node2;
            size ++;
        }
    }

    @Override
    public void set(int index, Object item) {
        if (index > size || index < 0) {
            throw new NoSuchElementException();
        } else if (index == size){
            addLast(item);
        } else {
            Node node = begin.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            node.item = item;
        }
    }

    @Override
    public Object get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node object = begin.next;
        int i = 0;
        while (i < index) {
            object = object.next;
            i++;
        }
        return object.item;
    }

    @Override
    public int indexOf(Object item) {
        int i = 0;
        Node node = begin.next;
        while (i < size) {
            if (node.item == item) {
                return i;
            }
            node = node.next;
            i++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object item) {
        int i = size - 1;
        Node node = end.prev;
        while (i >= 0) {
            if (node.item == item) {
                return i;
            }
            node = node.prev;
            i--;
        }
        return -1;
    }

    @Override
    public Object remove(int index) {
        if (index >= size || index < 0) {
            throw new NoSuchElementException();
        } else {
            Object resul = null;
            Node node = begin.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            resul = deleteElement(node);
            return resul;
        }
    }

    @Override
    public List subList(int from, int to) {
        if (to > size || from > to || from < 0 || to < 0)
            throw new IndexOutOfBoundsException();
        LinkedList linkedList = new LinkedList();
        Node node = begin.next;
        for (int i = 0; i < to; i++) {
            if (i >= from) {
                linkedList.addLast(node.item);
            }
            node = node.next;
        }
        return (List)linkedList;
    }

    @Override
    public Iterator<Object> iterator() {
        return new ListIterator(this);
    }
}
