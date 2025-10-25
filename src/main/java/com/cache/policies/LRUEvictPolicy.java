package com.cache.policies;

import com.cache.algorithm.DoubleLinkList;
import com.cache.algorithm.Node;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictPolicy<Key> implements EvictionPolicy<Key> {

    private DoubleLinkList<Key> dll;
    private Map<Key, Node<Key>> mapper;

    public LRUEvictPolicy() {
        this.dll = new DoubleLinkList<>();
        this.mapper = new HashMap<>();

    }

    @Override
    public void keyAccessed(Key key) {

        if (mapper.containsKey(key)) {
            dll.detachNode(mapper.get(key));
            dll.attachNodeAfterHead(mapper.get(key));

        } else {
            Node<Key> node = new Node<>(key);
            this.dll.attachNodeAfterHead(node);
            this.mapper.put(key, node);
        }

    }

    @Override
    public Key evictKey() {
        Node<Key> tail = dll.getDummyTail();
        dll.detachNode(tail.getPrev());
        return tail.getPrev().getValue();
    }
}
