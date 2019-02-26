package com.test.collection;

import com.study.collection.BasicLinkedList;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Random;

public class BasicLinkedListTest {
    @Test
    public void all() {
        LinkedList<Integer> standard = new LinkedList<Integer>();
        BasicLinkedList<Integer> fake = new BasicLinkedList<Integer>();
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
}
