package Generics2;

import Generics1.Collection;
import Generics1.ArrayList;

public class TreeMap<K,V> implements Map<K,V> {

    private int size;
    private Node<Entry<K,V>> rootNode;
    private boolean flagSearch = false;
    
    public TreeMap() {
        rootNode = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean containsKey(K key) {
        flagSearch = false;
        return searchKey(rootNode, key);
    }
    
    @Override
    public boolean containsValue(V value) {
        flagSearch = false;
        return searchValue(rootNode, value);
    }

    private boolean searchKey(Node<Entry<K,V>> childNode, K key) {
        if (key.equals(getKeyEntry(childNode))) {
            flagSearch = true;
        }
        if (childNode.getLeft() != null && !flagSearch) {
            searchKey(childNode.getLeft(), key);
        }
        if (childNode.getRight() != null && !flagSearch) {
            searchKey(childNode.getRight(), key);
        }
        return flagSearch;
    }

    private boolean searchValue(Node<Entry<K,V>> childNode, V value) {
        if ((getValueEntry(childNode).equals(value))) {
            flagSearch = true;
        }
        if (childNode.getLeft() != null && !flagSearch) {
            searchValue(childNode.getLeft(), value);
        }
        if (childNode.getRight() != null && !flagSearch) {
            searchValue(childNode.getRight(), value);
        }
        return flagSearch;
    }
    
    private K getKeyEntry(Node<Entry<K,V>> node) {
        return ((Entry<K,V>) node.getValue()).getKey();
    }

    private V getValueEntry(Node<Entry<K,V>> node) {
        return ((Entry<K,V>) node.getValue()).getValue();
    }

    @Override
    public V get(K key) {
        Node<Entry<K,V>> childNode = rootNode;
        while (true){
            if (key.equals(getKeyEntry(childNode))){
                return getValueEntry(childNode);
            } else if (key.hashCode() < getKeyEntry(childNode).hashCode()) {
                childNode = childNode.getLeft();
                if (childNode == null)
                    return null;
                }
            else {
                childNode = childNode.getRight();
                if (childNode == null)
                    return null;
            }
        }
    }

    @Override
    public Entry<K,V> put(K key, V value) {
        Node<Entry<K,V>> newNode = new Node<>(new Entry<>(key, value));
        if (rootNode == null) {
            size++;
            rootNode = newNode;
        } else {
            Node<Entry<K,V>> parent;
            Node<Entry<K,V>> child = rootNode;
            while (true) {
                parent = child;
                if (getKeyEntry(child).equals(key)) {
                    child.setValue(new Entry<>(key, value));
                    return newNode.getValue();
                } else if (key.hashCode() < getKeyEntry(child).hashCode()) {
                    child = child.getLeft();
                    if (child == null) {
                        parent.setLeft(newNode);
                        size++;
                        return newNode.getValue();
                    }
                } else {
                    child = child.getRight();
                    if (child == null) {
                        parent.setRight(newNode);
                        size++;
                        return newNode.getValue();
                    }
                }
            }
        }
        return newNode.getValue();
    }

    @Override
    public V remove(K key) {
        Node<Entry<K,V>> currentNode = rootNode;
        Node<Entry<K,V>> parentNode = rootNode;

        boolean isLeft = true;

        while (!getKeyEntry(currentNode).equals(key)) {
            parentNode = currentNode;
            if (key.hashCode() < getKeyEntry(currentNode).hashCode()) {
                isLeft = true;
                currentNode = currentNode.getLeft();
            } else {
                isLeft = false;
                currentNode = currentNode.getRight();
            }
            if (currentNode == null) {
                return null;
            }
        }

        if (currentNode.getLeft() == null && currentNode.getRight() == null) {
            if (currentNode == rootNode) {
                rootNode = null;
            } else if (isLeft) {
                parentNode.setLeft(null);
            } else {
                parentNode.setRight(null);
            }
        }

        else if (currentNode.getRight() == null) {
            if (currentNode == rootNode) {
                rootNode = currentNode.getLeft();
            } else if (isLeft) {
                parentNode.setLeft(currentNode.getLeft());
            } else {
                parentNode.setRight(currentNode.getLeft());
            }
        }

        else if (currentNode.getLeft() == null) {
            if (currentNode == rootNode) {
                rootNode = currentNode.getRight();
            } else if (isLeft) {
                parentNode.setLeft(currentNode.getRight());
            } else {
                parentNode.setRight(currentNode.getRight());
            }
        }

        else {
            Node<Entry<K,V>> heir = receiveHeir(currentNode);
            if (currentNode == rootNode) {
                rootNode = heir;
            } else if (isLeft) {
                parentNode.setLeft(heir);
            } else {
                parentNode.setRight(heir);
            }
        }
        size--;
        return getValueEntry(currentNode);
    }

    private Node<Entry<K, V>> receiveHeir(Node<Entry<K, V>> node) {
        Node<Entry<K, V>> parentNode = node;
        Node<Entry<K, V>> heirNode = node;
        Node<Entry<K, V>> currentNode = node.getRight();
        while (currentNode != null) {
            parentNode = heirNode;
            heirNode = currentNode;
            currentNode = currentNode.getLeft();
        }
        if (heirNode != node.getRight()) {
            parentNode.setLeft(heirNode.getRight());
            heirNode.setRight(node.getRight());
        }
        return heirNode;
    }

    @Override
    public void clear() {
        rootNode = null;
        size = 0;
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> list = new ArrayList<>();
        addValue(rootNode, list);
        return list;
    }

    @Override
    public Collection<K> keySet() {
        ArrayList<K> list = new ArrayList<>();
        addKey(rootNode, list);
        return list;
    }

    @Override
    public Collection<Entry<K,V>> entrySet() {
        ArrayList<Entry<K,V>> list = new ArrayList<>();
        addEntrySet(rootNode, list);
        return list;
    }

    private void addEntrySet(Node<Entry<K,V>> childNode, ArrayList<Entry<K,V>> list){
        list.add(childNode.getValue());
        if ( childNode.getLeft() != null)
            addEntrySet(childNode.getLeft(), list);
        if ( childNode.getRight() != null)
            addEntrySet(childNode.getRight(), list);
    }
    
    private void addKey(Node<Entry<K,V>> childNode, ArrayList<K> list){
        list.add(getKeyEntry(childNode));
        if (childNode.getLeft() != null) {
            addKey(childNode.getLeft(), list);
        }
        if (childNode.getRight() != null) {
            addKey(childNode.getRight(), list);
        }
    }

    private void addValue(Node<Entry<K,V>> childNode, ArrayList<V> list){
        list.add(getValueEntry(childNode));
        if (childNode.getLeft() != null) {
            addValue(childNode.getLeft(), list);
        }
        if (childNode.getRight() != null) {
            addValue(childNode.getRight(), list);
        }
    }
}
