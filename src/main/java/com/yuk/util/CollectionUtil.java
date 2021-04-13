package com.yuk.util;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 集合类常见操作
 * Created by yuk on 2020/11/19.
 * 整合自:MoreCollections(chenwei) 和 com.xiaopeng.common_component.util.CollectionUtil
 */

public class CollectionUtil {


    public static <T> T defaultMerge(T a1, T a2) {
        return a1;
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    /**
     * 对于传入的item collection，按照keyFunction提取item key。返回 键为item key、值为item本身的Map
     * <p>
     * 例：传入学生集合，返回学号作为键的map
     * <p>
     * items -> { keyFunction(item) : item }
     */
    public static <T, K> Map<K, T> uniqueIndex(Collection<T> collection, Function<? super T, ? extends K> keyFunction) {
        return toMap(collection, keyFunction, Function.identity(), (k, v) -> {
            throw new IllegalStateException(String.format("Duplicate key %s", k));
        });
    }

    /**
     * 对于传入的item collection，按照keyFunction提取item key。返回 键为item key、值为item本身的Map
     * <p>
     * 例：传入学生集合，返回学号作为键的map
     * <p>
     * items -> { keyFunction(item) : item }
     */
    public static <T, K> Map<K, T> uniqueIndex(Collection<T> collection, Function<? super T, ? extends K> keyFunction, BinaryOperator<T> mergeFunction) {
        if (null == mergeFunction) {
            return toMap(collection, keyFunction, Function.identity(), CollectionUtil::defaultMerge);
        }
        return toMap(collection, keyFunction, Function.identity(), mergeFunction);
    }

    /**
     * 对于传入的item collection，按照classifier分组，返回 键为item key、值为grouped items的Map
     * <p>
     * 例：传入学生集合，返回按照班级分组的map，值为该班级的学生列表。
     * <p>
     * items -> { classifier(item) : grouped items }
     */
    public static <T, K> Map<K, List<T>> groupByToList(Collection<T> collection, Function<? super T, ? extends K> classifier) {
        if (collection == null) {
            return null;
        }
        Stream<T> nullStream = collection.stream().filter(x -> classifier.apply(x) == null);
        Stream<T> nonNullStream = collection.stream().filter(x -> classifier.apply(x) != null);

        List<T> nullCollect = nullStream.collect(Collectors.toList());

        Map<K, List<T>> nonNullCollect = nonNullStream.collect(Collectors.groupingBy(classifier, Collectors.toList()));
        if (nullCollect != null && !nullCollect.isEmpty()) {
            nonNullCollect.put(null, nullCollect);
        }

        return nonNullCollect;
    }

    /**
     * 对于传入的item collection，按照classifier分组，返回 键为item key、值为grouped items的Map
     * <p>
     * 例：传入学生集合，返回按照班级分组的map，值为该班级的学生集合（去重）。
     * <p>
     * items -> { classifier(item) : grouped items }
     */
    public static <T, K> Map<K, Set<T>> groupByToSet(Collection<T> collection, Function<? super T, ? extends K> classifier) {
        if (collection == null) {
            return null;
        }

        return collection.stream().collect(Collectors.groupingBy(classifier, Collectors.toSet()));
    }

    /**
     * 对collection按照mapFunction映射，并collect成Set
     */
    public static <T, K> Set<K> toSet(Collection<T> collection
            , Function<? super T, ? extends K> mapFunction) {
        return toSet(collection, x -> true, mapFunction);
    }

    /**
     * 对collection按照mapFunction映射，并collect成Set
     */
    public static <T, K> Set<K> toSet(Collection<T> collection
            , Predicate<T> filterFunction, Function<? super T, ? extends K> mapFunction) {
        if (collection == null) {
            return null;
        }

        return collection.stream().filter(filterFunction).map(mapFunction).collect(Collectors.toSet());
    }

    /**
     * 对collection按照mapFunction映射，并collect成List
     */
    public static <T, K> List<K> toList(Collection<T> collection
            , Function<? super T, ? extends K> mapFunction) {
        return toList(collection, x -> true, mapFunction);
    }

    /**
     * 对collection按照mapFunction映射，并collect成List
     */
    public static <T, K> List<K> toList(Collection<T> collection
            , Predicate<T> filterFunction, Function<? super T, ? extends K> mapFunction) {
        if (collection == null) {
            return null;
        }

        return collection.stream().filter(filterFunction).map(mapFunction).collect(Collectors.toList());
    }

    /**
     * 对collection按照keyFunction和valueFunction映射成java.util.Map.
     */
    public static <T, K, V> Map<K, V> toMap(Collection<T> collection
            , Function<? super T, ? extends K> keyFunction
            , Function<? super T, ? extends V> valueFunction
            , BinaryOperator<V> mergeFunction) {
        if (collection == null) {
            return null;
        }

        return collection.stream().collect(Collectors.toMap(keyFunction, valueFunction, mergeFunction));
    }

    public static <K, V> Map<K, V> subMap(Map<K, V> originalMap, Set<K> filteredKeySet) {
        if (originalMap == null) {
            return null;
        }
        Set<Map.Entry<K, V>> entries = originalMap.entrySet();
        if (entries.size() == 0 || filteredKeySet == null || filteredKeySet.size() == 0) {
            return originalMap;
        }

        return entries.stream().filter(filteredKeySet::contains).collect(
                Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    // ----------------------------------------获取size------------------------------------------------------
    public static int size(Collection<?> collection) {
        if (isEmpty(collection)) {
            return 0;
        }
        return collection.size();
    }

    public static int size(Map<?, ?> map) {
        if (isEmpty(map)) {
            return 0;
        }
        return map.size();
    }

    public static int size(Object[] objects) {
        if (isEmpty(objects)) {
            return 0;
        }
        return objects.length;
    }

    public static int size(byte[] bytes) {
        if (isEmpty(bytes)) {
            return 0;
        }
        return bytes.length;
    }

    // ----------------------------------------判断是否为Empty------------------------------------------------------
    public static boolean isEmpty(Collection<?> collection) {
        if (collection == null || collection.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    // ------------------------------------------------------
    public static boolean isEmpty(Map<?, ?> map) {
        if (map == null || map.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    // ------------------------------------------------------
    public static boolean isEmpty(Object[] objects) {
        if (objects == null || objects.length == 0) {
            return true;
        }
        return false;
    }

    public static boolean isNotEmpty(Object[] objects) {
        return !isEmpty(objects);
    }

    // ------------------------------------------------------
    public static boolean isEmpty(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return true;
        }
        return false;
    }

    public static boolean isNotEmpty(byte[] bytes) {
        return !isEmpty(bytes);
    }

    // ----------------------------------------------------------------------------------------------

    /**
     * https://blog.csdn.net/YHYR_YCY/article/details/52523243
     *
     * 求在M中找出N的排列数
     * 算法思想：递归
     *  eg:abcd的全排列结果分别为：a,b,c,d,ab,ac,ad,bc,bd,cd,abc,abd,acd,bcd,abcd
     *  可以看出，当求N位的组合数时，可以先固定前N-1位，然后在匹配最后一位可行值；以此类推可用递归的方法求出所有可能的值。
     *
     */
    public static void calcCombination(List<String> m) {
        int n = m.size();

        Set<Set<String>> combinationAll = new HashSet<>();
        // 先将问题分解成 五取一、五取二... 等的全排列
        for (int c = 1; c <= n; c++) {
            Set<Set<String>> combination = combination(m, new ArrayList<>(), c);
            System.out.println("==" + combination.size() + ",combination:" + combination);
            combinationAll.addAll(combination);
        }

        System.out.println(combinationAll);

    }

    private static Set<Set<String>> combination(List<String> remainEle, List<String> tempCollection, int fetchCount) {
        if (fetchCount == 1) {
            Set<Set<String>> eligibleCollections = new HashSet<>();
            // 在只差一个元素的情况下，遍历剩余元素为每个临时集合生成多个满足条件的集合
            for (String ele : remainEle) {
                Set<String> collection = new HashSet<>(tempCollection);
                collection.add(ele);
                eligibleCollections.add(collection);
            }
            return eligibleCollections;
        }

        fetchCount--;
        Set<Set<String>> result = new HashSet<>();
        // 差多个元素时，从剩余元素中取出一个，产生多个临时集合，还需要取 count-- 个元素。
        for (int i = 0; i < remainEle.size(); i++) {
            List<String> collection = new ArrayList<>(tempCollection);
            List<String> tempRemain = new ArrayList<>(remainEle);
            collection.add(tempRemain.remove(i));
            result.addAll(combination(tempRemain, collection, fetchCount));
        }
        return result;
    }


    public static void test_calcCombination() {

        System.out.println("===============");
        List<String> m = Arrays.asList("a");
        calcCombination(m);
        m = Arrays.asList("a", "b");
        calcCombination(m);
        m = Arrays.asList("a", "b", "c");
        calcCombination(m);
        m = Arrays.asList("a", "b", "c", "d");
        calcCombination(m);
        m = Arrays.asList("a", "b", "c", "d", "e");
        calcCombination(m);


        System.out.println("=======5个========");
        m = Arrays.asList("P7车主可见", "P7预定车主可见", "G3车主可见", "G3预定车主可见", "潜客可见");
        calcCombination(m);

        System.out.println("========7个=======");
        m = Arrays.asList("P7车主可见", "P7预定车主可见", "G3车主可见", "G3预定车主可见", "P5车主可见", "P5预定车主可见", "潜客可见");
        calcCombination(m);
    }

    public static void main(String[] args) {
        test_calcCombination();
    }
}
