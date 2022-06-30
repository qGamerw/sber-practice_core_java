package Collections2;

public class Entry {

    private Object key;
    private Object value;
    
    public Entry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }
    
    public void setValue(Object value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return "Entry [key=" + key + ", value=" + value + "]";
    }
}
