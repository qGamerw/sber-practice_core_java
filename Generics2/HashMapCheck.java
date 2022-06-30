package Generics2;

public class HashMapCheck {
    public static void main(String[] args) {

        testGet();
        testContainsValue();
        testContainsKey();
        testValues();
        testkeySet();
        testEntrySet();
        testSize();
        testRemove();
        testClear();
        testIsEmptry();
    }

    private static void testGet(){
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1, "1");
        hashMap.put(2, "2");
        hashMap.put(3, "3");

        System.out.println("Test Get");
        if (hashMap.get(1) == "1")
            System.out.println(true);
        else 
            System.out.println(false);
        if (hashMap.get(2) == "2")
            System.out.println(true);
        else 
            System.out.println(false);  
        if (hashMap.get(3) == "3")
            System.out.println(true);
        else 
            System.out.println(false); 
        System.out.println();
    }

    private static void testContainsValue(){
        HashMap<Number,String> hashMap = new HashMap<>();
        hashMap.put(1, "1");
        hashMap.put(2, "2");
        hashMap.put(3, "3");
        hashMap.put(4, null);

        System.out.println("Test contains Value");
        System.out.println(hashMap.containsValue("1"));
        System.out.println(hashMap.containsValue("2"));
        System.out.println(hashMap.containsValue("3"));
        System.out.println(hashMap.containsValue(null));
        if (hashMap.containsValue("5") == false)
            System.out.println(true);
        else 
            System.out.println(false);
        
        System.out.println();
    }

    private static void testContainsKey(){
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1, "1");
        hashMap.put(2, "2");
        hashMap.put(3, "3");


        System.out.println("Test contains Key");
        System.out.println(hashMap.containsKey(1));
        System.out.println(hashMap.containsKey(2));
        System.out.println(hashMap.containsKey(3));
        if (hashMap.containsKey(4) == false)
            System.out.println(true);
        else 
            System.out.println(false);
        System.out.println();
    }

    private static void testValues(){
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1, "1");
        hashMap.put(2, "2");
        hashMap.put(3, "3");

        System.out.println("Test values");
        for (Object el : hashMap.values()) {
            System.out.println(el);
        }
        System.out.println();
    }

    private static void testkeySet(){
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1, "1");
        hashMap.put(2, "2");
        hashMap.put(3, "3");

        System.out.println("Test KEY SET");
        for (Object el : hashMap.keySet()) {
            System.out.println(el);
        }
        System.out.println();
    }

    private static void testEntrySet(){
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1, "1");
        hashMap.put(2, "2");
        hashMap.put(3, "3");


        System.out.println("Test entry Set");
        for (Object el : hashMap.entrySet()) {
            System.out.println(el);
        }
        System.out.println();
    }

    private static void testSize(){
        System.out.println("Test size");
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1, "1");
        hashMap.put(2, "2");
        hashMap.put(9, "3");
        
        if (hashMap.size() == 3)
            System.out.println(true);
        else 
            System.out.println(false);
        hashMap.clear();
        if (hashMap.size() == 0)
            System.out.println(true);
        else 
            System.out.println(false);
        System.out.println();
    }

    private static void testRemove(){
        System.out.println("Test remove");
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1, "1");
        hashMap.put(2, "2");
        hashMap.put(3, "3");

        hashMap.remove(3);
        if (hashMap.size() == 2)
            System.out.println(true);
        else 
            System.out.println(false);
        System.out.println();
    }

    private static void testClear(){
        System.out.println("Test clear");
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1, "1");
        hashMap.put(2, "2");
        hashMap.put(3, "3");

        hashMap.clear();
        if (hashMap.size() == 0)
            System.out.println(true);
        else 
            System.out.println(false);
        System.out.println();
    }

    private static void testIsEmptry(){
        System.out.println("Test is Empty");
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1, "1");
        hashMap.put(2, "2");
        hashMap.put(3, "3");

        if (hashMap.isEmpty() == false)
            System.out.println(true);
        else
            System.out.println(false);
        hashMap.clear();
        System.out.println(hashMap.isEmpty());
        System.out.println();
    }
}
