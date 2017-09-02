package com.jvm.test;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;

/**
 * Created by wangyonghua on 2017/9/3.
 */

//-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=F:\dump
//内存堆存储快照 memory analyze分析工具
public class HeapOOM {
    static class OOMObject1 {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(ManagementFactory.getRuntimeMXBean().getName());
        ArrayList<OOMObject1> list = new ArrayList<>();
        while (true) {
            Thread.sleep(50);
            list.add(new OOMObject1());
        }
    }
}
