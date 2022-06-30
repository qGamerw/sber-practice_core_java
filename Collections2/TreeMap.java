package Collections2;

import Collections1.Collection;
import Collections1.ArrayList;

public class TreeMap implements Map {

    private int size;
    private Node rootNode;
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
    public boolean containsKey(Object key) {
        flagSearch = false;
        return searchKey(rootNode, key);
    }
    
    @Override
    public boolean containsValue(Object value) {
        flagSearch = false;
        return searchValue(rootNode, value);
    }

    private boolean searchKey(Node childNode, Object key) {
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

    private boolean searchValue(Node childNode, Object value) {
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
    
    private Object getKeyEntry(Node node) {
        return ((Entry) node.getValue()).getKey();
    }

    private Object getValueEntry(Node node) {
        return ((Entry) node.getValue()).getValue();
    }

    @Override
    public Object get(Object key) {
        Node childNode = rootNode;
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
    public Object put(Object key, Object value) {
        Node newNode = new Node(new Entry(key, value));
        if (rootNode == null) {
            size++;
            rootNode = newNode;
        } else {
            Node parent;
            Node child = rootNode;
            while (true) {
                parent = child;
                if (getKeyEntry(child).equals(key)) {
                    child.setValue(new Entry(key, value));
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
                        return newNode;
                    }
                }
            }
        }
        return newNode.getValue();
    }

    @Override
    public Object remove(Object key) {
        Node currentNode = rootNode;
        Node parentNode = rootNode;

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
            Node heir = receiveHeir(currentNode);
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

    private Node receiveHeir(Node node) {
        Node parentNode = node;
        Node heirNode = node;
        Node currentNode = node.getRight();
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
    public Collection values() {
        ArrayList list = new ArrayList();
        addValue(rootNode, list);
        return list;
    }

    @Override
    public Collection keySet() {
        ArrayList list = new ArrayList();
        addKey(rootNode, list);
        return list;
    }

    @Override
    public Collection entrySet() {
        ArrayList list = new ArrayList();
        addEntrySet(rootNode, list);
        return list;
    }

    private void addEntrySet(Node childNode, ArrayList list){
        list.add(childNode.getValue());
        if ( childNode.getLeft() != null)
            addEntrySet(childNode.getLeft(), list);
        if ( childNode.getRight() != null)
            addEntrySet(childNode.getRight(), list);
    }
    
    private void addKey(Node childNode, ArrayList list){
        list.add(getKeyEntry(childNode));
        if (childNode.getLeft() != null) {
            addKey(childNode.getLeft(), list);
        }
        if (childNode.getRight() != null) {
            addKey(childNode.getRight(), list);
        }
    }

    private void addValue(Node childNode, ArrayList list){
        list.add(getValueEntry(childNode));
        if (childNode.getLeft() != null) {
            addValue(childNode.getLeft(), list);
        }
        if (childNode.getRight() != null) {
            addValue(childNode.getRight(), list);
        }
    }
}
