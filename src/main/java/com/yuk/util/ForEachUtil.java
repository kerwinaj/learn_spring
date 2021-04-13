package com.yuk.util;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class ForEachUtil {

    public static class Breaker {
        private boolean shouldBreak = false;

        public void stop() {
            shouldBreak = true;
        }

        boolean get() {
            return shouldBreak;
        }
    }

    /**
     * StreamUtil 里有使用到
     */
    public static <T> void forEach(Stream<T> stream, BiConsumer<T, Breaker> consumer) {
        Spliterator<T> spliterator = stream.spliterator();
        boolean hadNext = true;
        Breaker breaker = new Breaker();

        while (hadNext && !breaker.get()) {
            hadNext = spliterator.tryAdvance(elem -> {
                consumer.accept(elem, breaker);
            });
        }
    }

    public static void deleteWhenForEach(List<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("male".equals(item)) {
                iterator.remove();//使用迭代器的删除方法删除
            }
        }
    }

    /**
     * 使用 removeIf, 也是idea自动弹出来的提示
     * @param list
     */
    public static void deleteWhenForEach_method2(List<String> list) {
        list.removeIf(x->"male".equals(x));
    }

    public static void test_deleteWhenForEach() {
        //准备数据
        List<String> list = new ArrayList<>();
        list.add("male");
        list.add("female");
        list.add("female");
        list.add("male");
        System.out.println("[test_deleteWhenForEach]before delete" + list);
        deleteWhenForEach(list);
        System.out.println("[test_deleteWhenForEach]after delete" + list);
    }


    public static void test_deleteWhenForEach_method2() {
        //准备数据
        List<String> list = new ArrayList<>();
        list.add("male");
        list.add("female");
        list.add("female");
        list.add("male");
        System.out.println("[test_deleteWhenForEach_method2]before delete" + list);
        deleteWhenForEach_method2(list);
        System.out.println("[test_deleteWhenForEach_method2]after delete" + list);
    }

    public static void main(String[] args) {
        test_deleteWhenForEach();
        test_deleteWhenForEach_method2();
    }

}
