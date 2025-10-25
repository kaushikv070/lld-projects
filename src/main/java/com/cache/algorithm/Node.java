package com.cache.algorithm;

import lombok.Data;
import lombok.Getter;

@Data
public class Node<E> {

             Node<E> prev;
             Node<E> next;
             E value;


            public Node(E element) {
                this.value = element;
                this.prev = null;
                this.next = null;


            }
}
