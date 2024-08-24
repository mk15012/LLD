import manager.impl.CacheManagerImpl;

public class MainApplication {

    public static void main(String[] args) throws Exception {

        CacheManagerImpl cacheManager = new CacheManagerImpl();

        System.out.println(cacheManager.get("key1"));
        cacheManager.put("key1", "value1");
        cacheManager.put("key1", "value2");
        cacheManager.commit();
        cacheManager.rollback("key1");
        cacheManager.put("key1", "value3");
        cacheManager.put("key2", "value4");
        cacheManager.rollback("key2");
        System.out.println(cacheManager.get("key2"));
        cacheManager.commit();
        System.out.println(cacheManager.get("key1"));
        System.out.println(cacheManager.get("key2"));
    }
}
