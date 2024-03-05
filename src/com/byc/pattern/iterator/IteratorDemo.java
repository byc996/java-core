package com.byc.pattern.iterator;

import java.util.ArrayList;
import java.util.List;

interface Iterator {
    // 检查是否还会有下⼀个元素
    boolean hasNext();
    // 获取下⼀个元素
    Object next();
}

class ConcreteIterator implements Iterator {
    private int index;
    private List<Object> elements;
    // 构造函数初始化迭代器
    public ConcreteIterator(List<Object> elements) {
        this.elements = elements;
        this.index = 0;
    }
    @Override
    public boolean hasNext() {
        return index < elements.size();
    }
    @Override
    public Object next() {
        if (hasNext()) {
            return elements.get(index++);
        }
        return null;
    }
}

interface Iterable {
    Iterator createIterator();
}

// 具体聚合
class ConcreteIterable implements Iterable {
    private List<Object> elements;
    // 构造函数初始化可迭代对象
    public ConcreteIterable(List<Object> elements) {
        this.elements = elements;
    }
    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(elements);
    }
}
public class IteratorDemo {

    public static void main(String[] args) {
        List<Object> elements = new ArrayList<>();
        elements.add("Element 1");
        elements.add("Element 2");
        elements.add("Element 3");
        Iterable iterable = new ConcreteIterable(elements);
        Iterator iterator = iterable.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
