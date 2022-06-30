package Generics2;

import Generics1.*;

public class HashMap<K,V> implements Map<K,V> {

    private LinkedList<Entry<K,V>>[] buckets;
    private int capacity;
    private int size;

    public HashMap() {
        capacity = (int) Math.pow(2, 10);
        buckets = new LinkedList[capacity];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0)
            return true;
        return false;
    }

    @Override
    public boolean containsKey(K key) {
        for (LinkedList<Entry<K,V>> linkedList: buckets){
            if (linkedList != null){
                for (int i = 0; i < linkedList.size(); i++) {
                    if (((Entry<K,V>)linkedList.get(i)).getKey().equals(key)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for (LinkedList<Entry<K,V>> linkedList: buckets){
            if (linkedList != null){
                for (int i = 0; i < linkedList.size(); i++) {

                    if (((Entry<K,V>)linkedList.get(i)).getValue() == null && value == null){
                        return true;
                    } else if (((Entry<K,V>)linkedList.get(i)).getValue() == null){
                        continue;
                    }
                    else if (((Entry<K,V>)linkedList.get(i)).getValue().equals(value)) {
                        return true;
                    } 
                }
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        int bucketNumder = key.hashCode() % buckets.length;
        LinkedList<Entry<K,V>> linkedList = buckets[bucketNumder];
        for (int i = 0; i < linkedList.size(); i++) {
            if (((Entry<K,V>)linkedList.get(i)).getKey().equals(key)) {
                return ((Entry<K,V>)linkedList.get(i)).getValue();
            }
        }
        return null;
    }

    @Override
    public Entry<K,V> put(K key, V value) {
        int bucketNumder = key.hashCode() % buckets.length;
        LinkedList<Entry<K,V>> linkedList = buckets[bucketNumder];
        if (linkedList != null){
            for (int i = 0; i < linkedList.size(); i++) {
                if (((Entry<K,V>)linkedList.get(i)).equals(key)){
                    ((Entry<K,V>)linkedList.get(i)).setValue(value);
                }
            }
        } else {
            linkedList = new LinkedList<>();
        }
        linkedList.addLast(new Entry<>(key,value));
        buckets[bucketNumder] = linkedList;
        size ++;
        
        return new Entry<>(key,value);
    }

    @Override
    public V remove(K key) {
        for (LinkedList<Entry<K,V>> list : buckets){
            if (list != null){
                for (int i = 0; i < list.size(); i++) {
                    if(((Entry<K,V>)list.get(i)).getKey().equals(key)){
                        list.remove(i);
                        size--;
                        return null;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public void clear() {
        buckets = new LinkedList[capacity];
        size = 0;
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> valueList = new ArrayList<>();
        for (LinkedList<Entry<K,V>> aList : buckets){
            if (aList != null){
                for (int i = 0; i < aList.size(); i++) {
                valueList.add(((Entry<K,V>)aList.get(i)).getValue());
                }
            }
        }
        return valueList;
    }

    @Override
    public Collection<K> keySet() {
        ArrayList<K> arrayList = new ArrayList<>();
        for (LinkedList<Entry<K,V>> list : buckets) {
            if(list != null){
                for (int i = 0; i < list.size(); i++) {
                    arrayList.add(((Entry<K,V>)list.get(i)).getKey());
                }
            }
        }
        return arrayList;
    }

    @Override
    public Collection<Entry<K,V>> entrySet() {
        ArrayList<Entry<K,V>> arrayList = new ArrayList<>();
        for (LinkedList<Entry<K,V>> list : buckets){
            if (list != null){
                for (int i = 0; i < list.size(); i++) {
                    arrayList.add(list.get(i));
                }
            }
        }
        return arrayList;
    }
}
