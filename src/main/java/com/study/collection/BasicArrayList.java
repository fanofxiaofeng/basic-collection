package com.study.collection;

import java.util.AbstractList;
import java.util.Arrays;

/**
 * 大量参考了(或者说 copy 了?) jdk 中的 ArrayList 源码
 * 为了简易期见, BasicArrayList 中只实现基本的增删改查功能
 * 其中增包括 add(int), add(int, E)
 * 删只有 remove(int)
 * 改只有 set(int, E)
 * 查只有 get(int)
 */
public class BasicArrayList<E> extends AbstractList<E> {

    private Object[] elementData = new Object[10];

    private int size;

    @Override
    public boolean add(E e) {
        ensureCapacity(size + 1);
        elementData[size] = e;
        size++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        E old = (E) elementData[index];
        System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
        elementData[size - 1] = null;
        size--;
        return old;
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        E old = (E) elementData[index];
        elementData[index] = element;
        return old;
    }

    public E get(int index) {
        rangeCheck(index);
        return (E) elementData[index];
    }

    public int size() {
        return size;
    }

    public BasicArrayList() {
    }


    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(String.format("index: %s, size: %s", index, size));
        }
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("index: %s, size: %s", index, size));
        }
    }

    private void ensureCapacity(int min) {
        int oldCapacity = elementData.length;
        if (min <= oldCapacity) {
            return;
        }
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        min = Math.max(min, newCapacity);
        elementData = Arrays.copyOf(elementData, min);
    }

    public static void main(String[] args) {
        BasicArrayList<Integer> list = new BasicArrayList<Integer>();
    }
}
