package com.study.collection;

import java.util.AbstractList;

// todo 功能尚未实现
public class BasicLinkedList<E> extends AbstractList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    public E get(int index) {
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.item;
    }

    public int size() {

        return size;
    }

    private void linkLast(E e) {
//        Node<E> l = last;
        Node<E> node = new Node<E>(e, last, null);
        if (first == null) {
            first = node;
            last = node;
        } else {
            last.next = node;
        }
        last = node;
        size++;
    }

    private class Node<E> {
        private E item;
        private Node<E> prev;
        private Node<E> next;

        Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
}
