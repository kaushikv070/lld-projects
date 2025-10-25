package com.cache;

import com.cache.exceptions.StorageFullException;
import com.cache.policies.EvictionPolicy;
import com.cache.storage.StorageService;

import java.security.Key;

public class CacheHelperService<Key, Value> {

    private final StorageService<Key, Value> storageService;
    private final EvictionPolicy<Key> evictionPolicy;

    public CacheHelperService(StorageService<Key, Value> storageService, EvictionPolicy<Key> evictionPolicy) {
        this.storageService = storageService;
        this.evictionPolicy = evictionPolicy;
    }

    public void put(Key key, Value value) {

        try {
            this.storageService.putKey(key, value);
            this.evictionPolicy.keyAccessed(key);
        } catch (StorageFullException ex) {

            Key evictKey = this.evictionPolicy.evictKey();
            this.storageService.removeKey(key);
            System.out.println("Key is evicted===" + evictKey);
            put(key, value);

        }
    }

    public Value get(Key key) {
        Value value = this.storageService.getKey(key);
        this.evictionPolicy.keyAccessed(key);
        return value;
    }

}
