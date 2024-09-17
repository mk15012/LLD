import dao.impl.CacheImpl;
import evictPolicy.EvictionPolicy;
import evictPolicy.impl.LruEvictionPolicy;
import dao.Cache;

public class CacheApplication {
    public static void main(String[] args) {
        // Choose an eviction policy: LRU, FIFO, or LFU
        EvictionPolicy<String> evictionPolicy = new LruEvictionPolicy<>();
        // Initialize Key-Value store with capacity 3 and the selected eviction policy
        Cache<String, String> cache = new CacheImpl<>(3, evictionPolicy);

        cache.put("A", "ValueA");
        cache.put("B", "ValueB");
        cache.put("C", "ValueC");

        System.out.println("Cache after inserting 3 items: " + cache);

        cache.get("A"); // Access A to update its position in LRU

        cache.put("D", "ValueD"); // Cache full, should evict the least recently used entry

        System.out.println("Cache after inserting D (evict one): " + cache);

        cache.put("E", "ValueE"); // Should evict again

        System.out.println("Cache after inserting E (evict one): " + cache);

        // Test with LFU or FIFO by changing the EvictionPolicy instance
    }
}
