package com.test.collection;

import com.study.collection.BasicArrayList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

public class BasicArrayListTest {

    /**
     * 测试 BasicArrayList 的所有功能(其实就是测试5个函数能否正确运转)
     */
    @Test
    public void all() {
        ArrayList<Integer> standard = new ArrayList<Integer>();
        BasicArrayList<Integer> fake = new BasicArrayList<Integer>();
        for (int i = 0; i < 50; i++) {
            ListOperation operation = ListOperation.randomOperation();
            switch (operation) {
                case ADD_LAST: {
                    int randomElement = new Random().nextInt(100);
                    standard.add(randomElement);
                    fake.add(randomElement);
                    break;
                }
                case ADD_INDEX: {
                    int randomIndex = new Random().nextInt(standard.size() + 1);
                    int randomElement = new Random().nextInt(100);
                    standard.add(randomIndex, randomElement);
                    fake.add(randomIndex, randomElement);
                    break;
                }
                case REMOVE: {
                    if (standard.size() == 0) {
                        continue;
                    }
                    int randomIndex = new Random().nextInt(standard.size());
                    standard.remove(randomIndex);
                    fake.remove(randomIndex);
                    break;
                }
                case GET: {
                    if (standard.size() == 0) {
                        continue;
                    }
                    int randomIndex = new Random().nextInt(standard.size());
                    int element1 = standard.get(randomIndex);
                    int element2 = standard.get(randomIndex);
                    Assert.assertEquals(element1, element2);
                    break;
                }
                case SET: {
                    if (standard.size() == 0) {
                        continue;
                    }
                    int randomIndex = new Random().nextInt(standard.size());
                    int randomElement = new Random().nextInt(100);
                    standard.set(randomIndex, randomElement);
                    fake.set(randomIndex, randomElement);
                    break;
                }
                default:
                    break;
            }
            System.out.println("after " + operation);
            System.out.println(standard.toString() + " <- standard");
            System.out.println(fake.toString() + " <- fake");
            Assert.assertEquals(standard.toString(), fake.toString());
        }
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
