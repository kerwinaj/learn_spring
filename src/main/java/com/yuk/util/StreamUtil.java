package com.yuk.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamUtil {

    public static void main(String[] args) {
        testForEach_continue();
        testForEach_break_method1();
        testForEach_break_method2();
    }

    /**
     * 在Java8的foreach()中不能break，如果需要continue时，可以使用return
     * https://stackoverflow.com/questions/32654929/move-to-next-item-using-java-8-foreach-loop-in-stream
     *      可以使用 filter, 比用return更直观
     */
    public static void testForEach_continue() {

        List<String> list = Arrays.asList("123", "45634", "7892", "abch", "sdfhrthj", "mvkd");

        list.forEach(e ->{
            if(e.length() >= 5){
                return;
            }
            System.out.println(e);
        });
        System.out.println("list 1:" + list);

        list.stream().forEach(e ->{
            if(e.length() >= 5){
                return;
            }
            System.out.println(e);
        });
        System.out.println("list 2:" + list);

        // 等同于下面用filter的方法
        list.stream().filter(e -> e.length()<5).forEach(System.out::println);
        System.out.println("list 3:" + list);
    }

    /**
     * https://www.baeldung.com/java-break-stream-foreach
     */
    public static void testForEach_break_method1(){
        Stream<String> stream = Stream.of("cat", "dog", "elephant", "fox", "rabbit", "duck");
        // takeWhile is in jdk9
//        stream.takeWhile(n -> n.length() % 2 != 0)
//                .forEach(System.out::println);
    }

    public static void testForEach_break_method2(){
        Stream<String> stream = Stream.of("cat", "dog", "elephant", "fox", "rabbit", "duck");
        List<String> result = new ArrayList<>();
        ForEachUtil.forEach(stream, (elem, breaker) -> {
            if (elem.length() % 2 == 0) {
                breaker.stop();
            } else {
                result.add(elem);
            }
            System.out.println("inner:"+elem);
        });
        System.out.println("result:"+result+",stream:");
        /**
         * Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
         * https://www.cnblogs.com/kakaxisir/p/5755507.html
         * https://stackoverflow.com/questions/34677708/why-is-this-java-stream-operated-upon-twice
         * Stream学习过程中遇到的一个问题记录.pdf
         */
        stream.forEach(System.out::println);
    }
}