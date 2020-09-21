package com.yuk.util;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
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

    public static void main(String[] args) {
        List<String> list = Arrays.asList("123", "45634", "7892", "abch", "sdfhrthj", "mvkd");
        list.forEach(System.out::println);
        list = null;
        list.forEach(System.out::println);
    }

}
