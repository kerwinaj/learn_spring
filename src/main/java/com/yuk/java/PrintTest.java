package com.yuk.java;

import com.google.common.collect.Lists;

import java.util.List;

public class PrintTest {
    public static void main(String[] args) {
        printList();
    }

    public static void printList(){
        List<Long> orderNoList = Lists.newArrayList();
        orderNoList.add(1542789430983040L);
        orderNoList.add(1542789524318449L);
        orderNoList.add(1542791226909180L);
        orderNoList.add(1542790113000802L);
        System.out.println("orderNoList:"+orderNoList);
    }
}
