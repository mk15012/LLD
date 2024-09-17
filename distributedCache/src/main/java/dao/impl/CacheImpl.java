package dao.impl;

import evictPolicy.EvictionPolicy;
import dao.Cache;

import java.util.HashMap;
import java.util.Map;

public class CacheImpl<K, V> implements Cache<K, V> {

    private final int capacity;
    private final Map<K, V> store;
    private final EvictionPolicy<K> evictionPolicy;

    public CacheImpl(int capacity, EvictionPolicy<K> evictionPolicy) {
        this.capacity = capacity;
        this.store = new HashMap<>();
        this.evictionPolicy = evictionPolicy;
    }

    @Override
    public synchronized void put(K key, V value) {
        if (store.size() == capacity) {
            K evictedKey = evictionPolicy.evictKey();
            store.remove(evictedKey);
            System.out.println("Evicted Key: " + evictedKey);
        }
        store.put(key, value);
        evictionPolicy.keyInserted(key);
    }

    @Override
    public synchronized V get(K key) {
        if (!store.containsKey(key)) {
            return null;
        }
        evictionPolicy.keyAccessed(key);
        return store.get(key);
    }

    @Override
    public synchronized void delete(K key) {
        store.remove(key);
    }

    @Override
    public int size() {
        return store.size();
    }

    @Override
    public String toString() {
        return store.toString();
    }
}
