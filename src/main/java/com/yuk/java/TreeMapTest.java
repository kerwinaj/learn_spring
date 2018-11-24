package com.yuk.java;

import com.google.common.collect.Lists;
import com.yuk.java.dto.OrderPool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        test4();
    }

    public static void test1() {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        TreeMap<String, Integer> treeMap1 = new TreeMap<>();
        treeMap.put(7, "h");
        treeMap.put(8, "g");
        treeMap.put(9, "f");
        treeMap.put(10, "e");
        treeMap.put(14, "a");
        treeMap.put(1, "w");
        treeMap.put(2, "v");
        treeMap.put(3, "u");
        treeMap.put(11, "d");
        treeMap.put(12, "c");
        treeMap.put(13, "b");
        treeMap.put(4, "k");
        treeMap.put(5, "j");
        treeMap.put(6, "i");
        System.out.println("----------------------*------------------------------");
        while (treeMap.size() != 0) {
            //treemap自动按照key进行递增排序
            System.out.println(treeMap.firstEntry().getKey() + " - " + treeMap.firstEntry().getValue());
            treeMap1.put(treeMap.firstEntry().getValue(), treeMap.firstEntry().getKey());
            treeMap.remove(treeMap.firstKey());
        }
        System.out.println("----------------------*------------------------------");
        while (treeMap1.size() != 0) {
            //treemap自动按照key进行递增排序
            System.out.println(treeMap1.firstEntry().getKey() + " - " + treeMap1.firstEntry().getValue());
            treeMap1.remove(treeMap1.firstKey());
        }
        System.out.println("----------------------*------------------------------");
    }

    /**
     * 按key降序排
     * TreeMap默认是升序的，如果我们需要改变排序方式，则需要使用比较器：Comparator
     */
    public static void test2(){
        Map<String, String> map = new TreeMap<String, String>(
            new Comparator<String>() {
                public int compare(String obj1, String obj2) {
                    // 降序排序
                    return obj2.compareTo(obj1);
                }
            });
        map.put("b", "ccccc");
        map.put("d", "aaaaa");
        map.put("c", "bbbbb");
        map.put("a", "ddddd");

        Set<String> keySet = map.keySet();
        Iterator<String> iter = keySet.iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            System.out.println(key + ":" + map.get(key));
        }
    }

    /**
     * 根据TreeMap的value来进行排序
     * 对value排序我们就需要借助于Collections的sort(List<T> list, Comparator<? super T> c)方法，该方法根据指定比较器产生的顺序对指定列表进行排序。但是有一个前提条件，那就是所有的元素都必须能够根据所提供的比较器来进行比较，
     */
    public static void test3(){
        Map<String, String> map = new TreeMap<String, String>();
        map.put("a", "ddddd");
        map.put("c", "bbbbb");
        map.put("d", "aaaaa");
        map.put("b", "ccccc");

        //这里将map.entrySet()转换成list
        List<Map.Entry<String,String>> list = new ArrayList<Map.Entry<String,String>>(map.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
            //升序排序
            public int compare(Map.Entry<String, String> o1,
                               Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }

        });

        for(Map.Entry<String,String> mapping:list){
            System.out.println(mapping.getKey()+":"+mapping.getValue());
        }
    }

    public static void test4(){
        Map<String, List<String>> map = new TreeMap<String, List<String>>();
        map = new TreeMap<String, List<String>>(
            new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
        map.put("a", Lists.newArrayList("ddddd"));
        map.put("c", Lists.newArrayList("bbbbb"));
        map.put("d", Lists.newArrayList("aaaaa1"));
        map.get("d").add("aaaaa2");
        map.put("b", Lists.newArrayList("ccccc"));

        System.out.println(map.get("a"));
        for(Map.Entry<String,List<String>> mapping:map.entrySet()){
            System.out.println(mapping.getKey()+":"+mapping.getValue());
        }

        Map<Integer, List<String>> map2 = new TreeMap<Integer, List<String>>(
            new Comparator<Integer>() {
                // key, node
                @Override
                public int compare(Integer o1, Integer o2) {
                    //return o1 > o2 ? -1 : 1;
                    if(o1 > o2){
                        return 1;//取right node
                    } else if (o1 < o2){
                        return -1;//取left node
                    } else {
                        return 0;
                    }
                }
            });
        //map2 = new TreeMap<Integer, List<String>>();
        map2.put(1, Lists.newArrayList("ddddd"));
        map2.put(2, Lists.newArrayList("bbbbb"));
        map2.put(3, Lists.newArrayList("aaaaa1"));
        map2.get(3).add("aaaaa2");
        map2.put(4, Lists.newArrayList("ccccc"));

        System.out.println(map2.keySet().size());
        System.out.println(map2.get(3));
        for(Map.Entry<Integer,List<String>> mapping:map2.entrySet()){
            System.out.println(mapping.getKey()+":"+mapping.getValue());
        }
    }

}
