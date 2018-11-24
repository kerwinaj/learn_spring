package com.yuk.java;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalTest2 {
    public static class DemoTask implements Runnable {

        // Atomic integer containing the next thread ID to be assigned
        private static final AtomicInteger nextId = new AtomicInteger(0);

        // Thread local variable containing each thread's ID
        private static final ThreadLocal<Integer> threadId =
            new ThreadLocal<Integer>() {
                @Override
                protected Integer initialValue() {
                    return nextId.getAndIncrement();
                }
            };

        // Returns the current thread's unique ID, assigning it if necessary
        public int getThreadId() {
            return threadId.get();
        }

        // Returns the current thread's starting timestamp
        private static final ThreadLocal<Date> startDate =
            new ThreadLocal<Date>() {
                protected Date initialValue() {
                    return new Date();
                }
            };

        @Override
        public void run() {
            System.out.printf("Starting Thread: %s : %s\n",
                getThreadId(), startDate.get());
            try {
                TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Thread Finished: %s : %s\n",
                getThreadId(), startDate.get());
        }
    }

    public static void main(String[] args) throws Exception {
        DemoTask demoTask = new DemoTask();
        Thread thread1 = new Thread(demoTask);
        Thread thread2 = new Thread(demoTask);
        Thread thread3 = new Thread(demoTask);
        thread1.start();
        TimeUnit.SECONDS.sleep(2L);
        thread2.start();
        TimeUnit.SECONDS.sleep(2L);
        thread3.start();
    }

}
