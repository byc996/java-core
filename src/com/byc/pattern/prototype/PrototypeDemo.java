package com.byc.pattern.prototype;

import java.util.Scanner;

// 抽象原型类
abstract class Prototype implements Cloneable {
    public abstract Prototype clone();

    public abstract String getDetails();

    // 公共的 clone ⽅法
    public Prototype clonePrototype() {
        try {
            return (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

// 具体矩形原型类
class RectanglePrototype extends Prototype {
    private String color;
    private int width;
    private int height;
    // 构造⽅法
    public RectanglePrototype(String color, int width, int height) {
        this.color = color;
        this.width = width;
        this.height = height;
    }
    // 克隆⽅法
    @Override
    public Prototype clone() {
        return clonePrototype();
    }
    // 获取矩形的详细信息
    @Override
    public String getDetails() {
        return "Color: " + color + ", Width: " + width + ", Height: " + height;
    }
}
public class PrototypeDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取需要创建的矩形数量
        int N = scanner.nextInt();
        // 读取每个矩形的属性信息并创建矩形对象
        for (int i = 0; i < N; i++) {
            String color = scanner.next();
            int width = scanner.nextInt();
            int height = scanner.nextInt();
            // 创建原型对象
            Prototype originalRectangle = new RectanglePrototype(color, width, height);
            // 克隆对象并输出详细信息
            Prototype clonedRectangle = originalRectangle.clone();
            System.out.println(clonedRectangle.getDetails());
        }
    }
}
