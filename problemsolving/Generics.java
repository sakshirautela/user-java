class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
interface InterfacePair<K, V> {
    public K getKey();
    public V getValue();
}
class KeyValuePair<K, V extends Number> implements InterfacePair<K, V> {
    private K key;
    private V value;

    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }
}
interface NumberContainer<T extends Number> {
    void add(T item);
    T get();
}
class IntegerContainer implements NumberContainer<Integer> {
    private Integer item;

    @Override
    public void add(Integer item) {
        this.item = item;
    }

    @Override
    public Integer get() {
        return item;
    }
}
public class Generics {
    public static void main(String[] args) {
        
    }
}
