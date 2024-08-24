package storage;

public interface DataStorage {

    String get(String key) throws Exception;

    void put(String key, String value);

    void delete(String key) throws Exception;

    void commit() throws Exception;

    void rollback(String key) throws Exception;
}
