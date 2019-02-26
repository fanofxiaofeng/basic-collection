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

    @Override
    public void add(int index, E element) {
        checkPosition(index);

        if (index == size) {
            linkLast(element);
        } else {
            linkBefore(index, element);
        }
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        // node 一定不是 null
        Node<E> node = node(index);
        Node<E> prev = node.prev;
        Node<E> next = node.next;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
        }

        node.prev = null;
        node.next = null;
        size--;
        return node.item;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("index is wrong");
        }
    }

    private void checkPosition(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("index is wrong");
        }
    }

    @Override
    public E get(int index) {
        return node(index).item;
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        Node<E> node = node(index);
        E oldValue = node.item;
        node.item = element;
        return oldValue;
    }

    public int size() {
        return size;
    }

    private Node<E> node(int index) {
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private void linkBefore(int index, E e) {
        Node<E> current = new Node<E>(e, null, null);

        // 一定不是 null
        Node<E> next = node(index);
        // 有可能是 null
        Node<E> prev = next.prev;

        current.next = next;
        next.prev = current;

        current.prev = prev;
        if (prev == null) {
            first = current;
        } else {
            prev.next = current;
        }
        size++;
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
