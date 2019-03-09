package com.test.map;

import com.study.map.BasicHashMap;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Random;

public class BasicHashMapTest {
    @Test
    public void naive() {
        HashMap<Integer, String> standard = new HashMap<Integer, String>();
        BasicHashMap<Integer, String> fake = new BasicHashMap<Integer, String>();
        for (int i = 0; i < 20; i++) {
            MapOperation operation = MapOperation.randomOperation();
            switch (operation) {
                case ADD: {
                    int randomKey = new Random().nextInt(100);
                    String randomValue = "" + new Random().nextDouble();
                    standard.put(randomKey, randomValue);
                    fake.put(randomKey, randomValue);
                }
                // todo 尚未完工
                case REMOVE: {

                }
                // todo 尚未完工
                case GET: {

                }
                // todo 尚未完工
                case SET: {

                }
            }
            Assert.assertEquals(standard.size(), fake.size());
        }
        for (int key : standard.keySet()) {
            String expected = standard.get(key);
            String real = fake.get(key);
            System.out.println(expected);
            System.out.println(real);
            Assert.assertEquals(expected, real);
            System.out.println();
        }
    }
}
