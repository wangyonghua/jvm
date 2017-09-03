package com.jvm.test;

/**
 * stack oom
 * Created by wangyonghua on 2017/9/3.
 */
//vm -Xss128k易导致系统假死
public class JavaVMStackSOF {
    private int stackLength = 1;

    private void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF javaVMStackOOM = new JavaVMStackSOF();
        javaVMStackOOM.stackLeak();
    }
}
