package storage;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DataStorageImpl implements DataStorage {

    Map<String, String> storageMap = new HashMap<>();
    Map<String, String> snapshotMap = new HashMap<>();

    private Boolean isActiveTransaction;

    public DataStorageImpl() {
        this.isActiveTransaction = true;
    }

    @Override
    public String get(String key) throws Exception {
        String value;
        if (this.isActiveTransaction) {
            value = snapshotMap.get(key);
            if (Objects.isNull(value)) {
                throw new Exception("No Key present in the cache");
            }
        } else {
            value = storageMap.get(key);
            if (Objects.isNull(value)) {
                throw new Exception("No Key present in the cache");
            }
        }
        return value;
    }

    @Override
    public void put(String key, String value) {
        this.isActiveTransaction = true;

        snapshotMap.put(key, value);
    }

    @Override
    public void delete(String key) throws Exception {
        if (this.isActiveTransaction) {
            if (snapshotMap.containsKey(key))
                snapshotMap.remove(key);
            else
                throw new Exception("No Key present in the cache");
        } else {
            if (storageMap.containsKey(key))
                storageMap.remove(key);
            else
                throw new Exception("No Key present in the cache");
        }
    }

    @Override
    public void commit() throws Exception {
        if (this.isActiveTransaction) {
            storageMap.putAll(snapshotMap);
            snapshotMap.clear();
            this.isActiveTransaction = false;
        } else {
            throw new Exception("Nothing to commit");
        }
    }

    @Override
    public void rollback(String key) throws Exception {
        if (this.isActiveTransaction) {
            if (snapshotMap.containsKey(key)) {
                snapshotMap.remove(key);
                this.isActiveTransaction = false;
            } else {
                throw new Exception("No active transaction key present for rollback");
            }
        } else {
            throw new Exception("No active transaction");
        }
    }
}
