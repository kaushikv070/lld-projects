package com.cache.policies;

public interface EvictionPolicy<key> {
    void keyAccessed(key key);
    key evictKey();
}
