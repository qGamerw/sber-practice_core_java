package Collections1;

import java.util.*;

public class ArrayListCheck {
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
        testIterator();
    }

    private static void testGet(){
        System.out.println("Test get");
        ArrayList arrayList = new ArrayList();

        for (int i = 0; i < 5; i++) {
            arrayList.add(i);
        }

        if (arrayList.get(0).equals(0)){
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        if (arrayList.get(2).equals(2)){
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        if (arrayList.get(4).equals(4)){
            System.out.println(true);
        } else {
             System.out.println(false);
        }
            try {
            arrayList.get(6);
            arrayList.get(-1);
            } catch (IndexOutOfBoundsException eIndexOutOfBoundsException) {
                System.out.println(true);
            }
        System.out.println();
    }

    private static void testIndexOf() {
        System.out.println("Test indexOf");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            arrayList.add(i);
        }
        if (arrayList.indexOf(0) == 0){
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        if (arrayList.indexOf(2) == 2) {
            System.out.println(true);
        } else {
            System.out.println(false);
        } 
        if (!(arrayList.indexOf(4) == 5)){
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        System.out.println();   
    }

    private static void testLastIndexOf() {
        System.out.println("Test lastIndexOf");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            arrayList.add(i);
        }

        if (arrayList.lastIndexOf(0) == 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        if (arrayList.lastIndexOf(2) == 2) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        if (!(arrayList.lastIndexOf(4) == 5)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        System.out.println();
    }

    private static void testRemove() {
        System.out.println("Test remove");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            arrayList.add(i);
        }
        if (arrayList.remove(0).equals(0)){
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        if (arrayList.remove(0).equals(1)){
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        if (arrayList.remove(0).equals(2)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        if (arrayList.remove(0).equals(3)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        if (arrayList.remove(0).equals(4)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        try {
            arrayList.remove(5);
        } catch (IndexOutOfBoundsException eIndexOutOfBoundsException) {
            System.out.println(true);
        }
        System.out.println();
    }

    private static void testSet() {
        System.out.println("Test set");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            arrayList.add(i);
        }
        for (int i = 4, k = 0; i >= 0; i--, k++) {
            arrayList.set(i, k);
        }
        if (arrayList.get(0).equals(4)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        if (arrayList.get(1).equals(3)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        if (arrayList.get(2).equals(2)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        try {
            arrayList.set(6, 6);
            arrayList.set(-1, 6);
        } catch (IndexOutOfBoundsException eIndexOutOfBoundsException) {
            System.out.println(true);
        }
        arrayList.set(5, 6);
        if (arrayList.get(5).equals(6)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        System.out.println();
    }

    private static void testSubList() {
        System.out.println("Test sub List");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            arrayList.add(i);
        }
        ArrayList arrayList2 = (ArrayList) arrayList.subList(1, 2);
        ArrayList arrayList3 = (ArrayList) arrayList.subList(2, 4);
        ArrayList arrayList4 = (ArrayList) arrayList.subList(0, 4);
        
        if (arrayList2.get(0).equals(1)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        if (arrayList3.get(1).equals(3)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        if (arrayList4.get(3).equals(3)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        try {
            arrayList.subList(5, 10);
        } catch (IndexOutOfBoundsException eIndexOutOfBoundsException) {
            System.out.println(true);
        }
        System.out.println();
    }

    private static void testContains() {
        System.out.println("Test contains");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            arrayList.add(i);
        }
        if (arrayList.contains(0)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        if (arrayList.contains(2)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        if (arrayList.contains(4)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        if (!arrayList.contains(7)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        if (!arrayList.contains(-4)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        System.out.println();
    }

    private static void testIsEmpty() {
        System.out.println("Test is emptry");
        ArrayList arrayList = new ArrayList();
        if (arrayList.isEmptry()) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        for (int i = 0; i < 5; i++) {
            arrayList.add(i);
        }
        if (!arrayList.isEmptry()) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        arrayList.clear();
        if (arrayList.isEmptry()) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        System.out.println();
    }

    private static void testSize() {
        System.out.println("Test size");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            arrayList.add(i);
        }
        if (arrayList.size() == 5) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        arrayList.clear();
        if (arrayList.size() == 0){
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        for (int i = 0; i < 1000; i++) {
            arrayList.add(i);
        }
        if (arrayList.size() == 1000) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        System.out.println();
    }

    private static void testIterator() {
        System.out.println("Test iterator");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            arrayList.add(i);
        }
        Iterator<Object> it = arrayList.iterator();
        if (it.next() == (Object) 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        if (it.next() == (Object) 1) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        if (it.next() == (Object) 2) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        if (it.next() == (Object) 3) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        if (it.next() == (Object) 4) {
            System.out.println(true);
        } else
            System.out.println(false);
        try {
            it.next();
        } catch (NoSuchElementException eNoSuchElementException) {
            System.out.println(true);
        }
        System.out.println();
    }
}
