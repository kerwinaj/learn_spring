package com.yuk.util;

import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author YUK
 */
public class SetUtil {

    public static void main(String[] args) {
        Set<String> set1 = new HashSet<String>() {
            {
                add("王者荣耀");
                add("英雄联盟");
                add("穿越火线");
                add("地下城与勇士");
            }
        };

        Set<String> set2 = Sets.newHashSet("王者荣耀", "地下城与勇士", "魔兽世界");

        setCalc(set1, set2);
        convertSet2Array();
    }

    /**
     * https://blog.csdn.net/silentwolfyh/article/details/74938819
     * https://blog.csdn.net/wenniuwuren/article/details/46319103
     * 好像还有很多的专栏
     *
     * 集合的交集, 并集, 补集
     */
    public static void setCalc(Set<String> set1, Set<String> set2) {

        Set<String> result = Sets.newHashSet();

        System.out.println("set1 origin:" + set1);
        System.out.println("set2 origin:" + set2);

        result.clear();
        result.addAll(set1);
        result.retainAll(set2);
        System.out.println("交集, size:" + result.size() + ", content:" + result);
        Sets.SetView<String> intersection = Sets.intersection(set1, set2);
        System.out.println("交集, size:" + intersection.size() + ", content:" + intersection);

        Sets.SetView<String> symmetricDifference = Sets.symmetricDifference(set1, set2);
        System.out.println("返回两个集合互斥集合, size:" + symmetricDifference.size() + ", content" + symmetricDifference);

        result.clear();
        result.addAll(set1);
        result.removeAll(set2);
        System.out.println("差集(set1-set2), size:" + result.size() + ", content:" + result);
        Sets.SetView<String> difference1 = Sets.difference(set1, set2);
        System.out.println("差集(set1-set2), size:" + difference1.size() + ", content:" + difference1);

        result.clear();
        result.addAll(set2);
        result.removeAll(set1);
        System.out.println("差集(set2-set1), size:" + result.size() + ", content:" + result);
        Sets.SetView<String> difference2 = Sets.difference(set2, set1);
        System.out.println("差集(set2-set1), size:" + difference2.size() + ", content:" + difference2);

        result.clear();
        result.addAll(set1);
        result.addAll(set2);
        System.out.println("并集, size:" + result.size() + ", content:" + result);
        Sets.SetView<String> union = Sets.union(set1, set2);
        System.out.println("并集, size:" + union.size() + ", content:" + union);


        System.out.println("set1 finally:" + set1);
        System.out.println("set2 finally:" + set2);
    }

    public static String[] convertSet2Array(){
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");

        String[] array = new String[set.size()];
        set.toArray(array);

        System.out.println("Array: " + Arrays.toString(array));
        return array;
    }


}
