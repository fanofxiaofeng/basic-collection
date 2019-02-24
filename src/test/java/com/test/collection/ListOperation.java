package com.test.collection;

public enum ListOperation {
    /**
     * 与 {@link java.util.List#add(Object)} 对应
     */
    ADD_LAST,

    /**
     * 与 {@link java.util.List#add(int, Object)} 对应
     */
    ADD_INDEX,

    /**
     * 与 {@link java.util.List#remove(int)} 对应
     */
    REMOVE,

    /**
     * 与 {@link java.util.List#get(int)} 对应
     */
    GET,

    /**
     * 与 {@link java.util.List#set(int, Object)} 对应
     */
    SET;

    /**
     * 随机挑选一个 ListOperation 元素返回
     *
     * @return 随机挑选到的 ListOperation 元素
     */
    public static ListOperation randomOperation() {
        ListOperation[] values = ListOperation.values();
        int randomIndex = (int) (Math.random() * (values.length));
        return values[randomIndex];
    }
}
