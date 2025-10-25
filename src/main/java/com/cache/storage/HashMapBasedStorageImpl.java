package com.cache.storage;

import com.cache.exceptions.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorageImpl<Key, Value> implements StorageService<Key, Value> {

    Integer capacity;
    Map<Key, Value> dataMap;

    public HashMapBasedStorageImpl(Integer capacity) {
        this.capacity = capacity;
        dataMap = new HashMap<>(capacity);
    }


    @Override
    public Value getKey(Key key) {
        return dataMap.get(key);
    }

    @Override
    public void putKey(Key key, Value value) {
        if (dataMap.size() == capacity) {
            throw new StorageFullException();
        }
        dataMap.put(key, value);
    }

    @Override
    public void removeKey(Key key) {
        this.dataMap.remove(key);
    }
}
