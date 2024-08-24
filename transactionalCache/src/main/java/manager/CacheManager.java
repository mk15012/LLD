package manager;

public interface CacheManager {

    String get(String key) throws Exception;

    void put(String key, String value) throws Exception;

    void delete(String key) throws Exception;

    void commit() throws Exception;

    void rollback(String key) throws Exception;

}
