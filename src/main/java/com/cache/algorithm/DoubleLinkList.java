package com.cache.algorithm;

import lombok.Getter;

@Getter
public class DoubleLinkList<E> {

    Node<E> dummyHead;
    Node<E> dummyTail;

    public DoubleLinkList() {
        dummyHead = new Node<>(null);
        dummyTail = new Node<>(null);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public void detachNode(Node<E> node) {

        Node<E> prevNode = node.prev;
        Node<E> nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;

    }

    public void attachNodeAfterHead(Node<E> node) {
        node.next = dummyHead.next;
        dummyHead.next.prev = node;
        dummyHead.next = node;
        node.prev = dummyHead;
    }

}
