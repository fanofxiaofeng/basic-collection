package com.test.collection;

import com.study.collection.BasicLinkedList;
import org.junit.Ignore;
import org.junit.Test;

import java.util.LinkedList;

public class BasicLinkedListTest extends BasicListTest {
    @Test
    public void all() {
        LinkedList<Integer> standard = new LinkedList<Integer>();
        BasicLinkedList<Integer> fake = new BasicLinkedList<Integer>();
        all(standard, fake, 50);
    }

    @Ignore
    @Test
    public void appendingOperationPerformance() throws Exception {
        LinkedList<Integer> standard = new LinkedList<Integer>();
        BasicLinkedList<Integer> fake = new BasicLinkedList<Integer>();
        // standard 和 fake 互有胜负
        appendingOperationPerformance(standard, fake, 10000);
    }
}
