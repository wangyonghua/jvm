package com.jvm.test;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;

/**
 * Created by wangyonghua on 2017/9/2.
 */

//-Xms100m -Xmx100m -XX:+UseSerialGC
public class TestMemory {
    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024 * 40];
    }

    public static void fillHeap(int num) throws InterruptedException {
        ArrayList<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(ManagementFactory.getRuntimeMXBean().getName());
        System.out.println("start");
        Thread.sleep(10000);
        fillHeap(30);
        fillHeap(50);
        Thread.sleep(20000);
        System.out.println("end");
    }
}
