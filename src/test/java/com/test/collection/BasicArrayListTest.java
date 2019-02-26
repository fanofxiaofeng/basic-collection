package com.test.collection;

import com.study.collection.BasicArrayList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class BasicArrayListTest extends BasicListTest {

    /**
     * 测试 BasicArrayList 的所有功能(其实就是测试5个函数能否正确运转)
     */
    @Test
    public void all() {
        ArrayList<Integer> standard = new ArrayList<Integer>();
        BasicArrayList<Integer> fake = new BasicArrayList<Integer>();
        all(standard, fake, 50);
    }

    /**
     * 测试 BasicArrayList 的性能(仅限于在 List 末尾添加元素的操作)
     */
    @Test
    public void performance() {
        ArrayList<Integer> standard = new ArrayList<Integer>();
        BasicArrayList<Integer> fake = new BasicArrayList<Integer>();

        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            standard.add(i);
        }
        long t2 = System.currentTimeMillis();
        long delta1 = t2 - t1;

        t1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            fake.add(i);
        }
        t2 = System.currentTimeMillis();
        long delta2 = t2 - t1;

        System.out.println(delta1);
        System.out.println(delta2);
        Assert.assertTrue(delta2 <= delta1);
    }
}
