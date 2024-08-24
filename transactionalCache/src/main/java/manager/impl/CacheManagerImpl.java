package manager.impl;

import manager.CacheManager;
import storage.DataStorage;
import storage.DataStorageImpl;


public class CacheManagerImpl implements CacheManager {

    private DataStorage dataStorage = new DataStorageImpl();

    @Override
    public String get(String key) throws Exception {
        try {
            return dataStorage.get(key);
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }


    @Override
    public void put(String key, String value) throws Exception {
        try {
            dataStorage.put(key, value);
            System.out.println(value);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete(String key) throws Exception {
        try {
            dataStorage.delete(key);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void commit() throws Exception {
        try {
            dataStorage.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void rollback(String key) throws Exception {
        try {
            dataStorage.rollback(key);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
