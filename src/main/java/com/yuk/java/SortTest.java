package com.yuk.java;

import com.google.common.collect.Lists;
import com.yuk.java.dto.OrderPool;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortTest {
    public static void main(String[] args) {

        List<OrderPool> orderPoolList = new ArrayList();
        getPriorityOrder(orderPoolList);
        System.out.println("PriorityOrder get:"+orderPoolList);
        //System.out.println(Arrays.toString(orderPoolList.toArray()));


        List<OrderPool> test1Result = test1(orderPoolList);

        List<OrderPool> test2Result = sortOrderPool(orderPoolList);
        System.out.println("priorityOrder after sort:"+test2Result);

        List<Long> test2ResultLong = Lists.newArrayList();
        for (OrderPool orderPool : test2Result) {
            test2ResultLong.add(orderPool.getOrderNo());
        }

        List<OrderPool> bigPriceResult = Lists.newArrayList();
        List<OrderPool> smallPriceResult = Lists.newArrayList();

        getPriceOrder(bigPriceResult, smallPriceResult);

        filterPriorityOrderList(test2ResultLong, bigPriceResult);
        test2Result.addAll(bigPriceResult);

        filterPriorityOrderList(test2ResultLong, smallPriceResult);
        test2Result.addAll(smallPriceResult);

        System.out.println("添加完price Order: "+test2Result);
        Map<Long, List<OrderPool>> map = getOrderMap(test2Result);
        System.out.println("按照cid分组后:"+map);
    }

    /**
     * 这些订单设置了priority
     * @param orderPoolList
     */
    private static void getPriorityOrder(List<OrderPool> orderPoolList){
        for (int i = 0; i < 5; i++) {
            OrderPool orderPool = new OrderPool();
            orderPool.setOrderNo(Long.valueOf(i));
            if (i % 2 == 0) {
                orderPool.setPayTime(i * 2);
            } else {
                orderPool.setPayTime(i);
            }
            if (i % 3 == 0) {
                orderPool.setCategoryId(1L);
            } else if (i % 3 == 1) {
                orderPool.setCategoryId(2L);
            } else if (i % 3 == 2) {
                orderPool.setCategoryId(3L);
            }
            orderPool.setPriority(2);
            orderPoolList.add(orderPool);
        }

        for (int i = 10; i < 15; i++) {
            OrderPool orderPool = new OrderPool();
            orderPool.setOrderNo(Long.valueOf(i));
            if (i % 2 == 0) {
                orderPool.setPayTime(i * 2);
            } else {
                orderPool.setPayTime(i);
            }
            if (i % 3 == 0) {
                orderPool.setCategoryId(1L);
            } else if (i % 3 == 1) {
                orderPool.setCategoryId(2L);
            } else if (i % 3 == 2) {
                orderPool.setCategoryId(3L);
            }
            orderPool.setPriority(5);
            orderPoolList.add(orderPool);
        }

        for (int i = 5; i < 10; i++) {
            OrderPool orderPool = new OrderPool();
            orderPool.setOrderNo(Long.valueOf(i));
            if (i % 2 == 0) {
                orderPool.setPayTime(i * 2);
            } else {
                orderPool.setPayTime(i);
            }
            if (i % 3 == 0) {
                orderPool.setCategoryId(1L);
            } else if (i % 3 == 1) {
                orderPool.setCategoryId(2L);
            } else if (i % 3 == 2) {
                orderPool.setCategoryId(3L);
            }
            orderPool.setPriority(10);
            orderPoolList.add(orderPool);
        }
    }

    /**
     * 这些订单没有设置priority
     */
    private static void getPriceOrder(List<OrderPool> bigPriceResult, List<OrderPool> smallPriceResult){
        for (int i = 25; i < 30; i++) {
            OrderPool orderPool = new OrderPool();
            if (i % 2 == 0) {
                orderPool.setOrderNo(Long.valueOf(i-25));
            } else {
                orderPool.setOrderNo(Long.valueOf(i));
            }

            if (i % 2 == 0) {
                orderPool.setPayTime(i * 2);
            } else {
                orderPool.setPayTime(i);
            }
            if (i % 3 == 0) {
                orderPool.setCategoryId(1L);
            } else if (i % 3 == 1) {
                orderPool.setCategoryId(2L);
            } else if (i % 3 == 2) {
                orderPool.setCategoryId(3L);
            }
            orderPool.setPrice(1000D+i);
            orderPool.setPriority(0);
            bigPriceResult.add(orderPool);
        }

        for (int i = 15; i < 20; i++) {
            OrderPool orderPool = new OrderPool();
            if (i % 2 == 0) {
                orderPool.setOrderNo(Long.valueOf(i));
            } else {
                orderPool.setOrderNo(Long.valueOf(i-15));
            }
            if (i % 2 == 0) {
                orderPool.setPayTime(i * 2);
            } else {
                orderPool.setPayTime(i);
            }
            if (i % 3 == 0) {
                orderPool.setCategoryId(1L);
            } else if (i % 3 == 1) {
                orderPool.setCategoryId(2L);
            } else if (i % 3 == 2) {
                orderPool.setCategoryId(3L);
            }
            orderPool.setPrice(100D+i);
            orderPool.setPriority(0);
            smallPriceResult.add(orderPool);
        }
    }

    /**
     * 有问题, treemap不会分组
     *
     * @param orderPoolList
     * @return
     */
    public static List<OrderPool> test1(List<OrderPool> orderPoolList) {
        List<OrderPool> returnOrderPoolList = Lists.newArrayListWithCapacity(orderPoolList.size());
        // 按照优先级降序
        Map<Integer, List<OrderPool>> orderPoolMapByPriority = new TreeMap<Integer, List<OrderPool>>(
            new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 > o2 ? -1 : 1;
                }
            });
        orderPoolMapByPriority.put(10, Lists.newArrayList(orderPoolList.get(0)));
        System.out.println(orderPoolMapByPriority.get(10));
        for (OrderPool orderPool : orderPoolList) {
            if (orderPoolMapByPriority.containsKey(orderPool.getPriority())) {
                List<OrderPool> orderPoolList4Priority = orderPoolMapByPriority.get(orderPool.getPriority());
                orderPoolList4Priority.add(orderPool);
                // 相同优先级, 按照paytime升序
                Collections.sort(orderPoolList4Priority, new Comparator<OrderPool>() {
                    @Override
                    public int compare(OrderPool o1, OrderPool o2) {
                        return o1.getPayTime() > o2.getPayTime() ? 1 : -1;
                    }
                });
            } else {
                List<OrderPool> orderPoolList4Priority = Lists.newArrayList();
                orderPoolList4Priority.add(orderPool);
                orderPoolMapByPriority.put(orderPool.getPriority(), orderPoolList4Priority);
            }
        }
        for (Map.Entry<Integer, List<OrderPool>> entry : orderPoolMapByPriority.entrySet()) {
            System.out.println("key:"+entry.getKey()+",value:"+entry.getValue());
            returnOrderPoolList.addAll(entry.getValue());
        }
        return returnOrderPoolList;
    }

    /**
     * 将orderPoolList按照2层排序, 外层按照priority降序, 内层按照paytime升序
     * @param orderPoolList
     * @return
     */
    public static List<OrderPool> sortOrderPool(List<OrderPool> orderPoolList) {
        List<OrderPool> returnOrderPoolList = Lists.newArrayListWithCapacity(orderPoolList.size());
        // 按照优先级降序
        Map<Integer, List<OrderPool>> orderPoolMapByPriority = new HashMap<>();
        for (OrderPool orderPool : orderPoolList) {
            if (orderPoolMapByPriority.containsKey(orderPool.getPriority())) {
                List<OrderPool> orderPoolList4Priority = orderPoolMapByPriority.get(orderPool.getPriority());
                orderPoolList4Priority.add(orderPool);
                // 相同优先级, 按照paytime升序
                Collections.sort(orderPoolList4Priority, new Comparator<OrderPool>() {
                    @Override
                    public int compare(OrderPool o1, OrderPool o2) {
                        // 1就会调换,-1不调换
                        return o1.getPayTime() > o2.getPayTime() ? 1 : -1;
                    }
                });
            } else {
                List<OrderPool> orderPoolList4Priority = Lists.newArrayList();
                orderPoolList4Priority.add(orderPool);
                orderPoolMapByPriority.put(orderPool.getPriority(), orderPoolList4Priority);
            }
        }

        //Object[]   key   =     orderPoolMapByPriority.keySet().toArray();
        //Arrays.sort(key);

        List<Integer> arrayList = new ArrayList(orderPoolMapByPriority.keySet());
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 1就会调换,-1不调换
                return o1 > o2 ? -1 : 1;
            }
        });

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println("每个优先级对应的list:"+orderPoolMapByPriority.get(arrayList.get(i)));
            returnOrderPoolList.addAll(orderPoolMapByPriority.get(arrayList.get(i)));
        }
        return returnOrderPoolList;
    }

    /**
     * 经过这个方法之后, 每个cid对于的orderpool都是按照上面说的排序进行排序的
     * @param orderPoolList
     * @return
     */
    private static Map<Long, List<OrderPool>> getOrderMap(List<OrderPool> orderPoolList) {
        if (CollectionUtils.isEmpty(orderPoolList)) {
            return null;
        }

        Map<Long, List<OrderPool>> map = new HashMap<Long, List<OrderPool>>();

        OrderPool orderPool;
        Long key;
        List<OrderPool> categoryList;
        for (int i = 0; i < orderPoolList.size(); i++) {
            orderPool = orderPoolList.get(i);

            key = orderPool.getCategoryId();

            categoryList = map.get(key);
            if (categoryList == null) {
                categoryList = new ArrayList<OrderPool>();
                map.put(key, categoryList);
            }
            categoryList.add(orderPool);
        }

        return map;
    }

    /**
     * 过滤设置了优先级的订单
     * @param priorityOrderNoList
     * @param orderPoolList
     */
    private static void filterPriorityOrderList(List<Long> priorityOrderNoList, List<OrderPool> orderPoolList){
        Iterator<OrderPool> iterator = orderPoolList.iterator();
        while(iterator.hasNext()){
            if(priorityOrderNoList.contains(iterator.next().getOrderNo())){
                iterator.remove();
            }
        }
    }
}
