package com.cache.storage;

import com.cache.exceptions.StorageFullException;

public interface StorageService<Key, Value> {

    Value getKey(Key key);
    void putKey(Key key, Value value) throws StorageFullException;
    void removeKey(Key key);
}
