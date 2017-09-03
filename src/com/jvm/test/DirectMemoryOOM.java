package com.jvm.test;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by wangyonghua on 2017/9/3.
 */
//本机直接内存溢出
//vm -Xms20M -XX:MaxDirectMemorySize=10M
//容易导致系统假死
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
