package evictPolicy.impl;

import evictPolicy.EvictionPolicy;

import java.util.LinkedList;
import java.util.Queue;

public class FifoEvictionPolicy<K> implements EvictionPolicy<K> {
    private final Queue<K> insertionOrder = new LinkedList<>();

    @Override
    public void keyAccessed(K key) {
        // No specific behavior for FIFO on access
    }

    @Override
    public void keyInserted(K key) {
        insertionOrder.add(key);
    }

    @Override
    public K evictKey() {
        return insertionOrder.poll(); // Remove first inserted key
    }
}
