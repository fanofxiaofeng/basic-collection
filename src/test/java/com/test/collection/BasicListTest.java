package com.test.collection;

import org.junit.Assert;

import java.util.List;
import java.util.Random;

public abstract class BasicListTest {
    void all(List<Integer> standard, List<Integer> fake, final int n) {
        for (int i = 0; i < n; i++) {
            ListOperation operation = ListOperation.randomOperation();
            String detail = "";
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
                    detail = String.format("add [%s] to index %s", randomElement, randomIndex);
                    break;
                }
                case REMOVE: {
                    if (standard.size() == 0) {
                        continue;
                    }
                    int randomIndex = new Random().nextInt(standard.size());
                    standard.remove(randomIndex);
                    fake.remove(randomIndex);
                    detail = String.format("remove index %s", randomIndex);
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
                    detail = String.format("get index %s", randomIndex);
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
                    detail = String.format("set index %s with %s", randomIndex, randomElement);
                    break;
                }
                default:
                    break;
            }
            if (detail.isEmpty()) {
                System.out.println("after " + operation);
            } else {
                System.out.println(String.format("after %s %s", operation, detail));
            }
            System.out.println(standard.toString() + " <- standard");
            System.out.println(fake.toString() + " <- fake");
            Assert.assertEquals(standard.toString(), fake.toString());
        }
    }

    void appendingOperationPerformance(List<Integer> standard, List<Integer> fake, int N) throws Exception {
        long delta1 = append(standard, N);
        long delta2 = append(fake, N);

        System.out.println(delta1);
        System.out.println(delta2);
        Assert.assertEquals(standard.size(), fake.size());
        Assert.assertTrue(delta2 <= delta1);
    }

    private long append(List<Integer> list, int N) {
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long t2 = System.currentTimeMillis();
        return t2 - t1;
    }
}
