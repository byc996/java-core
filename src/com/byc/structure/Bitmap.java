package com.byc.structure;

public class Bitmap {
    private byte[] bitmap;

    public Bitmap(int size) {
        // 计算需要多少个byte来表示位图
        int byteSize = (size + 7) / 8;
        bitmap = new byte[byteSize];
    }

    // 设置第index位为1
    public void set(int index) {
        if (index < 0 || index >= bitmap.length * 8) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        int byteIndex = index / 8;
        int bitIndex = index % 8;
        bitmap[byteIndex] |= (1 << bitIndex);
    }

    // 设置第index位为0
    public void clear(int index) {
        if (index < 0 || index >= bitmap.length * 8) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        int byteIndex = index / 8;
        int bitIndex = index % 8;
        bitmap[byteIndex] &= ~(1 << bitIndex);
    }

    // 获取第index位的值
    public boolean get(int index) {
        if (index < 0 || index >= bitmap.length * 8) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        int byteIndex = index / 8;
        int bitIndex = index % 8;
        return (bitmap[byteIndex] & (1 << bitIndex)) != 0;
    }

    public static void main(String[] args) {
        Bitmap bitmap = new Bitmap(100);
        bitmap.set(0);
        bitmap.set(1);
        bitmap.set(63);
        bitmap.set(64);
        bitmap.clear(1);
        System.out.println(bitmap.get(0));  // true
        System.out.println(bitmap.get(1));  // false
        System.out.println(bitmap.get(63)); // true
        System.out.println(bitmap.get(64)); // true
    }
}
