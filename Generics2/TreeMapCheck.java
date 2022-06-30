package Generics2;

public class TreeMapCheck {
    public static void main(String[] args) {

        testGet();
        testContainsValue();
        testContainsKey();
        testValues();
        testkeySet();
        testEntrySet();
        testSize();
        testClear();
        testRemove();
        testIsEmptry();
    }

    private static void testGet(){
        TreeMap<Integer,String> treeMap = new TreeMap<>(); 
        treeMap.put(1, "1");
        treeMap.put(2, "2");
        treeMap.put(3, "3");
        
        System.out.println("Test get");
        if (treeMap.get(1).equals("1"))
            System.out.println(true);
        else
            System.out.println(false);
        if (treeMap.get(2).equals("2"))
            System.out.println(true);
        else
            System.out.println(false);
        if (treeMap.get(3).equals("3"))
            System.out.println(true);
        else
            System.out.println(false);
        System.out.println();
    }

    private static void testContainsValue(){
        TreeMap<Integer,String> treeMap = new TreeMap<>(); 

        treeMap.put(1, "1");
        treeMap.put(2, "2");
        treeMap.put(3, "3");

        System.out.println("Test contains Value");
        
        System.out.println(treeMap.containsValue("1"));
        System.out.println(treeMap.containsValue("2"));
        System.out.println(treeMap.containsValue("3"));
        if (treeMap.containsValue("4") == false)
            System.out.println(true);
        else
            System.out.println(false);
        
        System.out.println();
    }

    private static void testContainsKey(){
        System.out.println("Test contains Key");

        TreeMap<Integer,String> treeMap = new TreeMap<>(); 
        treeMap.put(1, "1");
        treeMap.put(2, "2");
        treeMap.put(3, "3");
       
        System.out.println(treeMap.containsKey(1));
        System.out.println(treeMap.containsKey(2));
        System.out.println(treeMap.containsKey(3));
        if (treeMap.containsKey(4) == false)
            System.out.println(true);
        else
            System.out.println(false);
        
        System.out.println();
    }

    private static void testValues(){
        System.out.println("Test values");

        TreeMap<Integer,String> treeMap = new TreeMap<>(); 
        treeMap.put(1, "1");
        treeMap.put(2, "2");
        treeMap.put(3, "3");
        
        for (Object el : treeMap.values()) {
            System.out.println(el);
        }
        System.out.println();
    }

    private static void testkeySet(){
        System.out.println("Test key Set");
        TreeMap<Integer,String> treeMap = new TreeMap<>(); 
        treeMap.put(1, "1");
        treeMap.put(2, "2");
        treeMap.put(3, "3");

        for (Object el : treeMap.keySet()) {
            System.out.println(el);
        }
        System.out.println();
    }

    private static void testEntrySet(){
        System.out.println("Test entry Set");
        TreeMap<Integer,String> treeMap = new TreeMap<>(); 
        treeMap.put(1, "1");
        treeMap.put(2, "2");
        treeMap.put(3, "3");

        for (Object el : treeMap.entrySet()) {
            System.out.println(el);
        }
        System.out.println();
    }

    private static void testSize(){
        System.out.println("Test size");

        TreeMap<Integer,String> treeMap = new TreeMap<>(); 
        treeMap.put(1, "1");
        treeMap.put(2, "2");
        treeMap.put(3, "3");

        if (treeMap.size() == 3)
            System.out.println(true);
        else
            System.out.println(false);
        System.out.println();
    }

    private static void testClear(){
        System.out.println("Test size");

        TreeMap<Integer,String> treeMap = new TreeMap<>(); 
        treeMap.put(1, "1");
        treeMap.put(2, "2");
        treeMap.put(3, "3");
        
        treeMap.clear();
        if (treeMap.size() == 0)
            System.out.println(true);
        else
            System.out.println(false);
    }

    private static void testRemove(){
        System.out.println("Test remove");

        TreeMap<Integer,String> treeMap = new TreeMap<>(); 
        treeMap.put(1, "1");
        treeMap.put(2, "2");
        treeMap.put(3, "3");

        treeMap.remove(1);
        if (treeMap.size() == 2)
            System.out.println(true);
        else
            System.out.println(false);
        System.out.println();
    }

    private static void testIsEmptry(){
        System.out.println("Test is Empty");

        TreeMap<Integer,String> treeMap = new TreeMap<>(); 

        if (treeMap.isEmpty() == true)
            System.out.println(true);
        else
            System.out.println(false);

        treeMap.put(1, "1");
        treeMap.put(2, "2");
        treeMap.put(3, "3");

        if (treeMap.isEmpty() == false)
            System.out.println(true);
        else
            System.out.println(false);
    }
}
