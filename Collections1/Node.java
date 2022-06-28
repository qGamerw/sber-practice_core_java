package Collections1;

public class Node {
    Object item;
    Node next;
    Node prev;

    public Node () {}

    public Node (Object item, Node next, Node prev){
        this.item = item;
        this.next = next;
        this.prev = prev;
    }
}
