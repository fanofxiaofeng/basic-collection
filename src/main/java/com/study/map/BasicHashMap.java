package com.study.map;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

public class BasicHashMap<K, V> extends AbstractMap<K, V> {
    private int size = 0;

    private Object[] table = new Object[16];

    private static class Node<K, V> {
        private K key;
        private int hash;
        private V value;
        private Node<K, V> next;

        Node(K key, int hash, V value, Node<K, V> next) {
            this.key = key;
            this.hash = hash;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    @Override
    public V get(Object key) {
        int hash = key == null ? 0 : key.hashCode();
        int bucket = (table.length) & hash;
        Node<K, V> e = (Node<K, V>) table[bucket];
        while (e != null) {
            if (key == e.key || (key != null && (key.equals(e.key)))) {
                return e.value;
            }
            e = e.next;
        }
        return null;
    }


    @Override
    public V put(K key, V value) {
        int hash = key == null ? 0 : key.hashCode();
        int bucket = (table.length) & hash;

        Node<K, V> node = new Node<K, V>(key, hash, value, null);
        if (table[bucket] == null) {
            table[bucket] = node;
            size++;
            return null;
        } else {
            Node<K, V> e = (Node<K, V>) table[bucket];
            while (true) {
                if (e.key == key || (key != null && (key.equals(e.key)))) {
                    V old = e.value;
                    e.value = value;
                    return old;
                }
                if (e.next == null) {
                    break;
                }
                e = e.next;
            }
            e.next = node;
            size++;
            return null;
        }
    }

    @Override
    public V remove(Object key) {
        return super.remove(key);
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Map<Integer, String> map = new BasicHashMap<Integer, String>();
        map.put(1, "1");
        System.out.println(map.get(1));
        map.put(1, "2");
        System.out.println(map.get(1));
        map.put(1, "4");
        System.out.println(map.get(1));
//        System.out.println(map.size());
    }
}
