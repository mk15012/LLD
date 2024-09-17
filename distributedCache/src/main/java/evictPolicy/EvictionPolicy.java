package evictPolicy;


public interface EvictionPolicy<K> {
    void keyAccessed(K key);

    void keyInserted(K key);

    K evictKey();
}