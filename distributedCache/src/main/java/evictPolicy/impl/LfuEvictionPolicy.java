package evictPolicy.impl;


import evictPolicy.EvictionPolicy;

import java.util.HashMap;
import java.util.Map;

public class LfuEvictionPolicy<K> implements EvictionPolicy<K> {
    private final Map<K, Integer> frequencyMap = new HashMap<>();

    @Override
    public void keyAccessed(K key) {
        frequencyMap.put(key, frequencyMap.getOrDefault(key, 0) + 1);
    }

    @Override
    public void keyInserted(K key) {
        frequencyMap.put(key, 1); // New key has frequency of 1
    }

    @Override
    public K evictKey() {
        K leastFrequentKey = null;
        int minFrequency = Integer.MAX_VALUE;

        // Find the key with the least frequency
        for (Map.Entry<K, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() < minFrequency) {
                minFrequency = entry.getValue();
                leastFrequentKey = entry.getKey();
            }
        }

        frequencyMap.remove(leastFrequentKey); // Remove the least frequently used key
        return leastFrequentKey;
    }
}
