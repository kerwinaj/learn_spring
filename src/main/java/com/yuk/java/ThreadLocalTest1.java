package com.yuk.java;

public class ThreadLocalTest1 {

        public static class MyRunnable implements Runnable {

            private ThreadLocal threadLocal = new ThreadLocal();

            @Override
            public void run() {
                threadLocal.set((int) (Math.random() * 100D));
                LocalTag.data.set((int) (Math.random() * 100D));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {

                }
                System.out.println(Thread.currentThread().getName()+":"+ threadLocal.get()+",:" + LocalTag.data.get());
            }
        }

        public static void main(String[] args) {
            MyRunnable sharedRunnableInstance = new MyRunnable();
            Thread thread1 = new Thread(sharedRunnableInstance);
            Thread thread2 = new Thread(sharedRunnableInstance);
            thread1.start();
            thread2.start();
        }

    public static class LocalTag {
        public static ThreadLocal<Integer> data = new ThreadLocal<Integer>() {
            @Override
            public Integer initialValue() {
                return 0;
            }
        };

        public void put(Integer value) {
            data.set(value);
        }

        public Integer get() {
            return data.get();
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}
