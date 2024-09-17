package evictPolicy.impl;

import evictPolicy.EvictionPolicy;

import java.util.LinkedHashSet;

public class LruEvictionPolicy<K> implements EvictionPolicy<K> {
    private final LinkedHashSet<K> accessOrder = new LinkedHashSet<>();

    @Override
    public void keyAccessed(K key) {
        if (accessOrder.contains(key)) {
            accessOrder.remove(key); // Move key to the end (most recently used)
        }
        accessOrder.add(key);
    }

    @Override
    public void keyInserted(K key) {
        keyAccessed(key); // Same logic for LRU, keyAccessed can be reused.
    }

    @Override
    public K evictKey() {
        K oldest = accessOrder.iterator().next(); // Remove least recently used
        accessOrder.remove(oldest);
        return oldest;
    }
}

