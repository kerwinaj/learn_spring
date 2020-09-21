package com.yuk.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayUtil {
    public static void main(String[] args) {
        String[] array = {"a", "b", "c", "a", "b"};
        array2String(array);
        convertArray2List(array);
        convertArray2List_useStream(array);
        convertArray2Set_method1(array);
        convertArray2Set_method2(array);
    }


    public static void array2String(String[] array) {
        System.out.println("String: " + Arrays.toString(array));
    }

    public static List<String> convertArray2List(String[] array) {
        List<String> list = Arrays.asList(array);
        System.out.println("list: " + list);
        return list;
    }

    public static List<String> convertArray2List_useStream(String[] array) {
        List<String> list = Arrays.stream(array).collect(Collectors.toList());
        System.out.println("list: " + list);
        return list;
    }

    public static Set<String> convertArray2Set_method1(String[] array) {
        Set<String> set = new HashSet<>(convertArray2List(array));
        System.out.println("Set: " + set);
        return set;
    }

    public static Set<String> convertArray2Set_method2(String[] array) {
        Set<String> set = Arrays.stream(array).collect(Collectors.toSet());
        System.out.println("Set: " + set);
        return set;
    }

}
