package Generics1;

import java.util.*;

public class LinkedList<E> implements List<E>, Deque<E> {

    private Node<E> begin;
    private Node<E> end;
    private int size;

    public LinkedList () {
        begin = new Node<>();
        end = new Node<>();
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
    public boolean contains(E item) {
        Node<E> node = begin.next;
        while (node.item != item){
            if (node.next == null){
                return false;
            }
            node = node.next;
        }
        return true;
    }

    @Override
    public boolean add(E item) {
        addLast(item);
        return true;
    }

    @Override
    public boolean remove(E item) {
        Node<E> node = begin.next;
        while(node != null){
            if (node.item == item){
                deleteElement(node);
                return true;
            }
            node = node.next;
        }
        return false;
    }

    private E deleteElement (Node<E> node){
        E resul = null;
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
        Node<E> node = begin.next;
        while (node != null) {
            deleteElement(node);
            node = node.next;
        }
    }

    @Override
    public void addFirst(E item) {
        if (begin.next.equals(end)){
            Node<E> node = new Node<>(item, end, begin);
            begin.next = node;
            end.prev = node;
        } else {
            Node<E> node = new Node<>(item, begin.next, null);
            begin.next.prev = node;
            begin.next = node;
        }
        size ++;
    }

    @Override
    public void addLast(E item) {
        if (end.prev.equals(begin)){
            Node<E> node = new Node<>(item, end, begin);
            begin.next = node;
            end.prev = node;
        } else {
            Node<E> node = new Node<>(item, null, end.prev);
            end.prev.next = node;
            end.prev = node;
        }
        size ++;
    }

    @Override
    public E getFirst() throws NoSuchElementException {
        if (size == 0){
             throw new NoSuchElementException();
        }
        return begin.next.item;
    }

    @Override
    public E getLast() throws NoSuchElementException {
        if (size == 0){
            throw new NoSuchElementException();
        }
        return end.prev.item;
    }

    @Override
    public E pollFirst() {
        if (size == 0){
            return null;
        } else {
            E element = begin.next.item;
            begin.next.prev = begin;
            begin.next = begin.next.next;
            size --;
            return element;
        }
    }

    @Override
    public E pollLast() {
        if (size == 0){
            return null;
        } else {
            E element = end.prev.item;
            end.prev.next = end;
            end.prev = end.prev.prev;
            size --;
            return element;
        }
    }

    @Override
    public E removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            E element = begin.next.item;
            begin.next.next.prev = begin;
            begin.next = begin.next.next;
            size --;
            return element;
        }
    }

    @Override
    public E removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            E element = end.prev.item;
            end.prev.prev.next = end;
            end.prev = end.prev.prev;
            size--;
            return element;
        }
    }

    @Override
    public void add(int index, E item) {
        
        if (index > size || index < 0){
            throw new IndexOutOfBoundsException();
        } else if (index == size){
            addLast(item);
        } else if (index == 0){
            addFirst(item);
        } else{
            Node<E> node = begin.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            Node<E> node2 = new Node<>(item, node, node.prev);
            node.prev = node2;
            node.next = node2;
            size ++;
        }
    }

    @Override
    public void set(int index, E item) {
        if (index > size || index < 0) {
            throw new NoSuchElementException();
        } else if (index == size){
            addLast(item);
        } else {
            Node<E> node = begin.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            node.item = item;
        }
    }

    @Override
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> object = begin.next;
        int i = 0;
        while (i < index) {
            object = object.next;
            i++;
        }
        return object.item;
    }

    @Override
    public int indexOf(E item) {
        int i = 0;
        Node<E> node = begin.next;
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
    public int lastIndexOf(E item) {
        int i = size - 1;
        Node<E> node = end.prev;
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
    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new NoSuchElementException();
        } else {
            E resul = null;
            Node<E> node = begin.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            resul = deleteElement(node);
            return resul;
        }
    }

    @Override
    public List<E> subList(int from, int to) {
        if (to > size || from > to || from < 0 || to < 0)
            throw new IndexOutOfBoundsException();
        LinkedList<E> linkedList = new LinkedList<>();
        Node<E> node = begin.next;
        for (int i = 0; i < to; i++) {
            if (i >= from) {
                linkedList.addLast(node.item);
            }
            node = node.next;
        }
        return (List<E>)linkedList;
    }

    @Override
    public Iterator<Object> iterator() {
        return new ListIterator<>(this);
    }
}
