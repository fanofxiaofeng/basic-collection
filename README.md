# basic-collection
java collection 的简单实现

## BasicArrayList
[BasicArrayList](src/main/java/com/study/collection/BasicArrayList.java)
大量参考了(或者说 copy 了?) jdk 中的 `ArrayList` 的源码
也参考了 [LRH1993/android_interview 中的 arraylist.md](https://github.com/LRH1993/android_interview/blob/master/java/basis/arraylist.md) 等文章

为了简易期见, `BasicArrayList` 中只实现基本的增删改查功能
其中增包括 `add(int)`, `add(int, E)`
删只有 `remove(int)`
改只有 `set(int, E)`
查只有 `get(int)`


