package com.yuk.util;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 所有转换操作
 */
public class TransferUtil {

    /**
     * 将String按指定的分隔符split，返回一个大小可变动的List<String>
     */
    private static List<String> string2List(String s, String separatorChars, boolean checkDuplicated) {
        if (StringUtils.isBlank(s)) {
            return null;
        }
        if (StringUtils.isBlank(separatorChars)) {
            return null;
        }

        String[] ss = StringUtils.split(s, separatorChars);
        if (ss == null || ss.length == 0) {
            return null;
        }

        List<String> list = new LinkedList<>();
        for (String tem : ss) {
            if (StringUtils.isNotBlank(tem)) {
                if (checkDuplicated && !list.contains(tem)) {
                    list.add(tem.trim());
                } else {
                    list.add(tem.trim());
                }
            }
        }

        return list;
    }

    /**
     * 根据关键字加载提示信息转换为Set<String>，默认分隔符为半角逗号</br>
     * 配置格式为appid1,appid2,appid3</br>
     *
     * @return
     */
    public static Set<String> string2Set(String context) {
        // 根据分隔符获取数据
        return string2Set(context, ",");
    }

    /**
     * 根据关键字加载提示信息</br>
     * 配置格式为appid1,appid2,appid3</br>
     *
     * @return
     */
    public static Set<String> string2Set(String context, String separator) {
        Set<String> back = new HashSet<>();

        if (StringUtils.isBlank(context)) {
            return back;
        }
        if (StringUtils.isBlank(separator)) {
            return back;
        }

        // 根据分隔符获取数据
        String tokenLimitArray[] = context.split(separator);

        if (tokenLimitArray.length > 0) {
            for (String limit : tokenLimitArray) {
                if (StringUtils.isNotBlank(limit)) {
                    back.add(limit);
                }
            }
        }
        return back;
    }

    /**
     * 将Collection转换成String,默认分隔符为半角逗号</br>
     *
     * @param list
     * @return
     */
    public static String collection2String(Collection<String> list) {
        return collection2String(list, ",");
    }

    public static String collection2String(Collection<String> list, String separator) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (String tem : list) {
            if (first) {
                first = false;
            } else {
                sb.append(separator);
            }
            sb.append(tem);
        }
        return sb.toString();
    }

    public static String collection2String_method2(Collection<String> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        return String.join(",", list);
    }

    public static String collection2String_method3(Collection<String> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        String citiesCommaSeparated = list.stream().collect(Collectors.joining(","));
        return citiesCommaSeparated;
    }

    public static void test_collection2String() {
        Collection<String> collection = new HashSet<>();
        collection.add("111");
        collection.add("222");
        System.out.println(collection2String(collection));

        List<String> cities = Arrays.asList("Milan",
                "London",
                "New York",
                "San Francisco");
        System.out.println(collection2String_method2(cities));
        System.out.println(collection2String_method3(cities));
    }

    public static void main(String[] args) {
        test_collection2String();

    }
}
