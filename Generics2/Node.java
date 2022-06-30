package Generics2;

public class Node<E> {
    
    private Node<E> left;
    private Node<E> right;
    private E value;
    
    public Node(E value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }
}
