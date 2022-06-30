package Generics1;

public class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;

    public Node () {}

    public Node (E item, Node<E> next, Node<E> prev){
        this.item = item;
        this.next = next;
        this.prev = prev;
    }
}
