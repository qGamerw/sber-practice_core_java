package Collections2;

import Collections1.*;

public class HashMap implements Map {

    private LinkedList[] buckets;
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
    public boolean containsKey(Object key) {
        for (LinkedList linkedList: buckets){
            if (linkedList != null){
                for (int i = 0; i < linkedList.size(); i++) {
                    if (((Entry)linkedList.get(i)).getKey().equals(key)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (LinkedList linkedList: buckets){
            if (linkedList != null){
                for (int i = 0; i < linkedList.size(); i++) {

                    if (((Entry)linkedList.get(i)).getValue() == null && value == null){
                        return true;
                    } else if (((Entry)linkedList.get(i)).getValue() == null){
                        continue;
                    }
                    else if (((Entry)linkedList.get(i)).getValue().equals(value)) {
                        return true;
                    } 
                }
            }
        }
        return false;
    }

    @Override
    public Object get(Object key) {
        int bucketNumder = key.hashCode() % buckets.length;
        LinkedList linkedList = buckets[bucketNumder];
        for (int i = 0; i < linkedList.size(); i++) {
            if (((Entry)linkedList.get(i)).getKey().equals(key)) {
                return ((Entry)linkedList.get(i)).getValue();
            }
        }
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        int bucketNumder = key.hashCode() % buckets.length;
        LinkedList linkedList = buckets[bucketNumder];
        if (linkedList != null){
            for (int i = 0; i < linkedList.size(); i++) {
                if (((Entry)linkedList.get(i)).equals(key)){
                    ((Entry)linkedList.get(i)).setValue(value);
                }
            }
        } else {
            linkedList = new LinkedList();
        }
        linkedList.addLast(new Entry(key,value));
        buckets[bucketNumder] = linkedList;
        size ++;
        
        return new Entry(key,value);
    }

    @Override
    public Object remove(Object key) {
        for (LinkedList list : buckets){
            if (list != null){
                for (int i = 0; i < list.size(); i++) {
                    if(((Entry)list.get(i)).getKey().equals(key)){
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
    public Collection values() {
        ArrayList valueList = new ArrayList();
        for (LinkedList aList : buckets){
            if (aList != null){
                for (int i = 0; i < aList.size(); i++) {
                valueList.add(((Entry)aList.get(i)).getValue());
                }
            }
        }
        return valueList;
    }

    @Override
    public Collection keySet() {
        ArrayList arrayList = new ArrayList();
        for (LinkedList list : buckets) {
            if(list != null){
                for (int i = 0; i < list.size(); i++) {
                    arrayList.add(((Entry)list.get(i)).getKey());
                }
            }
        }
        return arrayList;
    }

    @Override
    public Collection entrySet() {
        ArrayList arrayList = new ArrayList();
        for (LinkedList list : buckets){
            if (list != null){
                for (int i = 0; i < list.size(); i++) {
                    arrayList.add(list.get(i));
                }
            }
        }
        return arrayList;
    }
}
