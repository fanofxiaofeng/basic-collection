package com.test.map;

public enum MapOperation {
    /**
     * 与 {@link java.util.Map#put(Object, Object)} 对应
     */
    ADD,

    /**
     * 与 {@link java.util.Map#remove(Object)} 对应
     */
    REMOVE,

    /**
     * 与 {@link java.util.Map#get(Object)} 对应
     */
    GET,

    /**
     * 与 {@link java.util.Map#put(Object, Object)} 对应
     */
    SET;

    /**
     * 随机挑选一个 MapOperation 元素返回
     *
     * @return 随机挑选到的 MapOperation 元素
     */
    public static MapOperation randomOperation() {
        MapOperation[] values = MapOperation.values();
        int randomIndex = (int) (Math.random() * (values.length));
        return values[randomIndex];
    }
}
