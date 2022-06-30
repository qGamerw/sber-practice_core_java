package Generics1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListCheck {
    public static void main(String[] args) {
        testGet();
        testIndexOf();
        testLastIndexOf();
        testRemove();
        testSet();
        testSubList();
        testContains();
        testIsEmpty();
        testSize();
        testGetFirst();
        testGetLast();
        testPollFirst();
        testPollLast();
        testRemoveFirst();
        testRemoveLast();
        testIterator();
    }

    private static void testGet() {
        System.out.println("Test: get");
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.add(i);
        }
        if (linkedList.get(0).equals(0))
            System.out.println(true);
        else
            System.out.println(false);
        if (linkedList.get(2).equals(2))
            System.out.println(true);
        else
            System.out.println(false);
        if (linkedList.get(4).equals(4))
            System.out.println(true);
        else
            System.out.println(false);
        try {
            linkedList.get(6);
            linkedList.get(-1);
        } catch (IndexOutOfBoundsException eIndexOutOfBoundsException) {
            System.out.println(true);
        }
        System.out.println();
    }

    private static void testIndexOf() {
        System.out.println("Test index of");
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.add(i);
        }
        if (linkedList.indexOf(0) == 0)
            System.out.println(true);
        else
            System.out.println(false);
        if (linkedList.indexOf(2) == 2)
            System.out.println(true);
        else
            System.out.println(false);
        if (!(linkedList.indexOf(4) == 5))
            System.out.println(true);
        else
            System.out.println(false);
        System.out.println();
    }

    private static void testLastIndexOf() {
        System.out.println("Test last index of");
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.add(i);
        }
        if (linkedList.lastIndexOf(0) == 0)
            System.out.println(true);
        else
            System.out.println(false);
        if (linkedList.lastIndexOf(2) == 2)
            System.out.println(true);
        else
            System.out.println(false);
        if (!(linkedList.lastIndexOf(4) == 5))
            System.out.println(true);
        else
            System.out.println(false);
        System.out.println();
    }

    private static void testRemove() {
        System.out.println("Test remove");
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.add(i);
        }
        if (linkedList.remove(0).equals(0))
            System.out.println(true);
        else
            System.out.println(false);
        if (linkedList.remove(0).equals(1))
            System.out.println(true);
        else
            System.out.println(false);
        if (linkedList.remove(0).equals(2))
            System.out.println(true);
        else
            System.out.println(false);
        if (linkedList.remove(0).equals(3))
            System.out.println(true);
        else
            System.out.println(false);
        if (linkedList.remove(0).equals(4))
            System.out.println(true);
        else
            System.out.println(false);
        try {
            linkedList.remove(5);
        } catch (NoSuchElementException eNoSuchElementException) {
            System.out.println(true);
        }
        System.out.println();
    }

    private static void testSet() {
        System.out.println("Test set");
        LinkedList<Integer> testArr = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            testArr.add(i);
        }
        for (int i = 4, k = 0; i >= 0; i--, k++) {
            testArr.set(i, k);
        }
        if (testArr.get(0).equals(4))
            System.out.println(true);
        else
            System.out.println(false);
        if (testArr.get(1).equals(3))
            System.out.println(true);
        else
            System.out.println(false);
        if (testArr.get(2).equals(2))
            System.out.println(true);
        else
            System.out.println(false);
        try {
            testArr.set(6, 6);
            testArr.set(-1, 6);
        } catch (NoSuchElementException ex) {
            System.out.println(true);
        }
        testArr.set(5, 6);
        if (testArr.get(5).equals(6))
            System.out.println(true);
        else
            System.out.println(false);
        System.out.println();
    }

    private static void testSubList() {
        System.out.println("Test sub list");
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.add(i);
        }
        LinkedList<Integer> linkedList2 = (LinkedList<Integer>) linkedList.subList(1, 2);
        LinkedList<Integer> linkedList3 = (LinkedList<Integer>) linkedList.subList(2, 4);
        LinkedList<Integer> linkedList4 = (LinkedList<Integer>) linkedList.subList(0, 4);
        if (linkedList2.get(0).equals(1))
            System.out.println(true);
        else
            System.out.println(false);
        if (linkedList3.get(1).equals(3))
            System.out.println(true);
        else
            System.out.println(false);
        if (linkedList4.get(3).equals(3))
            System.out.println(true);
        else
            System.out.println(false);
        try {
            linkedList4.subList(5, 10);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(true);
        }
        System.out.println();
    }

    private static void testContains() {
        System.out.println("Test contains");
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.add(i);
        }
        if (linkedList.contains(0))
            System.out.println(true);
        else
            System.out.println(false);
        if (linkedList.contains(2))
            System.out.println(true);
        else
            System.out.println(false);
        if (linkedList.contains(4))
            System.out.println(true);
        else
            System.out.println(false);
        if (!linkedList.contains(7))
            System.out.println(true);
        else
            System.out.println(false);
        if (!linkedList.contains(-4))
            System.out.println(true);
        else
            System.out.println(false);
        System.out.println();
    }

    private static void testIsEmpty() {
        System.out.println("Test is emptry");
        LinkedList<Integer> linkedList = new LinkedList<>();
        if (linkedList.isEmptry())
            System.out.println(true);
        else
            System.out.println(false);
        for (int i = 0; i < 5; i++) {
            linkedList.add(i);
        }
        if (!linkedList.isEmptry())
            System.out.println(true);
        else
            System.out.println(false);
        linkedList.clear();
        if (linkedList.isEmptry())
            System.out.println(true);
        else
            System.out.println(false);
        System.out.println();
    }

    private static void testSize() {
        System.out.println("Test size");
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.add(i);
        }
        if (linkedList.size() == 5)
            System.out.println(true);
        else
            System.out.println(false);
        

        linkedList.clear();
        if (linkedList.size() == 0)
            System.out.println(true);
        else
            System.out.println(false);
        
        for (int i = 0; i < 1000; i++) {
            linkedList.add(i);
        }
        
        if (linkedList.size() == 1000)
            System.out.println(true);
        else
            System.out.println(false);
        System.out.println();
    }

    private static void testGetFirst() {
        System.out.println("Test get first");
        LinkedList<Integer> linkedList = new LinkedList<>();
        
        linkedList.addFirst(1);
        if (linkedList.getFirst() == (Object) 1)
            System.out.println(true);
        else
            System.out.println(false);
        linkedList.addFirst(2);
        if (linkedList.getFirst() == (Object) 2)
            System.out.println(true);
        else
            System.out.println(false);
        linkedList.addFirst(3);
        if (linkedList.getFirst() == (Object) 3)
            System.out.println(true);
        else
            System.out.println(false);
        linkedList.clear();
        try {
            linkedList.getFirst();
        } catch (NoSuchElementException ex) {
            System.out.println(true);
        }
        System.out.println();
    }

    private static void testGetLast() {
        System.out.println("Test get last");
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.addLast(1);
        if (linkedList.getLast() == (Object) 1)
            System.out.println(true);
        else
            System.out.println(false);
        linkedList.addLast(2);
        if (linkedList.getLast() == (Object) 2)
            System.out.println(true);
        else
            System.out.println(false);
        linkedList.addLast(3);
        if (linkedList.getLast() == (Object) 3)
            System.out.println(true);
        else
            System.out.println(false);
        linkedList.clear();
        try {
            linkedList.getLast();
        } catch (NoSuchElementException eNoSuchElementException) {
            System.out.println(true);
        }
        System.out.println();
    }

    private static void testPollFirst() {
        System.out.println("Test: poll first");
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.addFirst(1);
        if (linkedList.pollFirst() == (Object) 1)
            System.out.println(true);
        else
            System.out.println(false);
        linkedList.addFirst(2);
        if (linkedList.pollFirst() == (Object) 2)
            System.out.println(true);
        else
            System.out.println(false);
        linkedList.addFirst(3);
        if (linkedList.pollFirst() == (Object) 3)
            System.out.println(true);
        else
            System.out.println(false);
        linkedList.clear();
        if (linkedList.pollFirst() == null)
            System.out.println(true);
        else
            System.out.println(false);
        System.out.println();
    }

    private static void testPollLast() {
        System.out.println("Test poll Last");
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.addLast(1);
        if (linkedList.pollLast() == (Object) 1)
            System.out.println(true);
        else
            System.out.println(false);
        linkedList.addLast(2);
        if (linkedList.pollLast() == (Object) 2)
            System.out.println(true);
        else
            System.out.println(false);
        linkedList.addLast(3);
        if (linkedList.pollLast() == (Object) 3)
            System.out.println(true);
        else
            System.out.println(false);
        linkedList.clear();
        if (linkedList.pollLast() == null)
            System.out.println(true);
        else
            System.out.println(false);
        System.out.println();
    }

    private static void testRemoveFirst() {
        System.out.println("Test remove first");
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.addFirst(1);
        if (linkedList.removeFirst() == (Object) 1)
            System.out.println(true);
        else
            System.out.println(false);
        linkedList.addFirst(2);
        if (linkedList.removeFirst() == (Object) 2)
            System.out.println(true);
        else
            System.out.println(false);
        linkedList.addFirst(3);
        if (linkedList.removeFirst() == (Object) 3)
            System.out.println(true);
        else
            System.out.println(false);
        try {
            linkedList.removeFirst();
        } catch (NoSuchElementException eNoSuchElementException) {
            System.out.println(true);
        }
        System.out.println();
    }

    private static void testRemoveLast() {
        System.out.println("Test remove last");
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.addLast(1);
        if (linkedList.removeLast() == (Object) 1)
            System.out.println(true);
        else
            System.out.println(false);
        linkedList.addLast(2);
        if (linkedList.removeLast() == (Object) 2)
            System.out.println(true);
        else
            System.out.println(false);
        linkedList.addLast(3);
        if (linkedList.removeLast() == (Object) 3)
            System.out.println(true);
        else
            System.out.println(false);
        try {
            linkedList.removeLast();
        } catch (NoSuchElementException eNoSuchElementException) {
            System.out.println(true);
        }
        System.out.println();
    }

    private static void testIterator() {
        System.out.println("Test iterator");
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.add(i);
        }
        Iterator<Object> it = linkedList.iterator();
        if (it.next() == (Object) 0)
            System.out.println(true);
        else
            System.out.println(false);
        if (it.next() == (Object) 1)
            System.out.println(true);
        else
            System.out.println(false);
        if (it.next() == (Object) 2)
            System.out.println(true);
        else
            System.out.println(false);
        if (it.next() == (Object) 3)
            System.out.println(true);
        else
            System.out.println(false);
        if (it.next() == (Object) 4)
            System.out.println(true);
        else
            System.out.println(false);
        try {
            it.next();
        } catch (NoSuchElementException ex) {
            System.out.println(true);
        }
        System.out.println();
    }
}