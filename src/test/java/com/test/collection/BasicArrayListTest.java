package com.test.collection;

import com.study.collection.BasicArrayList;
import org.junit.Ignore;
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
    @Ignore
    @Test
    public void appendingOperationPerformance() throws Exception {
        ArrayList<Integer> standard = new ArrayList<Integer>();
        BasicArrayList<Integer> fake = new BasicArrayList<Integer>();
        // standard 和 fake 互有胜负
        appendingOperationPerformance(standard, fake, 10000);
    }
}
