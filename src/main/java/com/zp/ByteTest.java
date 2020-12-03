package com.zp;

import org.openjdk.jol.info.ClassLayout;

import java.util.Date;

/**
 * @Author zp
 * @create 2020/12/1 9:55
 */
public class ByteTest {
    public static void main(String[] args) {
        Date date =new Date();
//        System.out.println(ClassLayout.parseClass(date.getClass()).toPrintable());
        System.out.println(ClassLayout.parseClass(String.class).toPrintable());
        String s = "ab";
        System.out.println(ClassLayout.parseInstance(s.getBytes()).toPrintable());
        Integer i = 0;
        Boolean b = false;
        Double d = 0.0;
//        System.out.println(ClassLayout.parseClass(d.getClass()).toPrintable());
    }
}
